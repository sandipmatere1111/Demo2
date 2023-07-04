package com.example.demo.project2.services;

import com.example.demo.project2.entities.Users;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.UserRepository;
import com.example.demo.project2.views.UserView;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserView getUser(Integer id) throws RequestException {
        UserView userView = new UserView();
        Users user = userRepository.findUserById(id);
        if (user == null) {
            throw new RequestException("User Not Found");
        }
        userView.setId(user.getId());
        userView.setEmpId(user.getEmpId());
        userView.setFirstName(user.getFirstName());
        userView.setLastName(user.getLastName());
        userView.setFullName(user.getFullName());
        userView.setEmail(user.getEmail());
        userView.setPhoneNumber(user.getPhoneNumber());
        userView.setRole(user.getRole());

        return userView;
    }
}
