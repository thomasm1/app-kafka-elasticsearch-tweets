package app.mapl.models.auth;


import app.mapl.models.dto.UserDto;
import app.mapl.service.UsersService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.function.TriConsumer;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static app.mapl.models.auth.TokenType.ACCESS_TOKEN;
import static app.mapl.models.auth.TokenType.REFRESH_TOKEN;
import static app.mapl.models.auth.User.from;
import static com.google.common.collect.Streams.stream;
import static io.jsonwebtoken.Header.JWT_TYPE;
import static io.micrometer.core.instrument.config.validate.PropertyValidator.getSecret;

import static java.util.Optional.empty;

@RequiredArgsConstructor
@Slf4j
public class JWTServiceImpl extends JwtConfiguration implements JwtService {
    public static final String TYPE = "TYPE";
    private final UsersService userService;
    private final Supplier<SecretKey> key = () -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(getSecret()));
    private final Function<String, Claims> claimsFunction = token ->
                Jwts.parser()
                        .verifyWith(key.get())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();
    private final Function<String, String> subject = token -> getClaimsValue(token, Claims::getSubject);



    private final BiFunction<HttpServletRequest, String, Optional<String>> extractToken = (request, cookieName) ->
                Optional.of(stream(request.getCookies() == null ? new Cookie[]{new Cookie("empty"," ")} : request.getCookies())
                        .filter(cookie -> Objects.equals(cookieName, cookie.getName()))
                        .map(Cookie::getValue)
                        .findAny()
                        .orElse(empty()));

    private final Supplier<JwtBuilder> builder = () ->
            Jwts.builder()
                .header().add(Map.of(TYPE, JWT_TYPE))
                    .and()
                    .audience().add("mapl")
                    .and()
                    .id(UUID.randomUUID().toString())
                    .issuedAt(from(LocalDateTime.now()))
                    .notBefore(new Date())
                .signWith(key.get(), Jwts.SIG.HS512);



    private final BiFunction<UserDto, TokenType, String> buildToken = (userDto, type) ->
            Objects.equals(type, ACCESS_TOKEN) ?
                    Jwts.builder()
                            .setSubject(userDto.getUserId())
                            .claim("authorities", userDto.getAuthorities())
                            .claim(RoleEntity.class.getSimpleName(), userDto.getRole())
                            .expiration(from(LocalDateTime.now().plusSeconds((Long) getExpiration())))
                            .compact() :
                    Jwts.builder()
                            .setSubject(userDto.getUserId())
                            .claim("authorities", userDto.getRole())
                            .expiration(from(LocalDateTime.now().plusSeconds((Long) getExpiration())))
                            .compact();

    private Object Token;
    private final TriConsumer<HttpServletRequest, UserDto, TokenType> addCookie = (response, user, type) -> {
        switch(type) {
            case ACCESS_TOKEN:
                var accessToken = createToken(userDto, Token::getAccess);
                var cookie = new Cookie(type.getValue().accessToken);
                cookie.setHttpOnly(true);
                //cookie.setSecure(true);
                cookie.setMaxAge(2 * 60 * 60);
                cookie.setPath("/");
                cookie.setAttribute("SameSite", "NONE       ");
            case REFRESH_TOKEN:
                response.addCookie(new Cookie("refresh_token", buildToken.apply(user, REFRESH_TOKEN)));
                break;
        }
    };
    private Object getExpiration() {
        return null;
    }

    private String getClaimsValue(String token, Function<Claims, String> claimsResolver) {
        return claimsResolver.apply(claimsFunction.apply(token));
    }
}
