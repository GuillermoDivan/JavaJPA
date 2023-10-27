package services;
import entities.*;
import repository.BookJPA;
import java.util.List;
import java.util.Scanner;

public class BookService {

    private Scanner input = new Scanner(System.in).useDelimiter("\n");
    private BookJPA bookJPA;
    private AuthorService authorService;
    private PublishingHouseService publishingHouseService;

    public BookService(BookJPA bookJPA, AuthorService authorService, PublishingHouseService publishingHouseService) {
        this.bookJPA = bookJPA;
        this.authorService = authorService;
        this.publishingHouseService = publishingHouseService;
    }

    public Book createBook(String title, int year, int copies, int borrowedCopies,
                           int availableCopies, Author author, PublishingHouse publishingHouse) throws Exception {
        Book  b = new Book();
         b.setTitle(title);
         b.setYear(year);
         b.setCopies(copies);
         b.setBorrowedCopies(borrowedCopies);
         b.setAvailableCopies(availableCopies);

         if (author == null){
             System.out.println("Ingrese el nombre del autor");
             String authorName = input.next();
         Author a1 = authorService.createAuthor(authorName);
         b.setAuthor(a1);
         } else { b.setAuthor(author);
         }

        if (publishingHouse == null ){
            System.out.println("Ingrese el nombre de la editorial");
            String publishingHouseName = input.next();
            PublishingHouse e1 = publishingHouseService.createPublishingHouse(publishingHouseName);
            b.setEditorial(e1);
        } else {b.setEditorial(publishingHouse);
        }

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

    public List<Book>  showBookByPublishingHouse(String PublishingHouse) throws Exception{
        List<Book> list = bookJPA.findByPublishingHouse(PublishingHouse);
        for (Book b : list) {
            System.out.println(b);
        }
        return list;
    }

    public Book updateBook(Long id, String title, int year, int copies, int borrowedCopies, int availableCopies, Author author, PublishingHouse publishingHouse) {
        Book  b = bookJPA.findById(id);
         b.setTitle(title);
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
