package repository;
import entities.Borrowing;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class BorrowingJPA extends JPA {

    public Borrowing findById(Long id) {
        Borrowing bor = em.find(Borrowing.class, id);
        return bor;
    }

    public List <Borrowing> findByBookIdNow(Long bookId, LocalDateTime date) {
        TypedQuery<Borrowing> searchBorrowingByBookIdNow =
                em.createQuery(" SELECT b FROM Borrowing b WHERE book.id = " + bookId + " AND borrowDate <= '" + date
                        + "' AND devolutionDate >= '" + date + "'", Borrowing.class);
        List<Borrowing> bor = searchBorrowingByBookIdNow.getResultList();
        return bor;
    }

    public List <Borrowing> findByBookTitleNow(String bookName, LocalDateTime date) {
        TypedQuery<Borrowing> searchBorrowingByBookTitleNow =
                em.createQuery(" SELECT b FROM Borrowing b WHERE book.title = '" + bookName + "' AND borrowDate <= '" + date
                        + "' AND devolutionDate >= '" + date + "'", Borrowing.class);
        List<Borrowing> bor = searchBorrowingByBookTitleNow.getResultList();
        return bor;
    }

    public List <Borrowing> findByClientIdNow(Long clientId, LocalDateTime date) {
        TypedQuery<Borrowing> searchBorrowingByClientIdNow =
                em.createQuery(" SELECT b FROM Borrowing b WHERE client.id = " + clientId  + " AND borrowDate <= '" + date
                        + "' AND devolutionDate >= '" + date + "'", Borrowing.class);
        List<Borrowing> bor = searchBorrowingByClientIdNow.getResultList();
        return bor;
    }

    public List <Borrowing> findByIsBorrowed(LocalDateTime date, boolean active){
        TypedQuery<Borrowing> searchBorrowingByDateByActive =
                em.createQuery(" SELECT b FROM Borrowing b WHERE borrowDate <= '" + date
                        + "' AND devolutionDate >= '" + date + "' AND active = " + active + "" , Borrowing.class);
        List<Borrowing> bor = searchBorrowingByDateByActive.getResultList();
        return bor;
    }

    public void remove(Long id){
        Borrowing bor = em.find(Borrowing.class, id);
        em.getTransaction().begin();
        em.merge(bor);
        em.getTransaction().commit();
    }


}
