package com.example.demo.project2.services;

import com.example.demo.project2.entities.Client;
import com.example.demo.project2.entities.ClientContact;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.ClientContactRepository;
import com.example.demo.project2.repositories.ClientRepository;
import com.example.demo.project2.views.ClientContactView;
import com.example.demo.project2.views.ClientView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

 private final ClientRepository clientRepository;
 private final ClientContactRepository clientContactRepository;

 public ClientService(ClientRepository clientRepository, ClientContactRepository clientContactRepository) {

     this.clientRepository = clientRepository;
     this.clientContactRepository = clientContactRepository;
 }

  public void saveClient(ClientView clientView) throws RequestException{
     Client client = new Client();
     List<Client> clientList = clientRepository.getAll();
     for(Client client1 : clientList){
       if(client1.getClientName().equalsIgnoreCase(clientView.getClientName())){
          throw new RequestException("Client Name already exists");
       }
     }
     client.setClientName(clientView.getClientName());
     client.setCurrency(clientView.getCurrency());
     client.setBillingMethod(clientView.getBillingMethod());
     client.setDeleted(false);
     clientRepository.save(client);
  }

    public void saveClientContacts(Integer clientId, ClientContactView clientContactView) throws RequestException {
        Client client = clientRepository.findClientById(clientId);
        if (client == null) {
            throw new RequestException("Client not exist");
        }

        List<ClientContact> clientContacts = clientContactRepository.findByClientId(clientId);

        for (ClientContact existingContact : clientContacts) {
            if (existingContact.getFirstName().equalsIgnoreCase(clientContactView.getFirstName())
                    && existingContact.getLastName().equalsIgnoreCase(clientContactView.getLastName())) {
                throw new RequestException("Client contact with this First and Last Name already exist");
            }
        }

        ClientContact newClientContact = new ClientContact();
        newClientContact.setClient(client);
        newClientContact.setEmailId(clientContactView.getEmailId());
        newClientContact.setFirstName(clientContactView.getFirstName());
        newClientContact.setLastName(clientContactView.getLastName());
        newClientContact.setPhone(clientContactView.getPhone());
        newClientContact.setMobile(clientContactView.getMobile());
        newClientContact.setFax(clientContactView.getFax());

        clientContactRepository.save(newClientContact);
    }


  public ClientView getClient(Integer id) throws RequestException{
     ClientView clientView = new ClientView();
     Client client = clientRepository.findClientById(id);
     if(client==null){
         throw new RequestException("Client Not Found");
     }
     List<ClientContact> clientContactsList = clientContactRepository.findByClientId(client.getId());

     clientView.setClientId(client.getId());
     clientView.setClientName(client.getClientName());
     clientView.setCurrency(client.getCurrency());
     clientView.setBillingMethod(client.getBillingMethod());
     clientView.setClientContacts(clientContactsList);

     return clientView;
  }

  public Client updateClient (ClientView updatedClient) throws Exception{
     Client client = clientRepository.findClientById(updatedClient.getClientId());
     if(client.getId()==null && client.getDeleted()){
         throw new RequestException("Client doesn't Exist");
     }
     client.setClientName(updatedClient.getClientName());
     client.setCurrency(updatedClient.getCurrency());
     client.setBillingMethod(updatedClient.getBillingMethod());

     clientRepository.save(client);
     return client;
  }

  public void deleteClient(Integer id) throws Exception{
     Client client = clientRepository.findClientById(id);

     if(client!=null && !client.getDeleted()){
         client.setDeleted(true);
     }else{
         throw new RequestException("Client doesn't Exist");
     }
      List<ClientContact> clientContactsList = clientContactRepository.findByClientId(client.getId());
     for(ClientContact clientContact : clientContactsList){
         if(!clientContact.getDeleted())
             deleteClientContact(clientContact.getId());
     }
     clientRepository.save(client);
  }

    public void deleteClientContact(Integer id) throws Exception{
        ClientContact clientContact = clientContactRepository.findClientContactById(id);

        if(clientContact!=null && !clientContact.getDeleted()){
            clientContact.setDeleted(true);
        }else{
            throw new RequestException("Client Contact not exist");
        }

        clientContactRepository.save(clientContact);
    }
}
