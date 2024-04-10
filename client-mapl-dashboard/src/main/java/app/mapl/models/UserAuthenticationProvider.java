package app.mapl.models;

import com.mysql.cj.conf.PropertySet;
import com.mysql.cj.exceptions.ExceptionInterceptor;
import com.mysql.cj.protocol.AuthenticationProvider;
import com.mysql.cj.protocol.Protocol;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;

//    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
//        var user = (UsernamePasswordAuthenticationToken) authentication;
//        var userFromDb = userDetailsService.loadUserByUsername((String) user.getPrincipal());
//        var password = user.getCredentials().toString();
//        if (password.equals(userFromDb.getPassword())) {
//                 return UsernamePasswordAuthenticationToken.authenticated(userFromDb, userFromDb.getPassword(), userFromDb.getAuthorities());
//        }
//        throw new BadCredentialsException("Bad credentials");
//    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var user = (UsernamePasswordAuthenticationToken) authentication;
        var userFromDb = userDetailsService.loadUserByUsername((String) user.getPrincipal());
        var password = user.getCredentials().toString();
        if (password.equals(userFromDb.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userFromDb, userFromDb.getPassword(), userFromDb.getAuthorities());
        }
        throw new BadCredentialsException("Bad credentials");
    }
    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        return false;
    }

    /**
     * @param protocol
     * @param propertySet
     * @param exceptionInterceptor
     */
    @Override
    public void init(Protocol protocol, PropertySet propertySet, ExceptionInterceptor exceptionInterceptor) {

    }

    /**
     * @param s
     * @param s1
     * @param s2
     */
    @Override
    public void connect(String s, String s1, String s2) {

    }

    /**
     * @param s
     * @param s1
     * @param s2
     */
    @Override
    public void changeUser(String s, String s1, String s2) {

    }
}
