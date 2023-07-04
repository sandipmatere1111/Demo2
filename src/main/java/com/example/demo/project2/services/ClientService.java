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
       if(client1.getClientName().equals(clientView.getClientName())){
          throw new RequestException("Client Name already exists");
       }
     }
     client.setClientName(clientView.getClientName());
     client.setCurrency(clientView.getCurrency());
     client.setBillingMethod(clientView.getBillingMethod());
//     client.setDeleted(clientView.getDeleted());

     clientRepository.save(client);
  }

    public void saveClientContacts(Integer clientId,List<ClientContactView> clientContactViews) throws RequestException {


        Client client = clientRepository.findClientById(clientId);
        if(client == null){
            throw new RequestException("Client not exists");
        }

        List<ClientContact> clientContactList = new ArrayList<>();
        List<Integer> clientContactIds = new ArrayList<>();
        for (ClientContactView clientContactView : clientContactViews) {
            ClientContact clientContact = new ClientContact();
            clientContact.setClient(client);
            clientContact.setId(clientContactView.getClientContactId());
            clientContact.setEmailId(clientContactView.getEmailId());
            clientContact.setFirstName(clientContactView.getFirstName());
            clientContact.setLastName(clientContactView.getLastName());
            clientContact.setPhone(clientContactView.getPhone());
            clientContact.setMobile(clientContactView.getMobile());
            clientContact.setFax(clientContactView.getFax());
            clientContactIds.add(clientContactView.getClientContactId());
            clientContactList.add(clientContact);
        }
        clientContactRepository.saveAll(clientContactList);
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
//     clientView.setDeleted(client.getDeleted());

     return clientView;
  }

  public Client updateClient (Integer id ,ClientView updatedClient) throws Exception{
     Client client = clientRepository.findClientById(id);
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

     clientRepository.save(client);
  }
}
