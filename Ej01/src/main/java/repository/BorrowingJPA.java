package repository;
import entities.Borrowing;

public class BorrowingJPA extends JPA {

    public Borrowing findById(Long id){
        Borrowing bor = em.find(Borrowing.class, id);
        return bor;
    }

}
