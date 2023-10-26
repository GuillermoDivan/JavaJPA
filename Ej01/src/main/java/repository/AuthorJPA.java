package repository;
import entities.Author;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class AuthorJPA extends JPA {

    public Author findById(Long id){
        Author a = em.find(Author.class, id);
        if (a != null ) { return a; } else { return null; }
    }

    public Author findByName(String name) throws Exception{
        try {
            TypedQuery<Author> searchAuthorByName =
                    em.createQuery(" SELECT b FROM Author b WHERE name = '" + name + "'", Author.class);
            Author a = searchAuthorByName.getSingleResult();
            return a;
        } catch (Exception e) { throw e;  }
    }

    public void remove(Long id){
        Author a = em.find(Author.class, id);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

}
