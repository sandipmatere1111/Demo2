package com.example.demo.project2.services;

import com.example.demo.project2.entities.Client;
import com.example.demo.project2.entities.Users;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.UserRepository;
import com.example.demo.project2.views.UserView;
import org.springframework.security.core.userdetails.User;
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

    public void saveUser(UserView userView) throws RequestException {
        Users user = userRepository.findUserById(userView.getId());

        if (user != null) {
            throw new RequestException("User already exists");
        }

        user = new Users();
        user.setEmpId(userView.getEmpId());
        user.setFirstName(userView.getFirstName());
        user.setLastName(userView.getLastName());
        user.setFullName(userView.getFullName());
        user.setEmail(userView.getEmail());
        user.setPassword(userView.getPassword());
        user.setPhoneNumber(userView.getPhoneNumber());
        user.setRole(userView.getRole());

        userRepository.save(user);
    }

    public void deleteUser(Integer id) throws RequestException {
        Users user = userRepository.findUserById(id);

        if(user!=null && !user.getDelete()){
            user.setDelete(true);
        }else{
            throw new RequestException("User doesn't Exist");
        }
        userRepository.save(user);
    }
}
