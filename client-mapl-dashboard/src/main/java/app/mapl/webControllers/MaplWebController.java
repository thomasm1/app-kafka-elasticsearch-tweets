package app.mapl.webControllers;

import app.mapl.models.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MaplWebController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("users")
    List<User> getUserList() {
        return restTemplate.getForObject("/users", List.class);
    }
}
