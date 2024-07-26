package com.pranavv51.microservices.springsecurity.spring_security_driver.proxy;

import com.pranavv51.microservices.springsecurity.spring_security_driver.model.UserCredentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rds-driver")
public interface SaveUserproxy {

    @PostMapping(value = "rds-driverApp/add-user/")
    public String adduserCredentialsToDb(@RequestBody UserCredentials userModel);
}
