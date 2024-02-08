package com.example.auth.service;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.CreateException;
import com.example.auth.exception.DeleteUserException;
import com.example.auth.mapper.UserMapper;
import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse findUserByDto(int id) {
        User user=findUser(id);
        if (user!=null){
            UserResponse userResponse=new UserResponse();
            userResponse.meta=new Meta(200,"Kullanıcı bulundu");
            userResponse.user=userMapper.toResource(user);
            return userResponse;

        }else {
            throw new FindException();
        }
    }

    private User findUser(int userId) {
        User user=userRepository.findByUserId(userId);
        return user;
    }


    public UserResponse createUser(UserDto userDto) throws CreateException {
        User user=userMapper.toEntity(userDto);
        user = userRepository.save(user);

        if (user == null) {
            throw new CreateException();
        } else {
            UserResponse userResponse = new UserResponse();
            userResponse.meta = new Meta(200, "Kayıt başarılı");
            userResponse.user = userMapper.toResource(user);
            return userResponse;
        }
    }
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos=new ArrayList<>();

        Iterable<User> users= userRepository.findAll();
        for (User user : users){

            UserDto userDto=userMapper.toResource(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public UserResponse delete(int userId) throws DeleteUserException {
        User user=userRepository.findByUserId(userId);
        if (user!=null){
            userRepository.deleteByUserId(userId);
            UserResponse userResponse=new UserResponse();
            userResponse.meta=new Meta(200,"Silindi");
            userResponse.user=userMapper.toResource(user);
            return userResponse;
        }else {
            throw new DeleteUserException();
        }
    }
}
