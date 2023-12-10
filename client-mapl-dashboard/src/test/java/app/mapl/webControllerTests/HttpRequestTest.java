package app.mapl.webControllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void homePageReturnsVersionNumberCorrectly_thenSuccess() {
        String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertEquals(renderedHtml.contains("3.3.3"), true);
    }
    @Test
    public void homePageReturnsVersionNumberCorrectly_thenSuccess2() {
        String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertTrue(renderedHtml.contains("3.3.3"));
    }
}
