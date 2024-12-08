package app.mapl.repositories;

import app.mapl.models.Role;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel="role", path = "role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @NotNull Optional<Role> findById(@RequestParam @NotNull Integer id);
    @NotNull Optional<Role> findByName(@RequestParam String name);
    Set<Role> findAllByName(@RequestParam String name);
}
