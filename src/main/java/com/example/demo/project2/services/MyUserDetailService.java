package com.example.demo.project2.services;

import com.example.demo.project2.entities.Users;
import com.example.demo.project2.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("Sandip")){
            return new User("Sandip","Sandip@123",new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("User Not Found");
        }
    }
}
