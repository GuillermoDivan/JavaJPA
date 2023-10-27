package repository;
import entities.PublishingHouse;
import jakarta.persistence.TypedQuery;

public class PublishingHouseJPA extends JPA {

    public PublishingHouse findById(Long id){
        PublishingHouse e = em.find(PublishingHouse.class, id);
        if (e != null ) { return e; } else { return null; }
    }

    public PublishingHouse findByName(String name) {
        try {
            TypedQuery<PublishingHouse> searchPublishingHouseByName =
                    em.createQuery(" SELECT b FROM PublishingHouse b WHERE name = '" + name + "'", PublishingHouse.class);
            PublishingHouse e = searchPublishingHouseByName.getSingleResult();
            return e;
        } catch (Exception x) {
            throw x;
        }
    }

    public void remove(Long id){
        PublishingHouse e = em.find(PublishingHouse.class, id);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
}
