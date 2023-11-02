import entities.*;
import repository.*;
import services.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PublishingHouseJPA publishingHouseJPA = new PublishingHouseJPA();
        BookJPA bookJPA = new BookJPA();
        AuthorJPA authorJPA = new AuthorJPA();
        BorrowingJPA borrowingJPA = new BorrowingJPA();
        ClientJPA clientJPA = new ClientJPA();

        PublishingHouseService es = new PublishingHouseService(publishingHouseJPA);
        AuthorService as = new AuthorService(authorJPA);
        BookService bs = new BookService(bookJPA, as, es);
        ClientService cs = new ClientService(clientJPA);
        BorrowingService bors = new BorrowingService(borrowingJPA, bs, cs, clientJPA);


            PublishingHouse p1 = es.createPublishingHouse("Amorrortu");
            //es.updatePublishingHouse(1L, "Argenta");
            //es.inactivePublishingHouse(1L);
            //es.reactivePublishingHouse(1L);
            //es.deletePublishingHouse(2L);
            //PublishingHouse Amo = es.createPublishingHouse("Amorrortu");
            //es.showPublishingHouseById(1L);
            //es.showPublishingHouseByName("Amorrortu");

        Author a1 = as.createAuthor("Julio Cortázar");
        //as.updateAuthor(1L, "Isabel Allende");
        //as.inactiveAuthor(1L);
        //as.reactiveAuthor(1L);
        //as.deleteAuthor(2L);
        //Author Mario = as.createAuthor("Mario Benedetti");
        //as.showAuthorById(1L);
        //as.showAuthorByName("Julio Cortázar");

       Book b1 = bs.createBook("Rayuela", 123, 123, 123, 123, a1, p1);
        //bs.createBook("Gracias por el fuego", 123, 123, 123, 123, "Mario Benedetti", "Amorrortu");
        //bs.createBook("Cuentos completos", 123, 123, 123, 123, "Mario Benedetti", "Amorrortu");
        //bs.createBook("Test para borrar", 123, 123, 123, 123, null, null);

        //bs.showBookById(1L);
        //bs.showBookByTitle("La Tregua");
        //bs.showBookByPublishingHouse("Amorrortu");
        //bs.showBookByAuthor("Mario Benedetti");

        //bs.updateBook(3L, "Cuentos MUY completos", 123, 123, 123, 123, as.showAuthorById(2L), es.showPublishingHouseById(2L));
        //bs.inactiveBook(3L);
        //bs.reactiveBook(3L);
        //bs.showBookById(3L);
        //bs.deleteBook(2L);
        //bs.showBookById(5L);

        Client c1 = cs.createClient(123L, "Cosme", "Fulanito", "123");
        //Client c1 = cs.updateClient(1L, 456L, "Natalia", "Natalia", "123");
        //cs.updateClientBorrowedBookList(1L, 1L);
        //cs.inactiveClient(1L);
        //cs.reactiveClient(1L);
        //cs.showClientById(1L);
        //cs.showClientByDni(123L);
       //cs.showClientByName("Cosme", "Fulanito");
        //cs.deleteClient(1L);

        Borrowing bor1 = bors.saveBorrowing(b1, c1);
        //bors.showBorrowingById(1L);
        //bors.showBorrowingByBookIdNow(1L);
        //bors.showBorrowingByBookTitleNow("Rayuela");
        //bors.showBorrowingByClientIdNow(1L);
        //LocalDateTime date = LocalDateTime.now().plusDays(7);
        //bors.showBorrowingByDateByActive(date, true);
        //bor1 = bors.updateBorrowing(1L, date, b1, c1);
        //bors.inactiveBorrowing(1L);
        //bors.reactiveBorrowing(1L);
        //bors.deleteBorrowing(1L);

    }
}
