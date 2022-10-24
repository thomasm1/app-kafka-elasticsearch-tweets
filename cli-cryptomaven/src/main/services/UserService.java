package main.services;


import main.entities.User;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    // DB.users.put(c.getUserID(), c);
    @Autowired
    UserRepository userRepository;
 
    public User createUser(User user) {
        System.out.println("Passing User Service userdao.createUser(u); ...");
        return userRepository.save(user);
    };

    public User getUserByName(String name) {
        System.out.println("Passing User Service getUser(String id) {...");
        return userRepository.findByName(name);
    };
    public List<User> getAllUsers() {
        System.out.println("Passing User Service userdao.getAllUsers() { ...");
        return userRepository.findAll();
    };

    public User updateUser(User change) {
        System.out.println("Passing User Service userdao.updateUser(User change) {..");
        return userRepository.save(change);
    }


    public List<User> getUsersWithCars(String car) {
        System.out.println("Passing User Service userdao.getUsersWithCars() {...");
        return userRepository.findByCarsCarName(car);
    }

    public User getUserByPassword(String username, String password) {
        System.out.println("Passing User Service userdao.getUserByPassword(String username, String password)...");
        return userRepository.getUserByPassword(username, password);
    }
    public boolean deleteUser(String username) {
        System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
        return userRepository.deleteUser(username);
    }
}
