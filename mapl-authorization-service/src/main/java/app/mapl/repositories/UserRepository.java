package app.mapl.repositories;

import app.mapl.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByEmail(String email);

}
