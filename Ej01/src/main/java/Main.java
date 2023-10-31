import entities.*;
import repository.*;
import services.*;

import java.time.LocalDateTime;

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
        BorrowingService bors = new BorrowingService(borrowingJPA, bs, cs);

            PublishingHouse p1 = es.createPublishingHouse("Amorrortu");
            //es.updatePublishingHouse(1L, "Argenta");
            //es.inactivePublishingHouse(1L);
            //es.reactivePublishingHouse(1L);
            //es.deletePublishingHouse(2L);
            //PublishingHouse Amo = es.createPublishingHouse("Amorrortu");
            //es.showPublishingHouseById(1L);
            //es.showPublishingHouseByName("Amorrortu");

        Author a1 = as.createAuthor("Mario Benedetti");
        //as.updateAuthor(1L, "Isabel Allende");
        //as.inactiveAuthor(1L);
        //as.reactiveAuthor(1L);
        //as.deleteAuthor(2L);
        //Author Mario = as.createAuthor("Mario Benedetti");
        //as.showAuthorById(1L);
        //as.showAuthorByName("Mario Benedetti");

       Book b1 = bs.createBook("La Tregua", 123, 123, 123, 123, a1, p1);
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

        Borrowing bor1 = bors.saveBorrowing(b1, c1, LocalDateTime.now().plusDays(7));
        bors.showBorrowingById(bor1.getId());
    }
}
