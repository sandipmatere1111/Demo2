package com.example.demo.project2.views;

import lombok.Data;

@Data
public class UserView {

    private Integer id;

    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
}
