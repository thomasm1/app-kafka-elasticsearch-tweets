package net.cryptomaven.mappings.repository;


import net.cryptomaven.mappings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
