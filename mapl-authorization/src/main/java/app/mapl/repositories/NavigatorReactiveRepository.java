package app.mapl.repositories;

import app.mapl.models.Navigator;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NavigatorReactiveRepository extends ReactiveCrudRepository<Navigator, Long> {
}
