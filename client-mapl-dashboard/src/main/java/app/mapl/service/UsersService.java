package app.mapl.service;

import app.mapl.models.auth.APIResponseDto;
import app.mapl.models.auth.UserResponse;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.LoginType;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	ResponseEntity saveUser (UserRequest userRequest);


	UserResponse loginUser(String email, String password);

	User createUserRole(String firstName, String lastName, String email, @NotEmpty String password);

	User createUser(String firstName, String lastName, String email, RoleEntity role);

	void createUser(String firstName, String lastName, String email, String password);
	public static UserResponse createUserCli(UserResponse user) { 	return user; }

	RoleEntity getRoleName(String name);

	public Optional<UserResponse> getUser(int id);
	public Optional<UserResponse>  getUser(String email );

	APIResponseDto getUserById(Long uerEntityId);

	Optional<User> getUserByEmail(String email);

	public List<UserResponse> getUsers();

	public Optional<UserResponse> updateUser(UserResponse change);

	public Optional<UserResponse> getUserByEmailAndPassword(String email, String pw);

	public Optional<UserResponse> getUserByPassword(String email, String password);

	Optional<UserResponse> patchUserById(Integer userId, UserResponse user);

	public boolean deleteUser(String email);

	boolean deleteUser(UserResponse user);

//    UserRequest updateLoginAttempt(String email, String password);

	User updateLoginAttempt(String email, LoginType loginType);

	void verifyAccountKey(String key);

}
