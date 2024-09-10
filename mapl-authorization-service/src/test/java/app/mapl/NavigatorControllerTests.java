package app.mapl;

import app.mapl.controller.NavigatorController;
import app.mapl.dto.NavigatorDto;
import app.mapl.service.NavigatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = NavigatorController.class)
public class NavigatorControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private NavigatorService navigatorService;

    @Test
    public void givenNavigatorObject_whenSaveNavigator_thenReturnSavedNavigator(){

        // given - pre-conditions or set up
        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("Thomas");
        navigatorDto.setLastName("Maestas");
        navigatorDto.setEmail("thomas1.maestas@gmail.com");

        BDDMockito.given(navigatorService.saveReactiveNavigator(ArgumentMatchers.any(NavigatorDto.class)))
                .willReturn(Mono.just(navigatorDto));

        // when - action or behaviour
        WebTestClient.ResponseSpec response = webTestClient.post().uri("/api/navigators")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(navigatorDto), NavigatorDto.class)
                .exchange();

        // then - verify the result or output
        response.expectStatus().isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(navigatorDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(navigatorDto.getLastName())
                .jsonPath("$.email").isEqualTo(navigatorDto.getEmail());
    }

    @Test
    public void givenNavigatorId_whenGetNavigator_thenReturnNavigatorObject(){
        // given - pre-condition
        String navigatorId = "123";

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("Thomas");
        navigatorDto.setLastName("Maestas");
        navigatorDto.setEmail("thomas1.maestas@gmail.com");

        BDDMockito.given(navigatorService.getReactiveNavigator(navigatorId))
                .willReturn(Mono.just(navigatorDto));

        // when - action
        WebTestClient.ResponseSpec response = webTestClient.get()
                .uri("/api/navigators/{id}", Collections.singletonMap("id", navigatorId))
                .exchange();

        // then - verify the output
        response.expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(navigatorDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(navigatorDto.getLastName())
                .jsonPath("$.email").isEqualTo(navigatorDto.getEmail());
    }

    @Test
    public void givenListOfNavigators_whenGetAllNavigators_returnListOfNavigators(){
        // given - pre-conditions or set up
        List<NavigatorDto> list = new ArrayList<>();
        NavigatorDto navigatorDto1 = new NavigatorDto();
        navigatorDto1.setFirstName("Thomas");
        navigatorDto1.setLastName("Maestas");
        navigatorDto1.setEmail("thomas1.maestas@gmail.com");
        list.add(navigatorDto1);

        NavigatorDto navigatorDto2 = new NavigatorDto();
        navigatorDto2.setFirstName("Tony");
        navigatorDto2.setLastName("Starck");
        navigatorDto2.setEmail("tony@gmail.com");
        list.add(navigatorDto2);

        Flux<NavigatorDto> navigatorFlux = Flux.fromIterable(list);

        BDDMockito.given(navigatorService.getAllReactiveNavigators())
                .willReturn(navigatorFlux);

        // when - action or behaviour
        WebTestClient.ResponseSpec response = webTestClient.get().uri("/api/navigators")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        // then - verify output of response
        response.expectStatus().isOk()
                .expectBodyList(NavigatorDto.class)
                .consumeWith(System.out::println);
    }

    @Test
    public void givenUpdatedNavigator_whenUpdateNavigator_thenReturnUpdatedNavigatorObject(){

        // given - pre-conditions
        String navigatorId = "123";

        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setFirstName("Thomas");
        navigatorDto.setLastName("Maestas");
        navigatorDto.setEmail("thomas1.maestas@gmail.com");

        BDDMockito.given(navigatorService.updateReactiveNavigator(ArgumentMatchers.any(NavigatorDto.class),
                ArgumentMatchers.any(String.class)))
                .willReturn(Mono.just(navigatorDto));

        // when - action or behaviour
        WebTestClient.ResponseSpec response = webTestClient.put().uri("/api/navigators/{id}", Collections.singletonMap("id", navigatorId))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(navigatorDto), NavigatorDto.class)
                .exchange();


        // then - verify the result or output
        response.expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(navigatorDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(navigatorDto.getLastName())
                .jsonPath("$.email").isEqualTo(navigatorDto.getEmail());
    }

    @Test
    public void givenNavigatorId_whenDeleteNavigator_thenReturnNothing(){

        // given - pre-conditions
        String navigatorId = "123";
        Mono<Void> voidMono = Mono.empty();
        BDDMockito.given(navigatorService.deleteReactiveNavigator(navigatorId))
                .willReturn(voidMono);

        // when - action or behaviour
        WebTestClient.ResponseSpec response = webTestClient
                .delete()
                .uri("/api/navigators/{id}", Collections.singletonMap("id", navigatorId))
                .exchange();

        // then - verify the output
        response.expectStatus().isNoContent()
                .expectBody()
                .consumeWith(System.out::println);
    }
}
