package app.mapl.models;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class ApiAuthentication extends AbstractAuthenticationToken {
    private static final String PASSWORD_PROTECTED = "PASSWORD_PROTECTED";
    private static final String EMAIL_PROTECTED = "EMAAL_PROTECTED";
    private String email;
    private String password;

    private boolean authenticated;

    public ApiAuthentication(User user, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.user = user;
        this.password = PASSWORD_PROTECTED;
        this.email = EMAIL_PROTECTED;
        this.authenticated = true;

    }
    @Override
    public Object getCredentials() {
        return null;
    }
    @Override
    public Object getPrincipal() {
        return null;
    }
}
