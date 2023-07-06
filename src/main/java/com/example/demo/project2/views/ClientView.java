package com.example.demo.project2.views;

import com.example.demo.project2.entities.Client;
import com.example.demo.project2.entities.ClientContact;
import lombok.Data;

import java.util.List;

@Data
public class ClientView {
    private Integer clientId;

    private String clientName;
    private CurrencyType currency;
    private BillingMethod billingMethod;
    private List<ClientContact> clientContacts;
}
