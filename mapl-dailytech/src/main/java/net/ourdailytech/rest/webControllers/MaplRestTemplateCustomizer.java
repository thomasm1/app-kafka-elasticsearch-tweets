package net.ourdailytech.rest.webControllers;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

public class MaplRestTemplateCustomizer implements RestTemplateCustomizer {

//    @Autowired
    private MaplRequestInterceptor maplRequestInterceptor;

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(maplRequestInterceptor);
    }
}
