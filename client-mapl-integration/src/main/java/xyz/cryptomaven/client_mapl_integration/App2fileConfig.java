package xyz.cryptomaven.client_mapl_integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.io.File;

@Configuration
@EnableIntegration
public class App2fileConfig {


    @ServiceActivator
    public void handleIncomingMessage() {

    }
    @Bean
    public FileReadingMessageSource fileReadingMessageSource() {
        FileReadingMessageSource source = new FileReadingMessageSource();
        File file = new File("input-directory");
        source.setDirectory(file);
        System.out.println("doublecheck FILE location: " + file.getAbsolutePath());
        source.setFilter(new SimplePatternFileListFilter("*.txt"));
        return source;
    }

    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileOutputChannel() {
        return new DirectChannel();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(trigger());
        return pollerMetadata;
    }

    @Bean
    public Trigger trigger() {
        return new PeriodicTrigger(5000);
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public MessageHandler fileWritingMessageHandler() {
        return Files.outboundAdapter(new File("output-directory"))
                .autoCreateDirectory(true)
                .fileExistsMode(FileExistsMode.REPLACE)
                .getObject();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public MessageHandler fileProcessingHandler() {
        return message -> {
            File file = (File) message.getPayload();
            System.out.println("Processing file: " + file.getName());
        };
    }

//    @Bean
//    public IntegrationFlow integrationFlow() {
//        return flow -> flow
//                .handle(fileReadingMessageSource(), e -> e.poller(poller()))
//                .channel(fileInputChannel())
//                .handle(fileProcessingHandler())
//                .handle(fileWritingMessageHandler());
//    }
}
