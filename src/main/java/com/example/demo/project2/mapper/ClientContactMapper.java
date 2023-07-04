package com.example.demo.project2.mapper;

import com.example.demo.project2.entities.ClientContact;
import com.example.demo.project2.repositories.ClientRepository;
import com.example.demo.project2.views.ClientContactView;
import com.example.demo.project2.views.ClientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientContactMapper {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientContactMapper(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private List<ClientContact> mapContacts(ClientView clientView , List<ClientContactView> clientContactViews){
        return new ArrayList<>();
    }

}
