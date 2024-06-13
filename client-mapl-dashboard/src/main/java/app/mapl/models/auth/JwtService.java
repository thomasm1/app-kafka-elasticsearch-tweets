package app.mapl.models.auth;

import app.mapl.models.dto.UserDto;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;
import java.util.function.Function;

public interface JwtService {

    String createToken(UserDto userDto, Function<Token, String> tokenFunction);

    /*
    * 11. getClaimsValue() Function that takes a token and a Function<Claims, T>, and returns T
     */
    <T> T getClaimsValue(String token, Function<Claims, T> claims);

    Optional<String> extractToken(HttpServletRequest request, String cookieName);

    <T> T getTokenData(String token, Function<TokenData, T> tokenFunction);

    public void addCookie(HttpServletResponse response, UserDto user, TokenType accessToken);

    public abstract void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName);
}
