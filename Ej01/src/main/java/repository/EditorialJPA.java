package repository;
import entities.Author;
import entities.Editorial;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EditorialJPA extends JPA {

    public Editorial findById(Long id){
        Editorial e = em.find(Editorial.class, id);
        if (e != null ) { return e; } else { return null; }
    }

    public Editorial findByName(String name) {
        try {
            TypedQuery<Editorial> searchEditorialByName =
                    em.createQuery(" SELECT b FROM Editorial b WHERE name = '" + name + "'", Editorial.class);
            Editorial e = searchEditorialByName.getSingleResult();
            return e;
        } catch (Exception x) {
            throw x;
        }
    }

    public void remove(Long id){
        Editorial e = em.find(Editorial.class, id);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
}
