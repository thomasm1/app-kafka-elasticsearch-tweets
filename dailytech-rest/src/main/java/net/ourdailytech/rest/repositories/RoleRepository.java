package net.ourdailytech.rest.repositories;

import jakarta.validation.constraints.NotNull;
import net.ourdailytech.rest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; 
import org.springframework.stereotype.Repository; 

import java.util.Optional;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "role", path = "role") 
@Repository 
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findById(@NotNull Integer id);

    Optional<Role> findByName(String name);

    Set<Role> findAllByName(String name);
}
