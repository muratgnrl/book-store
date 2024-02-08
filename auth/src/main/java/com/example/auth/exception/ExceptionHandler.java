package com.example.auth.exception;

import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findException(FindException findException , WebRequest webRequest){
        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4001;
        meta.errorDescription="Kullanıcı bulunamadı";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> createUser(CreateException createException , WebRequest webRequest){
        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4011;
        meta.errorDescription="Kullanıcı oluşturulamadı";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteUser(DeleteUserException deleteUser , WebRequest webRequest){
        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4021;
        meta.errorDescription="Kullanıcı silinemedi";
        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
}
