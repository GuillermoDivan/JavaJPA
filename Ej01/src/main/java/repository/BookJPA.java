package repository;
import entities.Author;
import entities.Book;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BookJPA extends JPA {

    public Book findById(Long id){
        Book b = em.find(Book.class, id);
        if (b != null ) { return b; } else { return null; }
    }

    public List<Book> findByTitle(String title){
        try{
        TypedQuery<Book> searchBooksByTitle =
                em.createQuery(" SELECT b FROM Book b WHERE title = '" + title + "'", Book.class);
        List<Book> booksByTitleList= searchBooksByTitle.getResultList();
        return booksByTitleList;
    } catch (Exception e) { throw e; }
    }

    public List<Book> findByAuthor(String author){
        try{
        TypedQuery<Book> searchBooksByAuthor =
                em.createQuery(" SELECT b FROM Book b WHERE author.name = '" + author + "'", Book.class);
        List<Book> booksByAuthorList= searchBooksByAuthor.getResultList();
        return booksByAuthorList;
    } catch (Exception e) { throw e; }
    }

    public List<Book> findByEditorial(String editorial) {
        try {
        TypedQuery<Book> searchBooksByEditorial =
                em.createQuery(" SELECT b FROM Book b WHERE editorial.name = '" + editorial + "'", Book.class);
        List<Book> booksByEditorialList = searchBooksByEditorial.getResultList();
        return booksByEditorialList;
    } catch (Exception e) { throw e; }
    }

    public void remove(Long id){
        Book b = em.find(Book.class, id);
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
    }




}
