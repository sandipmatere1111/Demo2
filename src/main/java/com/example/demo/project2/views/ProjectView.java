package com.example.demo.project2.views;

import lombok.Data;

@Data
public class ProjectView {

    private Integer id;

    //this is foreign key
    private Integer clientId;

    private String projectName;

    private String projectHead;

    private String projectManager;
}
