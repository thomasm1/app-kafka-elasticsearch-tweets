package app.mapl.repositories;

import app.mapl.models.Role;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.Set;

// @Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {
    Optional<Role> findById(@NotNull Integer id);

    Optional<Role> findByName(String name);

    Set<Role> findAllByName(String name);
}
