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
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.function.TriConsumer;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static app.mapl.models.auth.TokenType.ACCESS_TOKEN;
import static app.mapl.models.auth.TokenType.REFRESH_TOKEN;
import static app.mapl.util.constants.Constants.AUTHORITY_DELIMITER;
import static app.mapl.util.constants.Constants.ROLE_PREFIX;
import static io.jsonwebtoken.Header.JWT_TYPE;
import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@RequiredArgsConstructor
@Slf4j
public class JWTServiceImpl extends JwtConfiguration implements JwtService {
    public static final String TYPE = "TYPE";
    private static final String AUTHORITIES = "authorities" ;
    private final UsersService userService;

    /**
    // 1.) key()    Create a JWT token, Supply it.
     **
     */
    private final Supplier<SecretKey> key = () -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(getSecret()));

    private String getSecret() {
        return "secret"; // TODO: get fr
    }
    /**
     **
    * 2. tokenFunction is a function that takes a Token, sets the accessToken for the Subject, sets Expiration,  returns a String
     */
    private final Function<Token, String> tokenFunction = token ->
            Jwts.builder()
                    .setSubject(token.getAccess())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                    .signWith(key.get())
                    .compact();
    /**
     **
    * 3. claimsFunction()  is a function that takes a token, parses the token, and returns the Claims
     */
    private final Function<String, Claims> claimsFunction = token ->
                Jwts.parserBuilder().setSigningKey(key.get()).build().parseClaimsJws(token).getBody();
    /**
     **
    * 4. getClaimsValue() subject is a function that takes a token, and returns the Subject from the Claims
     */

    private final Function<String, String> subject = token -> getClaimsValue(token, Claims::getSubject);
    /**
     **
    * 5. extractToken() BiFunction that takes a request and a cookieName, and returns an Optional<String> of the cookie value
     */
    private final BiFunction<HttpServletRequest, String, Optional<String>> extractToken = (request, cookieName) ->
                Optional.of(
                        Stream.of(
                            (request.getCookies() == null  ) ? new Cookie[]{ new Cookie("empty"," ")}  :  request.getCookies()
                                )
                            .filter (cookie -> Objects.equals(cookieName, cookie.getName()))
                            .map(Cookie::getValue)
                            .findAny())
                        .orElse(Optional.empty());

/**
 ** 6. builder()  is a Supplier that returns a JwtBuilder with  claims
 */
private final Supplier<JwtBuilder> builder = () ->
            Jwts.builder()
                    .setHeader(Map.of(TYPE, JWT_TYPE))
//                    .claim("authorities", "ROLE_USER")
//                    .claim("role", "USER")
//                    .claim("userId", "1")
//                    .claim("organization", "mapl")
//                    .claim("type", "USER")
//                    .claim("email", "thomas1.maestas@gmail.com")
                    .setAudience("mapl")
                    .setId(UUID.randomUUID().toString())
                    .setIssuedAt(Date.from(Instant.now()))
                    .setNotBefore(new Date())
                .signWith(key.get());//   , Jwts.SIGNATURE_ALGORITHM);

/**
 *7. buildToken() BiFunction that takes a UserDto and TokenType, and returns a Token String
 */
private final BiFunction<UserDto, TokenType, String> buildToken = (userDto, type) ->
            Objects.equals(type, ACCESS_TOKEN) ?
                    builder.get()
                            .setSubject(userDto.getUserId())
                            .claim("authorities", userDto.getAuthorities())
                            .claim(RoleEntity.class.getSimpleName(), userDto.getRole())
                            .setExpiration(Date.from(Instant.now().plusSeconds((Long) getExpiration())))
                            .compact()
                    :
                    Jwts.builder()
                            .setSubject(userDto.getUserId())
                            .claim("authorities", userDto.getRole())
                            .compact();

    private Object getExpiration() {
        return 3600;
    }



/**
* 8. getClaimsValue() Function that takes a token and a Function<Claims, T>, and returns T
 **/
    @Override
    public <T> T getClaimsValue(String token, Function<Claims, T> claims) {
        return claimsFunction.andThen(claims).apply( token);
    }

//            return Stream.of(claims.get("authorities").toString().split(","))
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
    /**
     * 9. authorities() Function that takes a token, and returns a List of GrantedAuthority
      */
    public Function<String, List<GrantedAuthority>> authorities = token ->
        commaSeparatedStringToAuthorityList(new StringJoiner(AUTHORITY_DELIMITER)
                .add(claimsFunction
                                    .apply(token)
                                                .get(AUTHORITIES, String.class))
                .add(ROLE_PREFIX + claimsFunction
                                    .apply(token)
                                                .get("ROLE_", String.class)).toString());

    /**
     *  10. createToken() Function that takes a UserDto and a Function<Token, String>, and returns Token String
     **
     */
    @Override
    public String createToken(UserDto userDto, Function<Token, String> tokenFunction) {
        var token = Token.builder()
                .access((String) buildToken.apply(userDto, ACCESS_TOKEN))
                .refresh((String) buildToken.apply(userDto, REFRESH_TOKEN))
                .build();
        return tokenFunction.apply(token);

    }

    /**
     *
     * 11. extractToken() BiFunction that takes a request and a cookieName, and returns an Optional<String> of the cookie value
     *
     * @param request
     * @param cookieName
     * @return
     */
    @Override
    public Optional<String> extractToken(HttpServletRequest request, String cookieName) {
        return extractToken.apply(request, cookieName);
    }

    @Override
    public void addCookie(HttpServletResponse response, UserDto user, TokenType accessToken) {
        addCookie.accept(response, user, accessToken);
    }

    /**
     *
     * * 12. addCookie() TriConsume¥r that takes a response, a UserDto, and a TokenType, and adds a cookie to the response
     **
     */

    private final TriConsumer<HttpServletResponse, UserDto, TokenType> addCookie = (response, user, type) -> {
        switch(type) {
            case ACCESS_TOKEN:
                var accessToken = createToken(user, Token::getAccess);
                var cookie = new Cookie(type.getValue(), accessToken);
                cookie.setHttpOnly(true);
                //cookie.setSecure(true);
                cookie.setMaxAge(2 * 60 * 60);
                cookie.setPath("/");
                cookie.setAttribute("SameSite", "None");
                response.addCookie(cookie);
            case REFRESH_TOKEN:
                response.addCookie(new Cookie("refresh_token", (String) buildToken.apply(user, REFRESH_TOKEN)));
                break;
        }
    };



    @Override
    public <T> T getTokenData(String token, Function<TokenData, T> tokenFunction) {
        return tokenFunction.apply(
                TokenData.builder()
                    .valid(Objects.equals(userService.getUserByUserId(subject.apply(token)), claimsFunction.apply(token).getSubject()))
                    .authorities(authorities.apply(token))
                    .claims(claimsFunction.apply(token))
                        .userDto(userService.getUserByUserId(subject.apply(token)).get())
                    .build());
    }

    @Override
    public void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        var optionalCookie = extractToken.apply(request, cookieName);
        if (optionalCookie.isPresent()) {
            Cookie cookie = new Cookie(optionalCookie.get(), "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        } else {
            log.error("Cookie not found");
        }
    }

}
