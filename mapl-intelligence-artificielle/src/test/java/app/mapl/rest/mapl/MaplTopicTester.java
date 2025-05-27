 package app.mapl.rest.mapl;

import app.mapl.rest.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;
import java.util.UUID;

@Lazy
@Component
public class MaplTopicTester {

    @Value("${local.server.port}")
    private int port;

    private static final String PREPEND = "/ai";
    private static final String MAPL_PATH = "/mapl-topic";

    public URI uriForMaplTopicId(UUID id) {
        return URI.create(Util.baseUri(port) + PREPEND + MAPL_PATH + "/" + id);
    }

    public WebTestClient.ResponseSpec makeMaplTopic(MaplTopicRequest maplTopicRequest) {
        return Util.newMaplClient(port)
            .post()
            .uri(MAPL_PATH)
            .bodyValue(maplTopicRequest)
            .exchange();
    }

    public MaplTopicResponse makeFromMaplAsEntity(MaplTopicRequest maplTopicRequest) {
        return getMaplFromResponse(makeMaplTopic(maplTopicRequest));
    }

    public WebTestClient.ResponseSpec getMaplTopic(UUID id) {
        return getMaplTopic(uriForMaplTopicId(id));
    }

    public WebTestClient.ResponseSpec getMaplTopic(URI maplTopicUri) {
        return Util.newMaplClient(port)
            .get()
            .uri(maplTopicUri)
            .exchange();
    }

    public MaplTopicResponse getMaplFromResponse(WebTestClient.ResponseSpec response) {
        return response
            .expectBody(MaplTopicResponse.class)
            .returnResult()
            .getResponseBody();
    }
}