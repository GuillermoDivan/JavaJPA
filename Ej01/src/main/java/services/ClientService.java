package services;
import entities.Borrowing;
import entities.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import repository.ClientJPA;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
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

    public Client showClientByDni(Long dni){
        Client client = clientJPA.findByDni(dni);
        System.out.println(client);
        return client;
    }

    public List <Client> showClientByName(String name, String lastname){
        List <Client> clientList = clientJPA.findByName(name, lastname);
        for (Client c : clientList) {
            System.out.println(c);
        }
        return clientList;
    }

    public Client updateClient(Long id, Long dni, String name, String lastname, String phone){
        Client c = clientJPA.findById(id);
        c.setDni(dni);
        c.setName(name);
        c.setLastname(lastname);
        c.setPhone(phone);
        clientJPA.merge(c);
        return c;
    }

    /*public Client updateClientBorrowedBookList(Client client, Borrowing borrowing){
        List <Borrowing> borList = client.getBorrowingList();
        if (borList == null) { borList = new ArrayList<Borrowing>(); }
        borList.add(borrowing);
        client.setBorrowingList(borList);
        clientJPA.merge(client);
        return client;
    }*/

    public boolean inactiveClient(Long id) {
        Client c = clientJPA.findById(id);
        if (c.isActive()) {
            c.setActive(false);
            clientJPA.merge(c);
            return true; }
        else {return false; }
    }

    public boolean reactiveClient(Long id) {
        Client c = clientJPA.findById(id);
        if (!c.isActive()) {
            c.setActive(true);
            clientJPA.merge(c);
            return true; }
        else {return false; }
    }

    public boolean deleteClient(Long id){
        clientJPA.remove(id);
        return true;
    }

}
