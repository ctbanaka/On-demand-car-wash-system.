package com.carwash.userservice.controller;

import com.carwash.userservice.model.User;
import com.carwash.userservice.model.UserDto;
import com.carwash.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/signup")
    public ResponseEntity<String> createCustomer(@RequestBody UserDto user){
        userService.createUser(user);
        return new ResponseEntity<>("registered successfully", HttpStatus.OK);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<Optional<User>>getUserByUserName(@PathVariable String userName){
       Optional<User> user= userService.gatUserByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers(){
     List<User> users = userService.getAllUsers();
     return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/users/{role}")
    public ResponseEntity<Optional<List<User>>> getUsersByRoles(@PathVariable String role){
        Optional<List<User>> users = userService.getUsersByRole(role);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/userupdate")
    public ResponseEntity<String> updateUser(@RequestBody  UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>("account updated successfully", HttpStatus.OK);
    }

   @DeleteMapping("/user/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
   }

   @PostMapping("/user/admin-signup")
   public ResponseEntity<String> createAdmin(@RequestBody UserDto userDto){
       String username=userService.createAdmin(userDto);
       return new ResponseEntity<>("admin account created with id "+username,HttpStatus.OK);
   }
}
