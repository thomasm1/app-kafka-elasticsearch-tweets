package app.mapl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;
    /**
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        return usersRepository.save(user);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUser(int id) {
        try {
            return usersRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param email
     * @return
     */
    @Override
    public User getUser(String email) {
        try {
            return usersRepository.findByEmail(email).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return
     */
    @Override
    public List<User> getUsers() {

        return (List<User>) usersRepository.findAll();
    }

    /**
     * @param change
     * @return
     */
    @Override
    public User updateUser(User change) {
       return usersRepository.save(change);
    }

    /**
     * @return
     */
    @Override
    public List<String> getUsersWithCars() {
        return null;
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUserByPassword(String username, String password) {
        return null;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public boolean deleteUser(String email) {

        try {
         User u = usersRepository.findByEmail(email).get();
         usersRepository.delete(u);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public boolean deleteUser(User user) {

        try {
            usersRepository.delete(user);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
