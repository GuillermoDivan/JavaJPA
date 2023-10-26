package services;
import entities.*;
import repository.BookJPA;
import java.util.List;

public class BookService {

    private BookJPA bookJPA;

    public BookService(BookJPA bookJPA) {
        this.bookJPA = bookJPA;
    }

    public Book createBook(String title, int year, int copies, int borrowedCopies, int availableCopies, Author author, Editorial editorial) {
        Book  b = new Book();
         b.setTitle(title);
         b.setYear(year);
         b.setCopies(copies);
         b.setBorrowedCopies(borrowedCopies);
         b.setAvailableCopies(availableCopies);
         b.setAuthor(author);
         b.setEditorial(editorial);
         b.setActive(true);
        bookJPA.persist(b);
        return  b;
    }

    public Book showBookById(Long id) {
        Book b = bookJPA.findById(id);
        System.out.println(b);
        return b;
    }

    public List<Book> showBookByTitle(String title) {
        List<Book> list = bookJPA.findByTitle(title);
        for (Book b : list) {
            System.out.println(b);
        }
        return list;
    }

    public List<Book> showBookByAuthor(String author) throws Exception{
        List<Book> list = bookJPA.findByAuthor(author);
        for (Book b : list) {
            System.out.println(b);
        }
        return list;
    }

    public List<Book>  showBookByEditorial(String editorial) throws Exception{
        List<Book> list = bookJPA.findByEditorial(editorial);
        for (Book b : list) {
            System.out.println(b);
        }
        return list;
    }

    public Book updateBook(Long id, String title, int year, int copies, int borrowedCopies, int availableCopies, Author author, Editorial editorial) {
        Book  b = bookJPA.findById(id);
         b.setTitle(title);
         b.setYear(year);
         b.setCopies(copies);
         b.setBorrowedCopies(borrowedCopies);
         b.setAvailableCopies(availableCopies);
         b.setAuthor(author);
         b.setEditorial(editorial);
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
