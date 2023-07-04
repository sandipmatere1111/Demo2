package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProjectUsers {

    @Id
    private int id;

    // Foreign keys
    private int projectId;
    private int userId;
}
