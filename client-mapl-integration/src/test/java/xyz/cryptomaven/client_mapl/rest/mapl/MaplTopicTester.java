package xyz.cryptomaven.client_mapl.rest.mapl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;
import xyz.cryptomaven.client_mapl.Util;

import java.net.URI;
import java.util.UUID;

@Lazy  // Ensures local.server.port is set by the time it is wired
@Component
public class MaplTopicTester {

    @Value(value = "${local.server.port}")
    private int port;
    
    private static final String PREPEND = "/ai";
    private static final String MAPL_PATH = "/mapl-topic";

    public URI uriForMaplTopicId(UUID id) {
        return URI.create(
                Util.baseUri(port) + PREPEND+ MAPL_PATH + "/" + id.toString()
              );
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
        return Util.newMaplClient(port)       /// WebTestClient
                .get()       ///  RequestHeadersUriSpec<Capture of ?>
                .uri(maplTopicUri)   ///Capture of ?
                .exchange();
    }

    public MaplTopicResponse getMaplFromResponse(WebTestClient.ResponseSpec response) {
        return response
                .expectBody(MaplTopicResponse.class)  ///BodySpec<MaplTopicResponse, Capture of ?>
                .returnResult()   /// EntityExchangeResult<MaplTopicResponse>
                .getResponseBody();
    }
    
}
