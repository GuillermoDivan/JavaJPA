package services;
import entities.Editorial;
import repository.EditorialJPA;

public class EditorialService {

    private EditorialJPA editorialJPA;

    public EditorialService(EditorialJPA editorialJPA) {
        this.editorialJPA = editorialJPA;
    }

    public Editorial createEditorial(String name){
        Editorial a = new Editorial();
        a.setName(name);
        a.setActive(true);
        editorialJPA.persist(a);
        return a;
    }

    public Editorial showEditorialById(Long id){
        Editorial e = editorialJPA.findById(id);
        System.out.println(e);
        return e; }

    public Editorial showEditorialByName(String name) throws Exception{
        Editorial e = editorialJPA.findByName(name);
        System.out.println(e);
        return e; }

    public Editorial updateEditorial(Long id, String name){
        Editorial e = editorialJPA.findById(id);
        e.setName(name);
        editorialJPA.merge(e);
        return e;
    }

    public boolean inactiveEditorial(Long id) {
        Editorial e = editorialJPA.findById(id);
        if (e.isActive()) {
            e.setActive(false);
            editorialJPA.merge(e);
            return true; }
        else {return false; }
    }

    public boolean reactiveEditorial(Long id) {
        Editorial e = editorialJPA.findById(id);
        if (!e.isActive()) {
            e.setActive(true);
            editorialJPA.merge(e);
            return true; }
        else {return false; }
    }

    public boolean deleteEditorial(Long id){
        editorialJPA.remove(id);
        return true;
    }
}
