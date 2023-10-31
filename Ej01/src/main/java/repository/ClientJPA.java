package repository;

import entities.Borrowing;
import entities.Client;

public class ClientJPA extends JPA {

    public Client findById(Long id){
        Client client = em.find(Client.class, id);
        return client;
    }
}
