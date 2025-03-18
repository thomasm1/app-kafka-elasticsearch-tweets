package app.mapl.repositories;

import app.mapl.models.Navigator;
 import org.springframework.data.mongodb.repository.MongoRepository;

public interface NavigatorRepository extends MongoRepository<Navigator, Long> {
}
