package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TaskAssignee {

    @Id
    private int id;

    // Foreign keys
    private int taskId;
    private int userId;
}
