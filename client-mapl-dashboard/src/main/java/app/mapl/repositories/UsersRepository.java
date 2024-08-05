package app.mapl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.mapl.models.User;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel="user", path="user")
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {


    User findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    User findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);


}