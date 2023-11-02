package repository;
import entities.Client;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClientJPA extends JPA {

    public Client findById(Long id){
        Client client = em.find(Client.class, id);
        return client;
    }

    public Client findByDni(Long dni) {
        TypedQuery<Client> searchClientByName =
                em.createQuery(" SELECT c FROM Client c WHERE dni = '" + dni + "'", Client.class);
        Client c = searchClientByName.getSingleResult();
        return c;
    }

    public List <Client> findByName(String name, String lastname) {
        TypedQuery<Client> searchClientByName =
                em.createQuery(" SELECT c FROM Client c WHERE name = '" + name + "' and lastname = '" + lastname + "'", Client.class);
        List<Client> c = searchClientByName.getResultList();
        return c;
    }

    public void remove(Long id){
        Client c1 = em.find(Client.class, id);
        em.getTransaction().begin();
        em.remove(c1);
        em.getTransaction().commit();
    }
}
