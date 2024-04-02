package app.mapl.config.security;

import java.beans.BeanProperty;

import app.mapl.webControllers.MaplRequestInterceptor;
import app.mapl.webControllers.MaplRestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import java.time.Duration;

/**
 * @author -ThomasMiltonMaestas
 */

@Configuration
public class Config {

    @Bean
    RestTemplateCustomizer restTemplateCustomizer() {
        return new MaplRestTemplateCustomizer();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("${mapl.api.url}");
        return builder
                .uriTemplateHandler(uriTemplateHandler)
                .setReadTimeout(Duration.ofMillis(2000))
                .build();
    }

    @Bean
    public MaplRequestInterceptor maplRequestInterceptor() { return new MaplRequestInterceptor(); }

    @Bean
    @DependsOn("restTemplateCustomizer")
    public RestTemplateBuilder restTemplateBuilder(RestTemplateCustomizer restTemplateCustomizer) {
        return new RestTemplateBuilder(restTemplateCustomizer);
    }
}
