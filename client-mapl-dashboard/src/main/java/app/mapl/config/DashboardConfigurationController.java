package app.mapl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardConfigurationController {

	@Autowired
	private DashboardServiceConfiguration configuration;

	@RequestMapping("/dashboard-configuration")
	public DashboardServiceConfiguration retrieveAllSpecs() {
		return configuration;
	}
 }
