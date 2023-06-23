package app.mapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.mapl.dao.UserDAO;
import app.mapl.dao.UserDAOimpl;
//import db.DB;
import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value={"dev"})
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
	// DB.users.put(c.getUserID(), c);

	public static UserMapper userMapper;
	public static UserDAO userdaoImpl; // Interface Dao Ref-type, & userImpl is object

	/**
	 * @param rDto
	 */
	@Override
	public void registerUser(RegisterDto rDto) {
	}

	/**
	 * @param username;
	 * @param password;
	 * @return
	 */
	@Override
	public UserDto loginUser(String username, String password) {
		return null;
	}

	public static UserDto createUserCli(UserDto userDto) {
		System.out.println("Passing User Service userdao.createUser(u); ...");
		User uuu = userdaoImpl.createUser(userMapper.toEntity(userDto));
		return userMapper.toDto(uuu);
	}

	/**
	 * @param id;
	 * @return Optional<UserDto>
	 */
	@Override
	public Optional<UserDto> getUser(int id) {
		return Optional.empty();
	}

	/**
	 * @param username;
	 * @return Optional<UserDto>
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
	public UserDto updateUser(UserDto change) {
		return null;
	}

	/**
	 * @param userDto;
	 * @return UserDto
	 */

	public static UserDto createUserCLI(UserDto userDto) {
		System.out.println("Passing User Service userdao.createUser(u); ...");
		User uuu = userdaoImpl.createUser(userMapper.toEntity(userDto));
		return userMapper.toDto(uuu);
	}

	/**
	 * @param user
	 * @return
	 */
	public UserDto createUser(UserDto user) {
		System.out.println("Passing UserDto Service userdao.createUser(u); ...");
	return userMapper.toDto(userdaoImpl.createUser(userMapper.toEntity(user)));
	}

	;

	public static Optional<UserDto> getUserCli(int id) {
		System.out.println("Passing User Service getUser(String id) {...");

		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUser(id)));
	};

	public Optional<UserDto> getUserByEmail(String un) {
		System.out.println("Passing User Service getUser(SString username) {...");
		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUserbyEmail(un)));

	}
	public static Optional<UserDto> getUserCli(String username ) {
		System.out.println("Passing User Service getUser(SString username) {...");
		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUser(username)));
	};
	public static List<UserDto> getUsersCli() {
		System.out.println("Passing User Service userdao.getAllUsers() { ...");
		List<User> a = new ArrayList<>(userdaoImpl.getUsers());
		return a.stream().map(x -> userMapper.toDto(x)).toList();

	};

	public static UserDto updateUserCli(UserDto change) {
		System.out.println("Passing User Service userdao.updateUser(User change) {..");
		return userMapper.toDto(userdaoImpl.updateUser(userMapper.toEntity(change)));
	}

	/**
	 * @param email
	 * @param pw
	 * @return
	 */
	@Override
	public Optional<UserDto> getUserByEmailAndPassword(String email, String pw) {
		return null;
	}

	public static UserDAO getUserdao() {
		System.out.println("Passing User Service userdao.getUserdao() {..");
		return userdaoImpl;
	}

	public static List<String> getUsersWithCoins() {
		System.out.println("Passing User Service userdao.getUsersWithCoins() {...");
		return userdaoImpl.getUsersWithCoins();
	}

	public Optional<UserDto> getUserByPassword(String username, String password) {
		System.out.println("Passing User Service userdao.getUserByPassword(String username, String password)...");
		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUserByPassword(username, password)));
	}
	public static boolean deleteUserCli(String username) {
		System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
		return userdaoImpl.deleteUser(username);
	}
	public boolean deleteUser (String username) {
		System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
		return userdaoImpl.deleteUser(username);
	}
	/**
	 * @param user
	 * @return
	 */
	@Override
	public boolean deleteUser(UserDto user) {
		System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
		User u = userMapper.toEntity(user);
		return userdaoImpl.deleteUser(String.valueOf(u));
	}

}
