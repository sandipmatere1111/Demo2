package com.example.demo.project2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    @Column(name = "client_id", insertable = false, updatable = false)
//    private Integer clientId;

    private String projectName;

    private String projectHead;

    private String projectManager;

    @JsonIgnore
    private Boolean deleted;

}
