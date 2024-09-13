package app.mapl.repositories;

import app.mapl.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Long> {

    Role findByName(String name);

    Role save(Role role);
}
