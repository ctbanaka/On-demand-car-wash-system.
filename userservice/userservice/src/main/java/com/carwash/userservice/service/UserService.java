package com.carwash.userservice.service;

import com.carwash.userservice.model.LoginResponse;
import com.carwash.userservice.model.User;
import com.carwash.userservice.model.UserDto;
import com.carwash.userservice.model.UserDtos;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(UserDto userDto);

    UserDtos gatUserByUserName(String userName);

    List<UserDtos> getAllUsers();

    String updateUser(UserDto userDto);

    void deleteUser(String userName);

    String createAdmin(UserDto userDto);

    LoginResponse userLoginResponse(String userName);

    Boolean userExistByUserName(String userName);
}
