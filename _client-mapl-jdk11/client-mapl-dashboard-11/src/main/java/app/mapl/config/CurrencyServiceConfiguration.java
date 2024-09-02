package app.mapl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//currency-service.url=
//currency-service.username=
//currency-service.key=

@Data
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

	private String url;
	private String username;
	private String key;


}
