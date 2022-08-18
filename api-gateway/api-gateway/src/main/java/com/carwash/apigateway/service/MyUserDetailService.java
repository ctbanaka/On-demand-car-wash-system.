package com.carwash.apigateway.service;

import com.carwash.apigateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = restTemplate.getForObject("http://localhost:8081/users/user/"+userName, User.class);
        if (user == null)
            throw new UsernameNotFoundException(userName + "not found");
        UserDetails userDetails=new MyUserDetails(user);
        return userDetails;
    }
}