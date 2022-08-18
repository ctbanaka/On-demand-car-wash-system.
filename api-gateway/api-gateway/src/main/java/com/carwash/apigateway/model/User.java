package com.carwash.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    private int userId;
    private String userName;
    private String fullName;
    private Gender gender;
    private String phoneNo;
    private String email;
    private String password;
    private int age;
    private String role;
    private Boolean isActive;

}
