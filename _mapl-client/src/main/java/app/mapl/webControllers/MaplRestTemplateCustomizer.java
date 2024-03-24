package app.mapl.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
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
