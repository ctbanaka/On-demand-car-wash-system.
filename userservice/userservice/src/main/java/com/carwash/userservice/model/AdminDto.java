package com.carwash.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private String userName;
    private String fullName;
    private Gender gender;
    private Integer age;
    private String phoneNo;
    private String email;
    private String password;
}
