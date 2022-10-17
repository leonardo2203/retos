package com.example.reto3ciclo3.services;

import com.example.reto3ciclo3.Modelo.Client;

import com.example.reto3ciclo3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client>getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient()==null){
            return clientRepository.save(client);
        }else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (e.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }


    public Client update(Client client){
        if (client.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(client.getIdClient());
            if (!q.isPresent()){
                if (client.getName() !=null) {
                    q.get().setName(client.getName());
                }if (client.getAge()!=null){
                    q.get().setAge(client.getAge());
                }if (client.getPassword()!=null){
                    q.get().setPassword(client.getPassword());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean deleteClient (int id){
        Boolean d =getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}
