package com.example.demo.project2.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Integer empId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private Boolean delete;
}
