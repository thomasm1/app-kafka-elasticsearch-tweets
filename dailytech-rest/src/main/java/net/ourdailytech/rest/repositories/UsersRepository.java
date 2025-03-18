package net.ourdailytech.rest.repositories;

import jakarta.validation.constraints.NotNull;
import net.ourdailytech.rest.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    // MULTIPLE
    Page<User> findAllByUserType(Integer userType, Pageable pageable);

    User save(User user);
    // MULTIPLE
    // SINGULAR
    Optional<User> findById(@NotNull Integer id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

    //    // SQL /////////////////////
    @Query(nativeQuery = true, value = "SELECT * FROM USERS where FIRSTNAME = :firstName")
    List<User> findUsersByFirstName(@Param("firstName") String firstName);

    // JPQL  ///////////////////
    @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1%")
    List<User> search(String keyword);

    List<User> findByFirstNameOrderByLastNameAsc(String firstName);

    //  // JPQL
    @Query("SELECT u FROM User u WHERE UPPER(u.firstName) LIKE CONCAT('%',UPPER(?1), '%')")
    List<User> findByFirstNameContainingIgnoreCase(String firstName);
//
}
