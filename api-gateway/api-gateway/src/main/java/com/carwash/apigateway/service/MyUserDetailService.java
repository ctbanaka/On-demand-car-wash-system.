package com.carwash.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MyUserDetails userDetails;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user =restTemplate.getForObject("http://user-service/users/user/"+userName,User.class);
      if(user==null)
          throw new UsernameNotFoundException(userName +"not found");
        return userDetails;
    }
}
