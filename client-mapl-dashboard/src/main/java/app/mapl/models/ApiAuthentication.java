package app.mapl.models;

import app.mapl.exception.ApiException;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;


public class ApiAuthentication extends AbstractAuthenticationToken {
    private static final String PASSWORD_PROTECTED = "PASSWORD_PROTECTED";
    private static final String EMAIL_PROTECTED = "EMAAL_PROTECTED";
    private User user;
    private String email;
    private String password;

    private boolean authenticated;
//    private ApiAuthentication(String email, String password) {
//        super(AuthorityUtils.NO_AUTHORITIES);
//        this.email = email;
//        this.password = password;
//        this.authenticated = false;
//    }
//
//    private ApiAuthentication(User user, Collection<? extends GrantedAuthority> authorities) {
//        super(authorities);
//        this.user = user;
//        this.password = PASSWORD_PROTECTED;
//        this.email = EMAIL_PROTECTED;
//        this.authenticated = true;
//
//    }
    public ApiAuthentication(String email, String password) {
        super(AuthorityUtils.NO_AUTHORITIES);
        this.email = email;
        this.password = password;
        this.authenticated = false;
    }
    public ApiAuthentication(User user, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.user = user;
        this.password = PASSWORD_PROTECTED;
        this.email = EMAIL_PROTECTED;
        this.authenticated = true;

    }
    public ApiAuthentication unauthenticated(String email, String password) {
        return new ApiAuthentication(email, password);
    }
    public static ApiAuthentication authenticated(User user, Collection<? extends GrantedAuthority> authorities) {
        return new ApiAuthentication(user, authorities);
    }
        @Override
    public Object getCredentials() {
        return PASSWORD_PROTECTED;
    }
    @Override
    public Object getPrincipal() {
        return this.user;

    }
    @Override
    public void setAuthenticated(boolean authenticated) {
        throw new ApiException("You cannot set authentication");
    }
    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }
}
