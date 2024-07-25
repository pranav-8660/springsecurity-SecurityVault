package com.pranavv51.microservices.springsecurity.spring_security_driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringSecurityDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDriverApplication.class, args);
	}

}
