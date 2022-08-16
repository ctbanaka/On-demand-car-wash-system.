//package com.carwash.userservice.servicetest;
//
//import com.carwash.userservice.model.Gender;
//import com.carwash.userservice.model.Role;
//import com.carwash.userservice.model.UserDto;
//import com.carwash.userservice.repository.UserRepository;
//import com.carwash.userservice.service.UserServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class UserServiceTest {
//
//    @InjectMocks
//    private UserServiceImpl userService = new UserServiceImpl();
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    void testAddUser(){
//        UserDto user= new UserDto();
//        user.setUserName("max");
//        Gender gender=Gender.MALE;
//        user.setGender(gender);
//        Role role=Role.WASHER;
//        user.setRole(role);
//        user.setPhoneNo("8432012345");
//        user.setAge(23);
//        user.setFullName("chetan");
//        user.setEmail("chetan@gmail.com");
//        user.setPassword("hello");
//         when(userRepository.save(user));
//       assertEquals(user,userService.createUser(user));
//
//    }
//}
