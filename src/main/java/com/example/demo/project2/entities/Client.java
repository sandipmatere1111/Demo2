package com.example.demo.project2.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String clientName;
    private String currency;
    private String billingMethod;
    private Boolean deleted;

}
