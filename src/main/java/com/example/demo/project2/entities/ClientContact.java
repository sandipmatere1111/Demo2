package com.example.demo.project2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClientContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    @Column(name = "client_id", insertable = false, updatable = false)
    private Integer clientId;

    private String emailId;
    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String fax;
    private Boolean deleted;
}
