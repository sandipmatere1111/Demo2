package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Task {

    @Id
    private int id;

    // Foreign key
    private int projectId;

    private String taskName;
}
