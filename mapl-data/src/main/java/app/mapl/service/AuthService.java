package app.mapl.service;

import app.mapl.models.dto.LoginDto;
import app.mapl.models.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
