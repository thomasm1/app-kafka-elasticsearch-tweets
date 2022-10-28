package xyz.climongoapp.serviceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import xyz.climongoapp.constants.CarMake;
import xyz.climongoapp.entity.Car;
import xyz.climongoapp.entity.Groups;
import xyz.climongoapp.entity.User;
import xyz.climongoapp.service.CarService;
import xyz.climongoapp.service.GroupsService;
import xyz.climongoapp.repository.UserRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceStubTest extends UserServiceStub {
    UserServiceStubTest userServiceStubTest;
    User userStub = new User(1000, "Smith", "Tom", "user0", "password", 1, 1, "user0@cryptomaven.xyz", "5055087707", "http://www.dailytech.net");

    Car carStub = new Car(5000, CarMake.TESLA, "Cyber-Truck", 47000.99, 0);
    Car carStub1 = new Car(5001, CarMake.CHEVROLET, "IMPALA", 37000.99, 1);
    List<Car> carListStub = new ArrayList<>();
    UserServiceStub userServiceStub = new UserServiceStub();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUser() {
        User user = new User(1000, "Smith", "Tom", "user0", "password", 1, 1, "user0@cryptomaven.xyz", "5055087707", "http://www.dailytech.net");
        userServiceStub.createUser(user);
        List<Car> expectedCars = user.getCars();
        List<Car> actualCars = carListStub;

        assertEquals(expectedCars, actualCars);

    }


    @Test
    void usersByUserNameOrMail() {

    }

    @Test
    void emailLike() {

    }

}

///////////////////////////////////////////
//////////  INTERFACE METHODS ///////////////////////
class UserServiceStub implements UserRepository {
    GroupsService groupsService = new GroupsService();
    CarService carService = new CarService();
    // STUBS
    User userStub = new User(1000, "Smith", "Tom", "user0", "password", 1, 1, "user0@cryptomaven.xyz", "5055087707", "http://www.dailytech.net");
    User userStub1 = new User(1001, "Smith", "Tom", "user0", "password", 1, 1, "user0@cryptomaven.xyz", "5055087707", "http://www.dailytech.net");
    List<User> userListStub = new ArrayList<>();
    Groups groupsStub = new Groups(7004, 24, "Business Group");
    Car carStub = new Car(5000, CarMake.TESLA, "Cyber-Truck", 47000.99, 0);
    Car carStub1 = new Car(5001, CarMake.CHEVROLET, "IMPALA", 37000.99, 1);
    List<Car> carListStub = new ArrayList<>();

    @Override
    public User createUser(User u) { // check if groups and cars made

        carListStub.add(carStub);
        carListStub.add(carStub1);
        u.setCars(carListStub);
        u.setGroups(groupsStub);
        System.out.println(u);
        System.out.println(groupsStub);
// helpful collateral for later tests
        if (u.getGroups() != null) {
            groupsService.createGroups(u.getGroups()); // singular groups
        }
        if (u.getCars() != null && u.getCars().size() > 0) {
            carService.saveAll(u.getCars());
        }
//        return userRepository.save(User);
        return u;
    }

    @Override
    public User findByUserName(String userName) {
        userStub.setUserName(userName);
        return userStub;
    }
    @Override
    public List<User> findByLastName(String lastName) {
        userListStub.add(userStub);
        userListStub.add(userStub1);
        return userListStub;
    }

    @Override
    public User findByEmailAndUserName(String email, String userName) {
        userStub.setEmail(email);
        userStub.setUserName(userName);
        return userStub;
    }

    @Override
    public User findByUserNameOrEmail(String userName, String email) {
        userStub.setEmail(email);
        return userStub;
    }

    @Override
    public List<User> findByGroupsGroupsName(String groupsName) {
        groupsStub.setGroupsName(groupsName);
        userStub.setGroups(groupsStub);
        userStub1.setGroups(groupsStub);
        List<User> userListStub = new ArrayList<>();
        userListStub.add(userStub);
        userListStub.add(userStub1);
        return userListStub;
    }

    @Override
    public List<User> findByCarsCarName(String subCarName) {
        carStub.setCarName(subCarName);
        userStub.setCar(carStub);
        userStub1.setCar(carStub);
        List<User> userListStub = new ArrayList<>();
        userListStub.add(userStub);
        userListStub.add(userStub1);
        return userListStub;
    }

    @Override
    public List<User> findByEmailIsLike(String email) {
        userStub.setEmail(email);
        userStub1.setEmail(email);
        List<User> userListStub = new ArrayList<>();
        userListStub.add(userStub);
        userListStub.add(userStub1);
        return userListStub;
    }

    @Override
    public List<User> findByUserNameStartsWith(String userName) {
        return null;
    }

    @Override
    public List<User> findByGroupsId(String groupId) {
        return null;
    }

    ///////////////////////////////////////////
    //////////  OTHER METHODS //////////////////////
    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(String s) {


        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> S insert(S s) {
        return null;
    }

    @Override
    public <S extends User> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }
}