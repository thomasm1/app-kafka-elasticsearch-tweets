package app.mapl.models.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MaplAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    /**
     * @param authentication
     * @return
     * @throws AuthenticationException
     *
     *      userAuthToken.getPrincipal() returns the userDto  - email
     *      userAuthToken.getCredentials() returns the password
     *
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var userAuthToken = (UsernamePasswordAuthenticationToken) authentication;  // soon to deprecate UsernamePasswordAuthenticationToken

        var userFromDb = userDetailsService.loadUserByUsername((String) userAuthToken.getPrincipal());
        var password = (String) userAuthToken.getCredentials();
        if (userFromDb != null && password.equals(userFromDb.getPassword())) {
            return   UsernamePasswordAuthenticationToken.authenticated(userFromDb, "[PASSWORD_PROTECTED]", userFromDb.getAuthorities());
        }
        throw new BadCredentialsException("Invalid username or password");
    }

    /**
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
