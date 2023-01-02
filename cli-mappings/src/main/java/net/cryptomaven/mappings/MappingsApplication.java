package net.cryptomaven.mappings;

import net.cryptomaven.mappings.model.Location;
import net.cryptomaven.mappings.model.User;
import net.cryptomaven.mappings.repository.LocationRepository;
import net.cryptomaven.mappings.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.modelmbean.ModelMBean;

@SpringBootApplication
public class MappingsApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	public static void main(String[] args) {
		SpringApplication.run(MappingsApplication.class, args);
		System.out.println("main");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("runner");

		Location location = new Location();
		location.setPlace("pittsburgh");
		location.setDescription("pittsburgh the city of millionaires");
		location.setLatitude(40.44);
		location.setLongitude(79.9959);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("Thomas");
		user1.setLastName("Milton");
		user1.setEmail("thomasm1.maestas@gmail.com");
		user1.setPassword("password");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Tom");
		user2.setLastName("Maestas");
		user2.setEmail("thomas.maestas@hotmail.com");
		user2.setPassword("password");
		user2.setLocation(location);
		userRepository.save(user2);

	}
}
