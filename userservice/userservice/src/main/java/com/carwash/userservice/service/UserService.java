package com.carwash.userservice.service;

import com.carwash.userservice.model.User;
import com.carwash.userservice.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(UserDto userDto);

    Optional<User> gatUserByUserName(String userName);

    List<User> getAllUsers();

    Optional<List<User>> getUsersByRole(String role);

    void updateUser(UserDto userDto);

    void deleteUser(String userName);

    Integer createAdmin(UserDto userDto);
}
