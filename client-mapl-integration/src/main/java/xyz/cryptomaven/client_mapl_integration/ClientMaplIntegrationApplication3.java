package xyz.cryptomaven.client_mapl_integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericHandler;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.MessageSourceSpec;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.util.SystemPropertyUtils;

import java.io.File;

import java.util.concurrent.TimeUnit;

/// [DISABLE] @SpringBootApplication
public class ClientMaplIntegrationApplication3 {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(ClientMaplIntegrationApplication3.class, args);
		Thread.currentThread().join();
	}

	@Bean
	MessageChannel requests() {
		return MessageChannels.direct().getObject();
	}
	@Bean
	DirectChannel replies() { return MessageChannels.direct().getObject();  }

	@Bean
	IntegrationFlow inboundFlow() {
		var directory = new File(SystemPropertyUtils.resolvePlaceholders("${HOME}/git/in"));
		var files = Files.inboundAdapter(directory).autoCreateDirectory(true);
		return IntegrationFlow
				.from((MessageSourceSpec<?, ? extends MessageSource<?>>) files, poller -> poller.poller(pm -> pm.fixedRate(1, TimeUnit.SECONDS.ordinal())))
				.transform(new FileToStringTransformer())
				.handle( (GenericHandler<String> ) (payload, headers) -> {
					System.out.println("START____of the line");
					headers.forEach( ( key, value) -> System.out.println(key + "+ " +value));
					return payload;
				})
				.channel( requests() )
				.get();
	}
	@Bean
	IntegrationFlow flow() {
		return IntegrationFlow
				.from(requests())
//				.filter(String.class, source -> source.contains("notext"))
				.transform ((GenericTransformer<String, String>) String::toUpperCase)
				.channel(replies())
		.get();
	}

	@MessagingGateway
	interface MaplClient {
		String uppercase (String input);
	}

	@Bean
	IntegrationFlow outboundFlow() {
		var directory = new File(SystemPropertyUtils.resolvePlaceholders("${HOME}/git/_javaclient/out"));
		return IntegrationFlow
				.from(replies())
				.handle((GenericHandler<String>) (payload, headers) -> {
					System.out.println(" end of the line");
					headers.forEach( (key, value) -> System.out.println(" key: " + key + " value: " + value));
					return payload;
				})
				.handle(Files.outboundAdapter(directory).autoCreateDirectory(true))
				.get();
	}
}
