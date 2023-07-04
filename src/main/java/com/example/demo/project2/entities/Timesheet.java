package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Timesheet {

    @Id
    private int id;

    private String date;
    private String projectName;
    private String taskName;
    private String workItem;
    private String description;
    private double hours;
}
