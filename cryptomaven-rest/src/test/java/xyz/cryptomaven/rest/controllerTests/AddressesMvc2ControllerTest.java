package xyz.cryptomaven.rest.controllerTests;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import xyz.cryptomaven.rest.models.Address;
import xyz.cryptomaven.rest.models.dto.AddressDto;

@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
@SpringBootTest
public class AddressesMvc2ControllerTest {

    @Autowired
    private WebTestClient client;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void getAllAddresses() {
        client.get()
                .uri("/api/addresses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Address.class)
                .consumeWith(System.out::println);
    }

    @Test
    void insertAddress() {
        AddressDto newAddress = AddressDto.builder()
                .email("email@email.com")
                .address("ASDKFJW@")
                .build();
        client.post()
                .uri("/api/addresses")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(  newAddress)
                .exchange()
                .expectStatus().isOk();

    }

}
