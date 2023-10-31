package services;
import entities.Borrowing;
import entities.Client;
import jakarta.persistence.*;
import repository.ClientJPA;

import java.util.List;

public class ClientService {

    private ClientJPA clientJPA;

    public ClientService(ClientJPA clientJPA) {
        this.clientJPA = clientJPA;
    }

    public Client createClient(Long dni, String name, String lastname, String phone){
        Client c = new Client();
        c.setDni(dni);
        c.setName(name);
        c.setLastname(lastname);
        c.setPhone(phone);
        c.setActive(true);
        clientJPA.persist(c);
        return c;
    }

    public Client showClientById(Long id){
        Client client = clientJPA.findById(id);
        System.out.println(client);
        return client;
    }
}
