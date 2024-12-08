package com.friendsofgroot.app.repositories;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.friendsofgroot.app.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="user", path="user")
public interface UsersRepository extends JpaRepository<User, Integer> {

    // MULTIPLE
    Page<User> findAllByUserType(Integer userType, Pageable pageable);
    Page<User> findAllByIsActiveAfter(Integer userType, LocalDate date, Pageable pageable);


    // SINGULAR
    @NotNull Optional<User> findById(@NotNull Integer id);
    User findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);


    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    User findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

//    // SQL /////////////////////
//    @Query(nativeQuery = true, value="SELECT * FROM USERS where FIRSTNAME = :firstName")
//    List<User> findUsersByFirstName(@Param("firstName") String firstName);
//
//    // JPQL  ///////////////////
//    @Query("SELECT u FROM User u WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1%") // JPQL
//    List<User> search(String keyword);
//
//    @Query(nativeQuery = true, value = "SELECT * FROM USERS WHERE firstname = ?1 ORDER BY lastName ASC")
//    List<User> findByFirstNameOrderByLastName(String firstName);
//
//    @Query("FROM User WHERE UPPER(firstName) LIKE CONCAT('%',UPPER(?1), '%')") // JPQL
//    List<User> findByFirstNameContainingIgnoreCase(String firstName);
//
}
