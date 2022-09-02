package com.carwash.washerservice.model;

import lombok.Data;

@Data
public class WasherDto {

    private int userId;
    private String userName;
    private String fullName;
    private Gender gender;
    private String phoneNo;
    private String email;
    private int age;
    private Boolean isActive;

}
