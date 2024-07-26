package com.pranavv51.microservices.springsecurity.spring_security_driver.service;


import com.pranavv51.microservices.springsecurity.spring_security_driver.model.UserCredentials;
import com.pranavv51.microservices.springsecurity.spring_security_driver.proxy.SaveUserproxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {


    @Autowired
    private SaveUserproxy saveUserproxy;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String saveUsersCredentials(UserCredentials userCredentials){
        userCredentials.setPassword(encoder.encode(userCredentials.getPassword()));
        return saveUserproxy.adduserCredentialsToDb(userCredentials);
    }

}
