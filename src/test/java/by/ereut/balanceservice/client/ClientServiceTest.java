package by.ereut.balanceservice.client;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ClientServiceTest extends AbstractClientTest {

    @Autowired
    protected ClientService service;

    @Test
    public void getAllClientsTest() {
        List<Client> gettingClients = service.getAll();
        assertNotNull(gettingClients);
        assertEquals(savedClients.size(), gettingClients.size());
        assertEquals(savedClients.get(0),gettingClients.get(0));
        assertTrue(gettingClients.containsAll(savedClients));
    }

}
