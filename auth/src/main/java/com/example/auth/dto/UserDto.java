package com.example.auth.dto;



import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {

    private int UserId;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
}
