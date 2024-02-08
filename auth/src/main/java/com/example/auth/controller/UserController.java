package com.example.auth.controller;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.CreateException;
import com.example.auth.exception.DeleteUserException;
import com.example.auth.repository.UserRepository;
import com.example.auth.response.UserResponse;
import com.example.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserResponse> findUserByDto(@PathVariable(value = "userId") int userId){
        UserResponse findUser=userService.findUserByDto(userId);
        return ResponseEntity.ok(findUser);
    }
    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto userDto) throws CreateException {
        UserResponse userResponse=userService.createUser(userDto);
        return ResponseEntity.ok(userResponse);
    }
    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUser(){
        List<UserDto> getAllUser=userService.getAllUser();
        return getAllUser;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable(value = "userId") int userId) throws DeleteUserException {
        return ResponseEntity.ok(userService.delete(userId));
    }
}
