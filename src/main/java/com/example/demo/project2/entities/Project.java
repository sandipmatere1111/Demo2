package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clientId;

    private String projectName;

    private String projectHead;

    private String projectManager;

    private Boolean deleted;

}
