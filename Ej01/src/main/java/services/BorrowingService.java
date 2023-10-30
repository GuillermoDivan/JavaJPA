package services;
import repository.BorrowingJPA;

public class BorrowingService {

    private BorrowingJPA borrowingJPA;

    public BorrowingService(BorrowingJPA borrowingJPA) {
        this.borrowingJPA = borrowingJPA;


    }
}
