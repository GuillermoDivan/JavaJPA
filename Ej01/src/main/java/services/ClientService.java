package services;
import repository.ClientJPA;

public class ClientService {

    private ClientJPA clientJPA;

    public ClientService(ClientJPA clientJPA) {
        this.clientJPA = clientJPA;
        
    }
}
