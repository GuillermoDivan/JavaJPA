package services;
import entities.Author;
import repository.AuthorJPA;

public class AuthorService {

    private AuthorJPA authorJPA;

    public AuthorService(AuthorJPA authorJPA) {
        this.authorJPA = authorJPA;
    }

    public Author createAuthor(String name){
        Author a = new Author();
        a.setName(name);
        a.setActive(true);
        authorJPA.persist(a);
        return a;
    }

    public Author showAuthorById(Long id){
        Author a = authorJPA.findById(id);
        System.out.println(a);
        return a; }

    public Author showAuthorByName(String name) throws Exception{
        Author a = authorJPA.findByName(name);
        System.out.println(a);
        return a; }

    public Author updateAuthor(Long id, String name){
        Author a = authorJPA.findById(id);
        a.setName(name);
        authorJPA.merge(a);
        return a;
    }

    public boolean inactiveAuthor(Long id) {
        Author a = authorJPA.findById(id);
        if (a.isActive()) {
            a.setActive(false);
            authorJPA.merge(a);
            return true; }
        else {return false; }
    }

    public boolean reactiveAuthor(Long id) {
        Author a = authorJPA.findById(id);
        if (!a.isActive()) {
            a.setActive(true);
            authorJPA.merge(a);
            return true; }
        else {return false; }
    }

    public boolean deleteAuthor(Long id){
        authorJPA.remove(id);
        return true;
    }
}
