package xyz.cryptomaven.client_mapl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericHandler;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;

import java.time.Instant;

@Configuration
public class AppPollingConfig {


    @Bean
    MessageChannel greetings() throws Exception {
        return MessageChannels.direct().getObject();
    }
    @Bean
    MessageChannel atob() throws Exception {
        return MessageChannels.direct().getObject();
    }

    @Bean    /// 2.0
    IntegrationFlow flowChannel() throws Exception {
        return IntegrationFlow
                .from(
                        (MessageSource<String>) ()  ->
                                MessageBuilder.withPayload("flowChannel___@ " + Instant.now()).build(),
                        poller -> poller.poller( pm -> pm.fixedRate(2000))
                )
                .channel( atob())
                .get();
    }
    @Bean
    IntegrationFlow flowHandle() throws Exception {
        return IntegrationFlow
                .from(
                        atob()
                )
                .handle(new GenericHandler<String>() {
                    @Override
                    public Object handle(String payload, MessageHeaders headers) {
                        return null;
                    }
                })
                .get();
    }
    private String text() {
        return Math.random() > .5 ? "FLOW_1___@ " + Instant.now() : "FLOW_2___notime";
    }

    @Bean
    IntegrationFlow flowTransform() {
        return IntegrationFlow
                .from(
                        ( MessageSource<String>) ()  ->
                                MessageBuilder.withPayload( text() ).build(),
                        poller -> poller.poller( pm -> pm.fixedRate(6000))
                )
                .transform( (GenericTransformer<String, String>) String::toUpperCase )
                .handle( (GenericHandler<String>)  (payload, headers)  -> {
                    System.out.println("flowTransform__________ " + payload);
                    return null;
                })
                .get();
    }

    @Bean
    IntegrationFlow flowFilter() {
        return IntegrationFlow
                .from(
                        ( MessageSource<String>) ()  ->
                                MessageBuilder.withPayload( text() ).build(),
                        poller -> poller.poller( pm -> pm.fixedRate(2000))
                )
                .filter(String.class, source ->   {
                    System.out.println("flowFilter" + source);
                    return   source.contains("notime");
                })
                .transform( (GenericTransformer<String, String>) String::toUpperCase)
                .handle( (GenericHandler<String>)  (payload, headers)  -> {
                    System.out.println("flowFilter___+_+_2 " + payload);
                    return null;
                })
                .get();
    }

}
