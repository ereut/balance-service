package by.ereut.balanceservice.client;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ClientControllerTest extends AbstractClientTest {

    private ClientController controller;
    private ClientService clientService;
    private MockMvc mockMvc;

    public ClientControllerTest() {
        this.clientService = Mockito.mock(ClientService.class);
        this.controller = new ClientController(clientService);
    }

    @Before
    public void setUp() {
        this.mockMvc =
                MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void whenRequestThenStatusOkAndValidResponseJson() throws Exception {
        Mockito.doReturn(savedClients)
                .when(clientService)
                .getAll();

        mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void whenRequestThenStatusOkValidResponseXml() throws Exception {
        Mockito.doReturn(savedClients)
                .when(clientService)
                .getAll();

        mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().string(containsString("+37579934567")));

    }

    @Test
    public void whenRequestWithInvalidAcceptThenStatus406() throws Exception {
        Mockito.doReturn(savedClients)
                .when(clientService)
                .getAll();
        mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_CBOR))
                .andExpect(status().is(406));
    }

}
