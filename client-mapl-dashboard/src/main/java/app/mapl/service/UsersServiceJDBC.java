package app.mapl.service;

import app.mapl.models.auth.APIResponseDto;
import app.mapl.mapper.UserMapper;
import app.mapl.models.auth.CredentialEntity;
import app.mapl.models.auth.LoginType;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.UserResponse;
import app.mapl.models.dto.UserDto;
import jakarta.validation.constraints.NotEmpty;
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
                        userRowMapper = (rs, rowNum) ->   User.builder()
                                .firstName(rs.getString("firstName "))
                                .lastName(rs.getString("lastName"))
                                .email(rs.getString("email"))
                                .password(rs.getString("password"))
                                .build();



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
     * @param  userDto
     */
    @Override
    public ResponseEntity saveUser(UserDto userDto) {
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
     * @return
     */
    @Override
    public User createUserRole(String firstName, String lastName, String email, @NotEmpty String password) {
       return null;
    }

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param role
     * @return
     */
    @Override
    public User createUser(String firstName, String lastName, String email, RoleEntity role) {
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
     * @param name
     * @return
     */
    @Override
    public RoleEntity getRoleName(String name) {
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
     * @param uerEntityId
     * @return
     */
    @Override
    public APIResponseDto getUserById(Long uerEntityId) {
        return null;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public CredentialEntity getUserCredentialById(Long userId) {
        return null;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
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
     * @return
     */
    @Override
    public List<UserResponse> getUsersResponse() {
        return null;
    }

    /**
     * @param change
     * @return
     */
    @Override
    public Optional<UserDto> updateUser(UserDto change) {
        return Optional.empty();
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Optional<UserDto> getUserByUserId(String userId) {
        return Optional.empty();
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
     * @param userDto
     * @return
     */
    @Override
    public ResponseEntity saveUser(UserRequest userDto) {
        return null;
    }

    /**
     * @param userRequest
     * @return
     */
    @Override
    public User saveUser(User userRequest) {
        return null;
    }


    /**
     * @param email
     * @param loginType
     * @return
     */
    @Override
    public UserDto updateLoginAttempt(String email, LoginType loginType) {

        return null;
    }

    /**
     * @param key
     */
    @Override
    public void verifyAccountKey(String key) {

    }
}
