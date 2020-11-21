package by.ereut.balanceservice.client;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Profile({"dev", "test"})
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository=repository;
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

}
