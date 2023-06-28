package app.mapl.repositories;

import app.mapl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="user", path="users")
public interface UsersRepository extends JpaRepository<User, Integer> {


    User findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    User findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

    // SQL /////////////////////
//    @Query(nativeQuery = true, value="SELECT * FROM USERS where FIRSTNAME = :firstName")
//    List<User> findUsersByFirstname(@Param("firstname") String firstname);

    // JPQL  ///////////////////
//    @Query("SELECT u FROM User u WHERE u.firstname LIKE %?1% OR u.lastname LIKE %?1%") // JPQL
//    List<User> search(String keyword);
//
//    @Query(nativeQuery = true, value = "SELECT * FROM USERS WHERE firstname = ?1 ORDER BY lastname ASC")
//    List<User> findByFirstNameOrderByLastName(String firstName);
//
//    @Query("FROM User WHERE UPPER(firstname) LIKE CONCAT('%',UPPER(?1), '%')") // JPQL
//    List<User> findByFirstnameContainingIgnoreCase(String firstname);

}