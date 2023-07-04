package com.example.demo.project2.controllers;

import com.example.demo.project2.entities.Client;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.ClientRepository;
import com.example.demo.project2.services.ClientService;
import com.example.demo.project2.views.ClientContactView;
import com.example.demo.project2.views.ClientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    // Get all clients             done
    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients() throws RequestException{
        List<Client> clients = clientRepository.getAll();
        if (clients.isEmpty()) {
            throw new RequestException("No clients found");
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Get client by id           done
    @GetMapping("/getClient")
    public ClientView getClientById(@RequestParam Integer id) throws RequestException {
        ClientView clientView = clientService.getClient(id);
        return clientView;
    }


    // Add a new client            done
    @PostMapping("/saveClient")
    public void saveClient(@RequestBody ClientView clientView) throws RequestException {
        clientService.saveClient(clientView);
    }

    //Save Client Contact deatails
    @PostMapping("/saveClientContact")
    public ClientView saveClientContacts(@RequestParam Integer clientId,@RequestBody List<ClientContactView> clientContactViews) throws RequestException {
        clientService.saveClientContacts(clientId,clientContactViews);
        return clientService.getClient(clientId);
    }

    // Update an existing client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestParam Integer id, @RequestBody ClientView updatedClient) throws Exception{
          Client client = clientService.updateClient(id , updatedClient);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    // delete Client       Done
    @DeleteMapping("/deleteClient")
    public ResponseEntity<String> deleteClient(@RequestParam Integer id) throws Exception{

        clientService.deleteClient(id);
        return new ResponseEntity<>("Client deleted successfully", HttpStatus.OK);
    }
}
