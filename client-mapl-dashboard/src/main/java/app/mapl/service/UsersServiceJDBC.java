package app.mapl.service;

import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.models.User;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class UsersServiceJDBC implements UsersService {
    private final JdbcTemplate jdbcTemplate;

    private static UserMapper userMapper;

    private   RowMapper<User> userRowMapper;

    public UsersServiceJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        userRowMapper = (rs, rowNum) -> new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"), rs.getString("lastName"), rs.getString("firstName"), rs.getInt("userType"), rs.getString("organizationCode"), rs.getString("email"), rs.getString("cusUrl"), rs.getString("dashboardCode"), rs.getInt("1"), rs.getInt("role"));
    }


    public User byemail(String email) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users u WHERE u.email = ?", userRowMapper, email);
//        return null;
    }

    public User byid(Long userid) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE userid = ?", userRowMapper, userid);
//        return null;
    }

//    public List<User> all() {
////return new ArrayList();
////		return this.jdbcTemplate.query("SELECT * FROM USERS", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
//        return this.jdbcTemplate.query("SELECT * FROM USERS", userRowMapper);
//    }

    /**
     * @param rDto
     */
    @Override
    public void registerUser(RegisterDto rDto) {
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserDto loginUser(String username, String password) {
        return null;
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
}
