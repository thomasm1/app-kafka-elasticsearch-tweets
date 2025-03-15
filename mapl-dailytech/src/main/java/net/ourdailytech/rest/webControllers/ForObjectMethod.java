package net.ourdailytech.rest.webControllers;

import net.ourdailytech.rest.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author -ThomasMiltonMaestas
 */
public class ForObjectMethod {
    public static final String PORT = "8080";
    public static final String API = "/api";
    private final Logger logger = LoggerFactory.getLogger(ForObjectMethod.class);
    private final String baseUrl = "http://localhost:"+ PORT+ API;

    private RestTemplate restTemplate = new RestTemplate();


    public void driverMethod(){
        System.out.println("*********** forObject() method demo ***********");
        getSingleObject();
        getListObject();
        addUser();
    }
    private void getSingleObject() {
        String url = baseUrl + "/user/5";
        String user = restTemplate.getForObject(url, String.class);
        logger.info("User - " + user);
    }

    private void getListObject() {
        String url = baseUrl + "/users";
        List userDetails = restTemplate.getForObject(url, List.class);
        logger.info("response body - " + userDetails);

    }

    private void addUser() {
        String url = baseUrl + "/user";
        User user = new User();
        user.setFirstName("Green");
        user.setLastName("Learner");
        String response = restTemplate.postForObject(url, user, String.class);

        logger.info("response - " + response);

    }
}
