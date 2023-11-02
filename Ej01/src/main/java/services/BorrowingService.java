package services;
import repository.BorrowingJPA;
import entities.*;
import repository.ClientJPA;

import java.time.LocalDateTime;
import java.util.List;

public class BorrowingService {

    private BorrowingJPA borrowingJPA;
    private BookService bookService;
    private ClientService clientService;
    private ClientJPA clientJPA;

    public BorrowingService(BorrowingJPA borrowingJPA, BookService bookService,
                            ClientService clientService, ClientJPA clientJPA) {
        this.borrowingJPA = borrowingJPA;
        this.bookService = bookService;
        this.clientService = clientService;
        this.clientJPA = clientJPA;
    }

    public Borrowing saveBorrowing(Book book, Client client) throws RuntimeException {
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
        bor.setDevolutionDate(LocalDateTime.now().plusDays(14));
        bor.setActive(true);
        borrowingJPA.persist(bor);
        return bor;
    }

    public Borrowing showBorrowingById(Long id) {
        Borrowing bor = borrowingJPA.findById(id);
        System.out.println(bor);
        return bor;
    }

    public List <Borrowing> showBorrowingByBookIdNow(Long bookId){
        LocalDateTime now = LocalDateTime.now();
        List <Borrowing> bor = borrowingJPA.findByBookIdNow(bookId, now);
        for (Borrowing b : bor) {
            System.out.println(b);
        }
        return bor;
    }

    public List <Borrowing> showBorrowingByBookTitleNow(String bookTitle){
        LocalDateTime now = LocalDateTime.now();
        List <Borrowing> bor = borrowingJPA.findByBookTitleNow(bookTitle, now);
        for (Borrowing b : bor) {
            System.out.println(b);
        }
        return bor;
    }

    public List <Borrowing> showBorrowingByClientIdNow(Long clientId){
        LocalDateTime now = LocalDateTime.now();
        List <Borrowing> bor = borrowingJPA.findByClientIdNow(clientId, now);
        System.out.println(bor);
        return bor;
    }

    public List <Borrowing> showBorrowingByDateByActive(LocalDateTime date, boolean active){
        List <Borrowing> bor = borrowingJPA.findByIsBorrowed(date, active);
        for (Borrowing b : bor) {
            System.out.println(b);
        }
        return bor;
    }

    public Borrowing updateBorrowing(Long id, LocalDateTime devolutionDate, Book book, Client client) {
        Borrowing bor = borrowingJPA.findById(id);
        if (devolutionDate != null) { bor.setDevolutionDate(devolutionDate); }
        if (book != null) { bor.setBook(book); }
        if (client != null) { bor.setClient(client); }
        borrowingJPA.merge(bor);
        return bor;
    }

    public boolean inactiveBorrowing(Long id) {
        Borrowing bor = borrowingJPA.findById(id);
        if (bor.isActive()) {
        bor.setActive(false);
        borrowingJPA.merge(bor);
        return true; }
        else {return false; }
    }

    public boolean reactiveBorrowing(Long id) {
        Borrowing bor = borrowingJPA.findById(id);
        if (!bor.isActive()) {
            bor.setActive(true);
            borrowingJPA.merge(bor);
            return true; }
        else {return false; }
    }

    public boolean deleteBorrowing(Long id) {
        borrowingJPA.remove(id);
        return true;
    }
}