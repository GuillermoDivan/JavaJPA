import repository.*;
import services.*;

public class Main {
    public static void main(String[] args) throws Exception {
        EditorialJPA editorialJPA = new EditorialJPA();
        BookJPA bookJPA = new BookJPA();
        AuthorJPA authorJPA = new AuthorJPA();

        EditorialService es = new EditorialService(editorialJPA);
        BookService bs = new BookService(bookJPA);
        AuthorService as = new AuthorService(authorJPA);

        try {
            //es.createEditorial("Amorrortu");
            //es.updateEditorial(1L, "Argenta");
            //es.inactiveEditorial(1L);
            //es.reactiveEditorial(1L);
            //es.deleteEditorial(1L);
            //es.createEditorial("Amorrortu");
            //es.showEditorialById(1L);
            //es.showEditorialByName("Amorrortu");

        //as.createAuthor("Mario Benedetti");
        //as.updateAuthor(1L, "Isabel Allende");
        //as.inactiveAuthor(1L);
        //as.reactiveAuthor(1L);
        //as.deleteAuthor(1L);
        //as.createAuthor("Mario Benedetti");
        //as.showAuthorById(1L);
        //as.showAuthorByName(1L);

        //bs.createBook("La Tregua", 123, 123, 123, 123, as.showAuthorById(2L), es.showEditorialById(2L));
        //bs.createBook("Gracias por el fuego", 123, 123, 123, 123, as.showAuthorById(2L), es.showEditorialById(2L));
        //bs.createBook("Cuentos completos", 123, 123, 123, 123, as.showAuthorById(2L), es.showEditorialById(2L));
        //bs.createBook("Test para borrar", 123, 123, 123, 123, as.showAuthorById(2L), es.showEditorialById(2L));

        //bs.showBookById(1L);
        //bs.showBookByTitle("La Tregua");
        //bs.showBookByEditorial("Amorrortu");
        //bs.showBookByAuthor("Mario Benedetti");

        //bs.updateBook(3L, "Cuentos MUY completos", 123, 123, 123, 123, as.showAuthorById(2L), es.showEditorialById(2L));
        //bs.inactiveBook(3L);
        //bs.reactiveBook(3L);
        //bs.showBookById(3L);
        //bs.deleteBook(4L);
        //bs.showBookById(5L);
        } catch (Exception e) { throw e; }
    }
}
