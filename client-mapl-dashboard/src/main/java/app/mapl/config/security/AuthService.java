package app.mapl.config.security;

import app.mapl.dto.LoginDto;
import app.mapl.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
