package com.pranavv51.microservices.springsecurity.spring_security_driver.config;


import com.pranavv51.microservices.springsecurity.spring_security_driver.service.UserDetailsmanagerUd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigClass {

    @Autowired
    private UserDetailsmanagerUd userDetailsmanagerUd;


    @Bean
    public UserDetailsService userDetailsService(){
        /*UserDetails allUsers = User.builder()
                .username("pranav-8660")
                .password("$2a$12$HwJiwJvVpGvyQZpLkkOGs.ldGg36R1ikR9cr6j95tZgzWEKF5.5eK")
                //.passwordEncoder(str->passwordEncoder().encode(str))
                .roles("USER")
                .build();

        UserDetails allAdmins = User.builder()
                .username("admin-head")
                .password("$2a$12$vpniAZJ9c2s9gSDrDfZdeuDEDCmBc8VZzUK9IcWfA.0KMAQ7ZrhUu")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(allUsers,allAdmins);*/

        return userDetailsmanagerUd;
    }

    @Bean
    public AuthenticationProvider provideAuthentication(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsmanagerUd);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain allsecurityFilters(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                    registry->{
                        registry.requestMatchers("home/**","register/").permitAll();
                        registry.requestMatchers("users/**").hasRole("USER");
                        registry.requestMatchers("admin/**").hasRole("ADMIN");
                        registry.anyRequest().authenticated();
                    }
        ).formLogin(temp->temp.permitAll());

        return httpSecurity.build();
    }

}
