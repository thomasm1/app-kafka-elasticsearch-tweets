package app.mapl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//dashboard-service.url=
//dashboard-service.username=
//dashboard-service.key=


@Data
@ConfigurationProperties(prefix = "dashboard-service")
@Component
class DashboardServiceConfiguration {

	private String url;
	private String username;
	private String key;


}
