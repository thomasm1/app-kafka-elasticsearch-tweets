package xyz.cryptomaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientMaplIntegrationApplication {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(ClientMaplIntegrationApplication.class, args);
//		Thread.currentThread().join();
	}
//
//
//	@Bean
//	MessageChannel greetings() {
//		return MessageChannels.direct().getObject();
//	}
//	@Bean
//	MessageChannel atob() {
//		return MessageChannels.direct().getObject();
//	}
//	//	@Bean  /// 1.0
//	//	IntegrationFlow flowChannel() {
//	//		return IntegrationFlow
//	//				.from(new MessageSource<String>() {
//	//					@Override
//	//					public Message<String> receive() {
//	//						return MessageBuilder.withPayload("I am a message @ " + Instant.now() + "!").build();
//	//					}
//	//					  }, poller -> poller.poller( pm -> pm.fixedRate(200)))
//	//				.channel( atob())
//	//				.get();
//	//	}
//	@Bean    /// 2.0
//	IntegrationFlow flowChannel() {
//		return IntegrationFlow
//				.from(
//						(MessageSource<String>) ()  ->
//								MessageBuilder.withPayload("flowChannel___@ " + Instant.now()).build(),
//						poller -> poller.poller( pm -> pm.fixedRate(2000))
//				)
//				.channel( atob())
//				.get();
//	}
//	@Bean
//	IntegrationFlow flowHandle() {
//		return IntegrationFlow
//				.from(
//						atob()
//				)
//				.handle(new GenericHandler<String>() {
//					@Override
//					public Object handle(String payload, MessageHeaders headers) {
//						return null;
//					}
//				})
//				.get();
//	}
//	private String text() {
//		return Math.random() > .5 ? "FLOW_1___@ " + Instant.now() : "FLOW_2___notime";
//	}
//
//	@Bean
//	IntegrationFlow flowTransform() {
//		return IntegrationFlow
//				.from(
//						( MessageSource<String>) ()  ->
//								MessageBuilder.withPayload( text() ).build(),
//						poller -> poller.poller( pm -> pm.fixedRate(2000))
//				)
//				.transform( (GenericTransformer<String, String>) source -> source.toUpperCase())
//				.handle( (GenericHandler<String>)  (payload, headers)  -> {
//					System.out.println("flowTransform__________ " + payload);
//					return null;
//				})
//				.get();
//	}
//
//	@Bean
//	IntegrationFlow flowFilter() {
//		return IntegrationFlow
//				.from(
//						( MessageSource<String>) ()  ->
//								MessageBuilder.withPayload( text() ).build(),
//						poller -> poller.poller( pm -> pm.fixedRate(2000))
//				)
//				.transform( (GenericTransformer<String, String>) source -> source.toUpperCase())
//				.filter(String.class, new GenericSelector<String>() {
//					@Override
//					public boolean accept(String source) {
//						System.out.println("flowFilter" + source);
//						return source.contains("notime");
//					}
//				})
//				.get();
//	}
//
//	@Bean
//	IntegrationFlow flowFilter2() {
//		return IntegrationFlow
//				.from(
//						( MessageSource<String>) ()  ->
//								MessageBuilder.withPayload( text() ).build(),
//						poller -> poller.poller( pm -> pm.fixedRate(2000))
//				)
//				.filter(String.class, source -> source.contains("notime"))
//				.transform( (GenericTransformer<String, String>) source -> source.toUpperCase())
//				.handle( (GenericHandler<String>)  (payload, headers)  -> {
//					System.out.println("flowFilter___+_+_2 " + payload);
//					return null;
//				})
//				.get();
//	}
//
//	@Component
//	class Runner implements ApplicationRunner {
//		private final GreetingsClient greetingsClient;
//
//		Runner(GreetingsClient greetingsClient) {
//			this.greetingsClient = greetingsClient;
//		}
//
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			this.greetingsClient.greet("hello with text");
//			this.greetingsClient.greet("hello notext");
//		}
//	}

}
