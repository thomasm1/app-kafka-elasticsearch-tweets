package app.mapl.service;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserRequest;
import app.mapl.models.LoginType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	ResponseEntity saveUser (UserRequest userRequest);


	UserDto loginUser(String email, String password);

    void createUser(String firstName, String lastName, String email, String password);

    public UserDto createUser(UserDto user);

	public static UserDto createUserCli(UserDto user) {
		return null;
	}

	public Optional<UserDto> getUser(int id);
	public Optional<UserDto>  getUser(String email );
	public List<UserDto> getUsers();

	public Optional<UserDto> updateUser(UserDto change);

	public Optional<UserDto> getUserByEmailAndPassword(String email, String pw);

	public Optional<UserDto> getUserByPassword(String email, String password);

	Optional<UserDto> patchUserById(Integer userId, UserDto user);

	public boolean deleteUser(String email);

	boolean deleteUser(UserDto user);

    UserRequest updateLoginAttempt(String email, String password);

	void updateLoginAttempt(String email, LoginType loginType);
}
