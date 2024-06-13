package app.mapl.util.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//dashboard-service.url=
//dashboard-service.email=
//dashboard-service.key=


@Data
@ConfigurationProperties(prefix = "dashboard-service")
@Component
class DashboardServiceConfiguration {

	private String url;
	private String email;
	private String key;


}
