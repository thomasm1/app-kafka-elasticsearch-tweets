package app.mapl.repositories;

import app.mapl.models.Navigator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NavigatorRepository extends MongoRepository<Navigator, Long> {
}
