package com.pranavv51.microservices.springsecurity.spring_security_driver.proxy;

import com.pranavv51.microservices.springsecurity.spring_security_driver.model.UserCredentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rds-driver")
public interface FetchUserProxy {

    // http://localhost:8950/rds-driver/fetch-user-cred/{}
    @GetMapping(value = "rds-driver/fetch-user-cred/{uname}")
    public UserCredentials fetchUser(@PathVariable("uname") String username);
}
