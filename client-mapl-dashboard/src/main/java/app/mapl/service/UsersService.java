package app.mapl.service;

import app.mapl.models.auth.APIResponseDto;
import app.mapl.models.auth.CredentialEntity;
import app.mapl.models.auth.LoginType;
import app.mapl.models.auth.RequestContext;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.UserResponse;
import app.mapl.models.dto.UserDto;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	ResponseEntity saveUser (UserDto userRequest);


	UserDto loginUser(String email, String password);

	User createUserRole(String firstName, String lastName, String email, @NotEmpty String password);

	User createUser(String firstName, String lastName, String email, RoleEntity role);

	void createUser(String firstName, String lastName, String email, String password);
	public static UserDto createUserCli(UserDto user) { 	return user; }

	RoleEntity getRoleName(String name);

	public Optional<UserDto> getUser(int id);
	public Optional<UserDto>  getUser(String email );

	APIResponseDto getUserById(Long uerEntityId);

	CredentialEntity getUserCredentialById(Long userId);

	Optional<User> getUserByEmail(String email);

	public List<UserDto> getUsers();
	public List<UserResponse> getUsersResponse();

	public Optional<UserDto> updateUser(UserDto change);

	public Optional<UserDto> getUserByUserId(String userId); // UUId

	public Optional<UserDto> getUserByEmailAndPassword(String email, String pw);

	public Optional<UserDto> getUserByPassword(String email, String password);


	Optional<UserDto> patchUserById(Integer userId, UserDto user);

	public boolean deleteUser(String email);

	boolean deleteUser(UserDto user);

//    UserDto updateLoginAttempt(String email, String password);

	abstract ResponseEntity saveUser(UserRequest userRequest);

	User saveUser(User userRequest);

	UserDto updateLoginAttempt(String email, LoginType loginType);

	void verifyAccountKey(String key);

}
