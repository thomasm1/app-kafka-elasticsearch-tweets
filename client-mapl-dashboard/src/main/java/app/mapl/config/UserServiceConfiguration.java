package app.mapl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "user-service")
@Component
class UserServiceConfiguration {

	private String url;
	private String username;
	private String key;


}
