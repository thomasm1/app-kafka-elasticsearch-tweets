package xyz.cryptomaven.client_mapl.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.reactive.server.WebTestClient;
import xyz.cryptomaven.client_mapl.Util;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceControllerTest {

    @Autowired
    ServiceTester serviceTester;


    @Test
    public void givenIAmAService_WhenIRegister() throws Exception {
        RegisterServiceRequest serviceRequest = new RegisterServiceRequest("Test Service");

        WebTestClient.ResponseSpec response = serviceTester.registerService(serviceRequest);

        itShouldRegisterANewService(response);
        ServiceResponse newService = serviceTester.getServiceFromResponse(response);
        itShouldAllocateANewId((WebTestClient.ResponseSpec) newService);
        itShouldShowWhereToLocateNewService(response, newService);
        itShouldConfirmServiceDetails(serviceRequest, newService);
    }


    private void itShouldRegisterANewService(WebTestClient.ResponseSpec response) {
        response.expectStatus()
                .isCreated();
    }

    private void itShouldAllocateANewId(WebTestClient.ResponseSpec response) {
          response
                .expectBody(ServiceResponse.class) // BodySpec<MemberResponse, capture of?>
                .value(service -> {
                    assertThat(service.getId()).isNotEqualTo(new UUID(0, 0));
                    assertThat(service.getId()).isNotNull();
                }).returnResult().getResponseBody();
    }

    private void itShouldShowWhereToLocateNewService(WebTestClient.ResponseSpec response, ServiceResponse newService) {
        response.
                expectHeader().
                location(String.valueOf(serviceTester.uriForServiceId(UUID.fromString(newService.getId().toString()))));
    }

    private void itShouldConfirmServiceDetails(RegisterServiceRequest serviceRequest, ServiceResponse newService) {
        assertThat(newService.getName()).isEqualTo(serviceRequest.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test Service", "Another Service"})
    public void givenIHaveRegistered_WhenICheckMyDetails(String serviceName)
    {
        RegisterServiceRequest serviceRequest = new RegisterServiceRequest(serviceName);

        URI newServiceLocation = serviceTester.registerService(serviceRequest)
                .expectBody(ServiceResponse.class)
                .returnResult()
                .getResponseHeaders().getLocation();

        WebTestClient.ResponseSpec response = serviceTester.getService(newServiceLocation);

        itShouldFindTheNewService(response);
        ServiceResponse service = serviceTester.getServiceFromResponse(response);
        itShouldConfirmServiceDetails(serviceRequest, service);
    }

    private void itShouldFindTheNewService(WebTestClient.ResponseSpec response) {
        response
                .expectStatus()
                .isOk();
    }

    @Test
    public void givenIHaveTheWrongId_WhenICheckMyDetails()
    {
        UUID wrongId = UUID.randomUUID();

        WebTestClient.ResponseSpec response = serviceTester.getService(wrongId);

        itShouldNotFindTheService(response);
    }

    private void itShouldNotFindTheService(WebTestClient.ResponseSpec response) {
        response
                .expectStatus()
                .isNotFound();
    }
}