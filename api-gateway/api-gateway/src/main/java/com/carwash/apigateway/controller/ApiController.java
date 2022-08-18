package com.carwash.apigateway.controller;

import com.carwash.apigateway.model.AuthenticationRequest;
import com.carwash.apigateway.model.AuthenticationResponse;
import com.carwash.apigateway.model.User;
import com.carwash.apigateway.service.MyUserDetailService;
import com.carwash.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class ApiController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/{userName}")
    public User first2Page(@PathVariable String userName) {
        return restTemplate.getForObject("http://localhost:8081/users/user/"+userName, User.class);
    }

    @GetMapping("/hello")
    public String firstPage() {
        return "Hello World";
    }



    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}



