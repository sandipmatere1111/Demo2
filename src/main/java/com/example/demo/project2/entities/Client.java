package com.example.demo.project2.entities;

import com.example.demo.project2.views.BillingMethod;
import com.example.demo.project2.views.CurrencyType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Enumerated(EnumType.STRING)
    private BillingMethod billingMethod;

//    @JsonIgnore
//    @OneToMany(mappedBy = "client")
//    private List<Project> projects;

    private Boolean deleted;

}
