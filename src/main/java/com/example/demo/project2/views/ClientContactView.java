package com.example.demo.project2.views;

import lombok.Data;

import java.util.List;

@Data
public class ClientContactView {

    private Integer clientContactId;
//    private Integer clientId ;
    private String emailId;
    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String fax;
//    private List<Integer> clientIds;
}
