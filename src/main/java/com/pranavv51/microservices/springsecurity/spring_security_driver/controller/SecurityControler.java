package com.pranavv51.microservices.springsecurity.spring_security_driver.controller;


import com.pranavv51.microservices.springsecurity.spring_security_driver.model.UserCredentials;
import com.pranavv51.microservices.springsecurity.spring_security_driver.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
        return "userpage";
    }

    @GetMapping("admin/control-board")
    public String sayHelloadmin(){
        return "adminpage";
    }



    // http://localhost:8745/user/register/
    @PostMapping(value = "register/")
    public String registerUser(@RequestBody UserCredentials userCred){
        return passwordServiceInst.saveUsersCredentials(userCred);
    }

}
