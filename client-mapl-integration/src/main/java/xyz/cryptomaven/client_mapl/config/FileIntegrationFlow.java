package xyz.cryptomaven.client_mapl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.io.File;

@Configuration
@EnableIntegration
public class FileIntegrationFlow {


    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel", outputChannel = "fileOutputChannel")
    public FileToStringTransformer fileToStringTransformer() {
        return  new FileToStringTransformer();
    }

    @Bean
    public PollerMetadata poller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(1000));
        return pollerMetadata;
    }

//    IntegrationFlows IN Spring INtegration 4.0 ;; current: 2.1.6
//    @Bean
//    public IntegrationFlow fileIntegrationFlow(FileReadingMessageSource fileReadingMessageSource,
//                                               FileToStringTransformer fileToStringTransformer,
//                                               MessageHandler fileWritingMessageHandler)  {

//        return IntegrationFlows.from(fileReadingMessageSource, c -> c.poller(p -> p.fixedDelay(1000)))
//                .channel("fileInputChannel")
//                .transform(fileToStringTransformer)
//                .handle(fileWritingMessageHandler)
//                .get();

}
