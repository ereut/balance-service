package by.ereut.balanceservice.client;

import by.ereut.balanceservice.config.AppConfig;
import by.ereut.balanceservice.config.TestConfig;
import by.ereut.balanceservice.tariff.Tariff;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        classes = {TestConfig.class, AppConfig.class}
)
@ActiveProfiles("test")
public abstract class AbstractClientTest {

    @Autowired
    private ClientRepository repository;

    protected static List<Client> savedClients;

    @Before
    public void saveTestData() {
        Tariff testTariff = new Tariff();
        testTariff.setTitle("test");
        Tariff newTariff = new Tariff();
        newTariff.setTitle("new");
        Client firstClient = new Client();
        firstClient.setBalance(new BigDecimal("123.22"));
        firstClient.setTelephoneNumber("+37579934567");
        firstClient.setTariff(testTariff);
        Client secondClient = new Client();
        secondClient.setTariff(newTariff);
        secondClient.setTelephoneNumber("+375447334588");
        secondClient.setBalance(new BigDecimal("12.99"));
        Client thirdClient = new Client();
        thirdClient.setTariff(testTariff);
        thirdClient.setBalance(new BigDecimal("144.67"));
        thirdClient.setTelephoneNumber("+375445554567");
        savedClients = repository.saveAll(Arrays.asList(firstClient, secondClient, thirdClient));
    }

    @After
    public void deleteTestData() {
        repository.deleteAll();
    }

}
