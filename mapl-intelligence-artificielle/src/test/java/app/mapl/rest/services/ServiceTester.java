 package app.mapl.rest.services;

import app.mapl.rest.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;
import java.util.UUID;

@Lazy
@Component
public class ServiceTester {

    @Value("${local.server.port}")
    private int port;

    private static final String SERVICE_PATH = "/services";

    public URI uriForServiceId(UUID id) {
        return URI.create(Util.baseUri(port) + SERVICE_PATH + "/" + id);
    }

    public WebTestClient.ResponseSpec registerService(RegisterServiceRequest serviceRequest) {
        return Util.newMaplClient(port)
            .post()
            .uri(SERVICE_PATH)
            .bodyValue(serviceRequest)
            .exchange();
    }

    public ServiceResponse registerServiceAsEntity(RegisterServiceRequest serviceRequest) {
        return getServiceFromResponse(registerService(serviceRequest));
    }

    public WebTestClient.ResponseSpec getService(UUID id) {
        return getService(uriForServiceId(id));
    }

    public WebTestClient.ResponseSpec getService(URI serviceUri) {
        return Util.newMaplClient(port)
            .get()
            .uri(serviceUri)
            .exchange();
    }

    public ServiceResponse getServiceFromResponse(WebTestClient.ResponseSpec response) {
        return response
            .expectBody(ServiceResponse.class)
            .returnResult()
            .getResponseBody();
    }
}