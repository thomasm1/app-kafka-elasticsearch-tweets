package app.mapl.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConfigurationController {

	@Autowired
	private UserServiceConfiguration configuration;

	@RequestMapping("/user-configuration")
	public UserServiceConfiguration retrieveAllSpecs() {
		return configuration;
	}

}
