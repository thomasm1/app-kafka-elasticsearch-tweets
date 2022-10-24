package main.repositories;

import main.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.ArrayList;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User createUser(User u);

    User getUser(int id); //

    User findByName(String username); //getUser

    List<User> getAllUsers();

    User getUserByPassword(String username, String password);

    User findByEmailAndName(String email, String name);

    List<User> findByGroupGroupName(String groupname);

    List<User> findByCarsCarName(String carName);

//    List<User> getUsersWithCars();

    List<User> findByEmailIsLike(String email);

    List<User> findByNameStartsWith(String name);

    User updateUser(User change);

    boolean deleteUser(String username);


//    void saveUserCarbuy(UserCarbuy userCarbuy);


}
