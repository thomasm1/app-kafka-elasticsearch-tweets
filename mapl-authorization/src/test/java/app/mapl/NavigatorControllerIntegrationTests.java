package app.mapl;

import app.mapl.dto.NavigatorDto;
import app.mapl.repositories.NavigatorReactiveRepository;
import app.mapl.services.NavigatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NavigatorControllerIntegrationTests {

    @Autowired
    private NavigatorService navigatorService;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private NavigatorReactiveRepository navigatorRepository;

    @BeforeEach
    public void before(){
        System.out.println("Before Each Test");
        navigatorRepository.deleteAll().subscribe();
    }

    @Test
    public void testSaveNavigator(){

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("John");
        navigatorDto.setLastName("Cena");
        navigatorDto.setEmail("john@gmail.com");

        webTestClient.post().uri("/api/navigators")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(navigatorDto), NavigatorDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(navigatorDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(navigatorDto.getLastName())
                .jsonPath("$.email").isEqualTo(navigatorDto.getEmail());
    }

    @Test
    public void testGetSingleNavigator(){

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("Meena");
        navigatorDto.setLastName("Fadatare");
        navigatorDto.setEmail("meena@gmail.com");

        NavigatorDto savedNavigator = navigatorService.saveReactiveNavigator(navigatorDto).block();

        webTestClient.get().uri("/api/navigators/{id}", Collections.singletonMap("id",savedNavigator.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.id").isEqualTo(savedNavigator.getId())
                .jsonPath("$.firstName").isEqualTo(navigatorDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(navigatorDto.getLastName())
                .jsonPath("$.email").isEqualTo(navigatorDto.getEmail());
    }

    @Test
    public void testGetAllNavigators(){

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("John");
        navigatorDto.setLastName("Cena");
        navigatorDto.setEmail("john@gmail.com");

        navigatorService.saveReactiveNavigator(navigatorDto).block();

        NavigatorDto navigatorDto1 = new NavigatorDto();
        navigatorDto1.setFirstName("Meena");
        navigatorDto1.setLastName("Fadatare");
        navigatorDto1.setEmail("meena@gmail.com");

        navigatorService.saveReactiveNavigator(navigatorDto1).block();

        webTestClient.get().uri("/api/navigators")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NavigatorDto.class)
                .consumeWith(System.out::println);
    }

    @Test
    public void testUpdateNavigator(){

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("Ramesh");
        navigatorDto.setLastName("Fadatare");
        navigatorDto.setEmail("ramesh@gmail.com");

        NavigatorDto savedNavigator = navigatorService.saveReactiveNavigator(navigatorDto).block();

        NavigatorDto updatedNavigator = new NavigatorDto();
        updatedNavigator.setFirstName("Ram");
        updatedNavigator.setLastName("Jadhav");
        updatedNavigator.setEmail("ram@gmail.com");

        webTestClient.put().uri("/api/navigators/{id}", Collections.singletonMap("id", savedNavigator.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedNavigator), NavigatorDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(updatedNavigator.getFirstName())
                .jsonPath("$.lastName").isEqualTo(updatedNavigator.getLastName())
                .jsonPath("$.email").isEqualTo(updatedNavigator.getEmail());
    }

    @Test
    public void testDeleteNavigator(){

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("Ramesh");
        navigatorDto.setLastName("Fadatare");
        navigatorDto.setEmail("ramesh@gmail.com");

        NavigatorDto savedNavigator = navigatorService.saveReactiveNavigator(navigatorDto).block();

        webTestClient.delete().uri("/api/navigators/{id}", Collections.singletonMap("id", savedNavigator.getId()))
                .exchange()
                .expectStatus().isNoContent()
                .expectBody()
                .consumeWith(System.out::println);

    }
}
