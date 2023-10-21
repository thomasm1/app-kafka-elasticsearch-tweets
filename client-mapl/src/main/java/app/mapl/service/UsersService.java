package app.mapl.service;

import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	void registerUser(RegisterDto rDto);

	UserDto loginUser(String username, String password);
	public UserDto createUser(UserDto user);

	public static UserDto createUserCli(UserDto user) {
		return null;
	}

	public Optional<UserDto> getUser(int id);
	public Optional<UserDto>  getUser(String username );
	public List<UserDto> getUsers();

	public Optional<UserDto> updateUser(UserDto change);

	public Optional<UserDto> getUserByEmailAndPassword(String email, String pw);

	public Optional<UserDto> getUserByPassword(String username, String password);

	Optional<UserDto> patchUserById(Integer userId, UserDto user);

	public boolean deleteUser(String username);

	boolean deleteUser(UserDto user);

}
