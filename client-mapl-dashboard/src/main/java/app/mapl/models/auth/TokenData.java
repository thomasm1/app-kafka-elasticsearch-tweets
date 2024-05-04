package app.mapl.models.auth;

import app.mapl.models.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Map;

/**
* FROM: interface Claims extends Map<String, Object>, ClaimsMutator<io.jsonwebtoken.Claims> {
* String ISSUER = "iss";
* String SUBJECT = "sub";
* String AUDIENCE = "aud";
* String EXPIRATION = "exp";
* String NOT_BEFORE = "nbf";
* String ISSUED_AT = "iat";
* String ID = "jti";
 **/
@Builder
@Getter
@Setter
public class TokenData {
    private UserDto userDto;
    private Claims claims;
    private Boolean valid;
    private List<GrantedAuthority> authorities;

//    private String subject;
//    private String issuer;
//    private String audience;
//    private Long expiration;
//    private Long issuedAt;
//    private String token;
//    private TokenType tokenType;
}
