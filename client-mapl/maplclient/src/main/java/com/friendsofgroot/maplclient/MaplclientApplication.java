package app.mapl.maplclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MaplclientApplication {


	public static final String HTTP_LOCALHOST = "http://localhost:";
	public static final String _PORT = "8889";

	public static void main(String[] args) {
		SpringApplication.run(MaplclientApplication.class, args);
	}



	@Bean
	ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(UserClient userClient) {
		return event ->  userClient.all().subscribe(System.out::println);
	}


	// auto-generated client from interface
	@Bean
	UserClient userClient(WebClient.Builder builder) {
		return HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(builder.baseUrl(HTTP_LOCALHOST + _PORT).build()))
				.build()
				.createClient(UserClient.class);
	}
}

/////////////////////////////
record User(Integer userid, String email, String password) {
}
record Profiler(Integer id) {
}
@Controller
class UserGraphqlController {
	private final UserClient userClient;

	UserGraphqlController(UserClient userClient) {
		this.userClient = userClient;
	}

	@SchemaMapping (typeName = "User" )
	Mono <Profiler> profiler(User user) {
		return  Mono.just(new Profiler(user.userid()));
	}
	@QueryMapping
	Flux<User> users() {
		return  this.userClient.all();
	}

	@QueryMapping
	Mono<User> userByEmail(@Argument String email) {
		return this.userClient.byEmail(email).next();
	}

}
interface UserClient {
	@GetExchange("/api/users")
	Flux<User> all();

	@GetExchange("/api/users/{email}")
	Flux<User> byEmail(@PathVariable String email);
}

@ControllerAdvice
class ErrorHandlingControllerAdvice {

	@ExceptionHandler
	public ProblemDetail handleIllegalStateException(IllegalStateException e) {
		var pdh = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
		pdh.setDetail("IllegalStateException" + e.getMessage());
		return pdh;
	}
}