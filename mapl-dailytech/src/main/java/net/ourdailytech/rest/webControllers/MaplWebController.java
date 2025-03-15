package net.ourdailytech.rest.webControllers;

import net.ourdailytech.rest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MaplWebController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("userList")
    List<User> getUserList() {
        return restTemplate.getForObject("/users", List.class);
    }
}
