package app.mapl.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionConfigurationController {

	@Autowired
	private TransactionServiceConfiguration configuration;

	@RequestMapping("/transaction-configuration")
	public TransactionServiceConfiguration retrieveAllSpecs() {
		return configuration;
	}
}
