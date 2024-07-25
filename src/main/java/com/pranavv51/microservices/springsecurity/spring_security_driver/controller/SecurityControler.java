package com.pranavv51.microservices.springsecurity.spring_security_driver.controller;


import com.pranavv51.microservices.springsecurity.spring_security_driver.service.PasswordService;
import com.pranavv51.microservices.springsecurity.spring_security_driver.service.UserDetailsmanagerUd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityControler {

    private final PasswordService passwordServiceInst;

    public SecurityControler(PasswordService passwordServiceInst) {
        this.passwordServiceInst = passwordServiceInst;
    }


    @GetMapping("home/")
    @ResponseBody
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("HI, hello visitor!");
    }

    // http://localhost:8080/user/dashboard
    @GetMapping("user/dashboard")
    public String sayHellouser(){
        return "hi";
    }

    @GetMapping("admin/control-board")
    @ResponseBody
    public ResponseEntity<String> sayHelloadmin(){
        return ResponseEntity.ok("HI, hello admin!");
    }


    @PostMapping(value = "user/register/")
    public void registerUser(@RequestBody UserDetailsmanagerUd userCred){
        
    }

}
