package xyz.cryptomaven.client_mapl;

import org.springframework.test.web.reactive.server.WebTestClient;

public class Util {
    public static String baseUri (int port) {
        return  String.format("http://localhost:%d", port);
    }


    public static WebTestClient newMaplClient(int port) {

        return WebTestClient
                .bindToServer()
                .baseUrl( baseUri(port) )
                .build();
    }

}
