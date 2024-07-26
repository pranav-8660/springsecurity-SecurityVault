package com.pranavv51.microservices.springsecurity.spring_security_driver.service;

import com.pranavv51.microservices.springsecurity.spring_security_driver.model.UserCredentials;
import com.pranavv51.microservices.springsecurity.spring_security_driver.proxy.FetchUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsmanagerUd implements UserDetailsService {

    @Autowired
    private FetchUserProxy fetchUserProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials auser = fetchUserProxy.fetchUser(username);
        if(auser==null){
            throw new UsernameNotFoundException("User "+username+" is not registered with the Security-Vault!\nTry again with other credentials");
        }
        else{
            return User.builder()
                    .username(auser.getUsername())
                    .password(auser.getPassword())
                    .roles(auser.getRole())
                    .build();
        }
    }
}
