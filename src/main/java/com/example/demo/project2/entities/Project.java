package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Project {

    @Id
    private int id;

    //this is foreign key
    private int clientId;

    private String projectName;

    private int projectHead;

    private int projectManager;

}
