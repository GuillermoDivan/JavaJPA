package repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public abstract class JPA {

    jakarta.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
    EntityManager em = emf.createEntityManager();

    public void persist(Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public void merge(Object o) {
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
    }

}
