package services;
import repository.BorrowingJPA;
import entities.*;
import java.time.LocalDateTime;
import java.util.List;

public class BorrowingService {

    private BorrowingJPA borrowingJPA;
    private BookService bookService;
    private ClientService clientService;

    public BorrowingService(BorrowingJPA borrowingJPA, BookService bookService, ClientService clientService) {
        this.borrowingJPA = borrowingJPA;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    public Borrowing saveBorrowing(Book book, Client client, LocalDateTime devolutionDate) throws RuntimeException {
        Borrowing bor = new Borrowing();
        Book b1 = bookService.showBookById(book.getIsbn());
        if (b1 != null) {
            bor.setBook(b1);
        } else {
            throw new RuntimeException();
        }
        Client c1 = clientService.showClientById(client.getId());
        if (c1 != null) {
            bor.setClient(c1);
        } else {
            throw new RuntimeException();
        }
        bor.setBorrowDate(LocalDateTime.now());
        bor.setDevolutionDate(devolutionDate);
        bor.setActive(true);
        borrowingJPA.persist(bor);
        return bor;
    }

    public Borrowing showBorrowingById(Long id) {
        Borrowing bor = borrowingJPA.findById(id);
        System.out.println(bor);
        return bor;
    }
}
    /*
    public List <Borrowing> showBorrowingByBookIdNow(Long bookId){
        LocalDateTime now = LocalDateTime.now();
        List <Borrowing> bor = borrowingJPA.findByBookIdNow(bookId, now);
        System.out.println(bor);
        return bor;
    }

    public List <Borrowing> showBorrowingByBookTitleNow(String bookTitle){
        LocalDateTime now = LocalDateTime.now();
        List <Borrowing> bor = borrowingJPA.findByBookTitleNow(bookTitle, now);
        System.out.println(bor);
        return bor;
    }

    public List <Borrowing> showBorrowingByClientIdNow(Long clientId){
        LocalDateTime now = LocalDateTime.now();
        List <Borrowing> bor = borrowingJPA.findByClientIdNow(clientId, now);
        System.out.println(bor);
        return bor;
    }

    public List <Borrowing> showBorrowingByDate(LocalDateTime date, boolean active){
        List <Borrowing> bor = borrowingJPA.findByIsBorrowed(date, active);
        System.out.println(bor);
        return bor;
    }

}

/*

    public Book updateBook(Long id, String title, int year, int copies, int borrowedCopies, int availableCopies, Author author, PublishingHouse publishingHouse) {
        Book  b = bookJPA.findById(id);
        if (title != null) { b.setTitle(title); }
         b.setYear(year);
         b.setCopies(copies);
         b.setBorrowedCopies(borrowedCopies);
         b.setAvailableCopies(availableCopies);
         b.setAuthor(author);
         b.setEditorial(publishingHouse);
         b.setActive(true);
        bookJPA.merge(b);
        return  b;
    }

    public boolean inactiveBook(Long id) {
        Book  b = bookJPA.findById(id);
        if (b.isActive()) {
        b.setActive(false);
        bookJPA.merge(b);
        return true; }
        else {return false; }
    }

    public boolean reactiveBook(Long id) {
        Book  b = bookJPA.findById(id);
        if (!b.isActive()) {
        b.setActive(true);
        bookJPA.merge(b);
        return true; }
        else {return false; }
    }

    public boolean deleteBook(Long id) {
        bookJPA.remove(id);
        return true;
    }
}
*/