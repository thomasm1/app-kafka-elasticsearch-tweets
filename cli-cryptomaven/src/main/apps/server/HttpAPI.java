package main.apps.server;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.*;

public class HttpAPI {
    public static void main(String[] args) {
        String uri = "https://postman-echo.com/get?uname=thomas&pw=pass";
        HttpRequest req = newBuilder()
                .uri(URI.create(uri)) // .get()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpClient client = HttpClient.newBuilder()
                .build();

        try {
            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());

            System.out.println(resp.statusCode());
            System.out.println(resp.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}