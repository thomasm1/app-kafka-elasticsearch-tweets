package app.mapl.repositories;

import app.mapl.models.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.jpa.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="user", path="user")
public interface UsersRepository extends JpaRepository<User, Integer> {



    Optional<User> findByEmailIgnoreCase(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Optional<User> findUserByUserId(String userId);
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
//    @Query("FROM User WHERE UPPER(firstname) LIKE CONCAT('%',U
//    PPER(?1), '%')") // JPQL
//    List<User> findByFirstnameContainingIgnoreCase(String firstname);

}