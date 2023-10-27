package services;
import entities.PublishingHouse;
import repository.PublishingHouseJPA;

public class PublishingHouseService {

    private PublishingHouseJPA publishingHouseJPA;

    public PublishingHouseService(PublishingHouseJPA publishingHouseJPA) {
        this.publishingHouseJPA = publishingHouseJPA;
    }

    public PublishingHouse createPublishingHouse(String name){
        PublishingHouse a = new PublishingHouse();
        a.setName(name);
        a.setActive(true);
        publishingHouseJPA.persist(a);
        return a;
    }

    public PublishingHouse showPublishingHouseById(Long id){
        PublishingHouse e = publishingHouseJPA.findById(id);
        System.out.println(e);
        return e; }

    public PublishingHouse showPublishingHouseByName(String name) throws Exception{
        PublishingHouse e = publishingHouseJPA.findByName(name);
        System.out.println(e);
        return e; }

    public PublishingHouse updatePublishingHouse(Long id, String name){
        PublishingHouse e = publishingHouseJPA.findById(id);
        e.setName(name);
        publishingHouseJPA.merge(e);
        return e;
    }

    public boolean inactivePublishingHouse(Long id) {
        PublishingHouse e = publishingHouseJPA.findById(id);
        if (e.isActive()) {
            e.setActive(false);
            publishingHouseJPA.merge(e);
            return true; }
        else {return false; }
    }

    public boolean reactivePublishingHouse(Long id) {
        PublishingHouse e = publishingHouseJPA.findById(id);
        if (!e.isActive()) {
            e.setActive(true);
            publishingHouseJPA.merge(e);
            return true; }
        else {return false; }
    }

    public boolean deletePublishingHouse(Long id){
        publishingHouseJPA.remove(id);
        return true;
    }
}
