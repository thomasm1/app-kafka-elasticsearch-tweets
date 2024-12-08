package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.dto.RegisterDto;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	UserDto loginUser(String username, String password);
	public UserDto registerUser(UserDto user);

	User createUserCLI(User user);

	public UserDto getUser(int id);
	public UserDto getUser(String username );
	public List<UserDto> getUsers();

	public UserDto updateUser(UserDto change);

	UserDto getUserByEmailAndPassword(String email, String pw);

//	public List<User> getUsersWithCoins();

	Optional<UserDto> updateUserById(Integer userId, UserDto user);

	Optional<UserDto> patchUserById(Integer userId, UserDto user);

    public boolean deleteUser(String username);

	boolean deleteUser(UserDto user);

	UserDto getUserByEmail(String email);
}
