package app.mapl.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value("${local.server.port}")
    private int port;

    @Value("${app.version}")
    private String version;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void homePageReturnsVersionNumberCorrectly_thenSuccess() {
        String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertEquals(renderedHtml.contains(version), true);
    }
}
