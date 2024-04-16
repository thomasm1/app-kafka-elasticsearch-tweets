package app.mapl.service;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserRequest;
import app.mapl.mapper.UserMapper;
import app.mapl.models.LoginType;
import app.mapl.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;


//@Service
public class UsersServiceJDBC implements UsersService {
    private final JdbcTemplate jdbcTemplate;

    private static UserMapper userMapper;

    private   RowMapper<User> userRowMapper;

    public UsersServiceJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        userRowMapper = (rs, rowNum) -> new User(
                rs.getInt("userId"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("lastName"),
                rs.getString("firstName"),
                rs.getInt("userType"),
                rs.getString("organizationCode"),
                rs.getString("email"),
                rs.getString("cusUrl"),
                rs.getString("dashboardCode"),
                rs.getInt("1"),
                rs.getInt("role")
        );
    }


    public User byemail(String email) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM USER_ENTITY u WHERE u.email = ?", userRowMapper, email);
//        return null;
    }

    public User byid(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM USER_ENTITY WHERE id = ?", userRowMapper, id);
//        return null;
    }

//    public List<User> all() {
////return new ArrayList();
////		return this.jdbcTemplate.query("SELECT * FROM USERS", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
//        return this.jdbcTemplate.query("SELECT * FROM USERS", userRowMapper);
//    }


    /**
     * @param userRequest
     * @return
     */
    @Override
    public ResponseEntity saveUser(UserRequest userRequest) {
        return null;
    }

    /**
     * @param email
     * @param password
     * @return
     */
    @Override
    public UserDto loginUser(String email, String password) {
        return null;
    }

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    @Override
    public void createUser(String firstName, String lastName, String email, String password) {

    }

    /**
     * @param user
     * @return
     */
    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }


    /**
     * @param user
     * @return
     */
    public static UserDto createUserCLI(UserDto user) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<UserDto> getUser(int id) {
        return Optional.empty();
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<UserDto> getUser(String username) {
        return Optional.empty();
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> getUsers() {
        return null;
    }

    /**
     * @param change
     * @return
     */
    @Override
    public Optional<UserDto> updateUser(UserDto change) {
        return null;
    }

    /**
     * @param email
     * @param pw
     * @return
     */
    @Override
    public Optional<UserDto> getUserByEmailAndPassword(String email, String pw) {
        return Optional.empty();
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public Optional<UserDto> getUserByPassword(String username, String password) {
        return Optional.empty();
    }

    /**
     * @param userId
     * @param user
     * @return
     */
    @Override
    public Optional<UserDto> patchUserById(Integer userId, UserDto user) {
        return Optional.empty();
    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean deleteUser(String username) {
        return false;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public boolean deleteUser(UserDto user) {
        return false;
    }

    /**
     * @param email
     * @param password
     * @return
     */
    @Override
    public UserRequest updateLoginAttempt(String email, String password) {
        return null;
    }

    /**
     * @param email
     * @param loginType
     */
    @Override
    public void updateLoginAttempt(String email, LoginType loginType) {

    }
}
