package net.ourdailytech.rest.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

//    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplatebuilder) {
        return restTemplatebuilder.build();
    }
}