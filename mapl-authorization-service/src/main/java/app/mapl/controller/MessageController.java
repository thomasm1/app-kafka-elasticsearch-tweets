package app.mapl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${mapl.message}")
    private String message;

    @GetMapping("/users/message")
    public String messageUsers(){
        return message + "! This is the Users service.";
    }

    @GetMapping("/navigators/message")
    public String messageNavigators(){
        return message+"Navigator Dashboard! This is the Navigators service.";
    }

    @GetMapping("/dashboards/message")
    public String messageDashboards(){
        return message+" Dashboard!";
    }
}
