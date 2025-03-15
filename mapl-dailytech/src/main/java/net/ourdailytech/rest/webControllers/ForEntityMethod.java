package net.ourdailytech.rest.webControllers;

import net.ourdailytech.rest.models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author -ThomasMiltonMaestas
 */
public class ForEntityMethod {

    public static final String PORT = "8080";
    public static final String API = "/api";
    private final String baseUrl = "http://localhost:"+ PORT+ API;

    RestTemplate restTemplate= new RestTemplate();

    public void driverMethod(){
        System.out.println("*********** forEntity()   getSingleObject(3)   ******* 3 ****");
        getSingleObject("3");
        System.out.println("*********** forEntity()   getListObject()   ***********");
        getListObject();
        System.out.println("*********** forEntity()   addUser()   ***********");
        addUser();
        System.out.println("*********** forEntity()   deleteUser()   ***********");
        deleteUser();
        System.out.println("*********** forEntity()   updateUser()   ***********");
        updateUser();
    }
    private void getSingleObject(String id) {
        String url = baseUrl + "/users/"+id;
        ResponseEntity<String> user = restTemplate.getForEntity(url, String.class);
        HttpStatusCode statusCode = user.getStatusCode();
        System.out.println("status code - " + statusCode);
    }

    private void getListObject() {
        String url = baseUrl + "/users";
        ResponseEntity<List> user = restTemplate.getForEntity(url, List.class);
        HttpStatusCode statusCode = user.getStatusCode();
        System.out.println("status code - " + statusCode);
        List<Object> userDetails = user.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = user.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private void addUser() {
        String url = baseUrl + "/users";
        User user = new User();
        user.setFirstName("Green");
        user.setLastName("Learner");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);
        HttpStatusCode statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);

        URI uri = restTemplate.postForLocation(url, user, String.class);
        System.out.println("uri - " + uri);
    }

    private void deleteUser(){
        String url = baseUrl + "/users/20";
        restTemplate.delete(url);
        System.out.println("User deleted");
    }
    private void updateUser(){
        String url = baseUrl + "/updateAddress/5/USA";
        restTemplate.put(url, null);
        System.out.println("User updates");
    }
}
