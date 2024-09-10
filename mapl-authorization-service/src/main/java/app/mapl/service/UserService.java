package app.mapl.service;

import app.mapl.dto.UserDto;
import app.mapl.models.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
