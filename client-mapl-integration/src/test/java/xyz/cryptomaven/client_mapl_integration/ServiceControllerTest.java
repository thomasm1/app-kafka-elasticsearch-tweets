package xyz.cryptomaven.client_mapl_integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import xyz.cryptomaven.client_mapl_rest.RegisterServiceRequest;
import xyz.cryptomaven.client_mapl_rest.ServiceResponse;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceControllerTest {

    @Value(value = "${local.server.port:8080}")
    private int port;

    private String baseUri() {
        return "http://localhost:" + port;
    }

    @Test
    public void givenIAmAService_WhenIRegister() throws Exception {
        RegisterServiceRequest serviceRequest = new RegisterServiceRequest("Test Service");

        WebTestClient.ResponseSpec response = WebTestClient
                .bindToServer()
                .baseUrl( baseUri() )
                .build()
             .post()
                .uri("/services")
             .exchange();

        itShouldRegisterANewService(response);
      ServiceResponse newService = itShouldAllocateANewId( response);
        itShouldShowWhereToLocateNewService( response,  newService);
    }


    private void itShouldRegisterANewService(WebTestClient.ResponseSpec response) {
        response.expectStatus()
                .isCreated();
    }

    private ServiceResponse itShouldAllocateANewId(WebTestClient.ResponseSpec response) {
        return response
                .expectBody(ServiceResponse.class) // BodySpec<MemberResponse, capture of?>
                .value(service -> {
                    assertThat(service.getId()).isNotEqualTo(new UUID(0, 0));
                    assertThat(service.getId()).isNotNull();
                }).returnResult().getResponseBody();
    }

    private void itShouldShowWhereToLocateNewService(WebTestClient.ResponseSpec response, ServiceResponse newService) {
        response.
                expectHeader().
                location(baseUri() + "/services" + "/" + newService.getId());
    }

    private void itShouldConfirmServiceDetails(RegisterServiceRequest serviceRequest, ServiceResponse newService) {
        assertThat(newService.getName()).isEqualTo(serviceRequest.getName());
    }


//    @Test
//    public void givenIHaveRegistered_WhenICheckMyDetails()  {
//        RegisterServiceRequest serviceRequest = new RegisterServiceRequest("Test Service");
//
//
//        URI newServiceLocation = registerNewService(serviceRequest)
//                .expectBody(ServiceResponse.class)
//                .returnResult()
//                .getResponseHeaders().getLocation();
//
//        WebTestClient.ResponseSpec response = newWebClient()
//                .get()
//                .uri( newServiceLocation )
//                .exchange();
//
//        WebTestClient newWebClient = WebTestClient
//                .bindToServer()
//                .baseUrl(baseUri())
//                .build();
//
//        WebTestClient.ResponseSpec response = newWebClient
//                .get()
//                .uri(newServiceLocation)
//                .exchange();
//
//        itShouldFindTheNewService(response);
//    }
//    private void    itShouldFindTheNewService(WebTestClient.ResponseSpec response) {
//        response.expectStatus()
//                .isOk();
//    }

}