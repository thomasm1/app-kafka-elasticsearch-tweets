package xyz.cryptomaven.rest.config;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//currency-service.url=
//currency-service.username=
//currency-service.key=

@Data
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

	private static final Logger log = LoggerFactory.getLogger(CurrencyServiceConfiguration.class);

    private String url;
	private String username;
	private String key;


}
