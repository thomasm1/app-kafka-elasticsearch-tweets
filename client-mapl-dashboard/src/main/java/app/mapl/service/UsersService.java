package app.mapl.service;

import app.mapl.models.auth.APIResponseDto;
import app.mapl.models.auth.LoginType;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
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

	Optional<User> getUserByEmail(String email);

	public List<UserDto> getUsers();

	public Optional<UserDto> updateUser(UserDto change);
 

	public Optional<UserDto> getUserByEmailAndPassword(String email, String pw);

	public Optional<UserDto> getUserByPassword(String email, String password);


	public boolean deleteUser(String email);

	boolean deleteUser(UserDto user);

//    UserDto updateLoginAttempt(String email, String password);

	UserDto updateLoginAttempt(String email, LoginType loginType);

	void verifyAccountKey(String key);

}
