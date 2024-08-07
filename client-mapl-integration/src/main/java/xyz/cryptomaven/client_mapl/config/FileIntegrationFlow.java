package xyz.cryptomaven.client_mapl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.io.File;

@Configuration
@EnableIntegration
public class FileIntegrationFlow {

    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileOutputChannel() {
        return new DirectChannel();
    }

    @Bean
    public FileReadingMessageSource fileReadingMessageSource() {
        FileReadingMessageSource source = new FileReadingMessageSource();
        File file = new File("input-directory");
        source.setDirectory(file);
        System.out.println(" file.getAbsolutePath location: " + file.getAbsolutePath());
        source.setFilter(new SimplePatternFileListFilter("*.txt"));
        System.out.println(source.isUseWatchService());
        return source;
    }


    @Bean
    @ServiceActivator(inputChannel = "fileOutputChannel")
    public MessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("output-directory"));
        handler.setExpectReply(false);
//         .autoCreateDirectory(true)
//                .fileExistsMode(FileExistsMode.REPLACE)
        handler.setDeleteSourceFiles(true);
        return handler;
    }


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

//    }

}
