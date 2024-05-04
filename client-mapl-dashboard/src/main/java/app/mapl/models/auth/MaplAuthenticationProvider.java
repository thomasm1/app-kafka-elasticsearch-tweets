package app.mapl.models.auth;

import app.mapl.exception.ApiException;
import app.mapl.mapper.UserMapper;
import app.mapl.models.dto.UserDto;
import app.mapl.service.UsersServiceJPA;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;

import static app.mapl.models.auth.MaplAuthentication.authenticated;

@Component
@RequiredArgsConstructor
public class MaplAuthenticationProvider implements AuthenticationProvider {

    private final MaplAuthentication maplAuthentication;
//    private final UserDetailsService userDetailsService;  // overriding the authenticate method of the AuthenticationProvider interface
        private final UsersServiceJPA usersService;
        private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;



    /**
     * @param authentication
     * @return
     * @throws AuthenticationException
     *
//    Centerpiece of this auth design is overwriting the authenticate method of the AuthenticationProvider interface.
     *      userAuthToken.getPrincipal() returns the userDto  - email
     *      userAuthToken.getCredentials() returns the password
     *
     *      The authenticate method is responsible for authenticating the user. It is the method that will be called by the AuthenticationManager.authenticate method.
     *      The method receives an Authentication object, which contains the user’s credentials. The method should return an Authentication object if the user is authenticated, or throw an AuthenticationException if the user is not authenticated.
     *
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        var userAuthToken = (UsernamePasswordAuthenticationToken) authentication;  // soon to deprecate UsernamePasswordAuthenticationToken
        var userAuthToken = authenticationFunction.apply(authentication);
        var userFromDb = usersService.getUserByEmail(maplAuthentication.getEmail());

        if (userFromDb.isPresent()) { //&& password.equals(userFromDb.getPassword())) {
            var userCredential = usersService.getUserCredentialById(userFromDb.get().getId());
            if (userCredential.getUpdatedAt().minusDays(90).isAfter(LocalDateTime.now())) {
                throw new ApiException("Credentials expired. Please reset your password");
            }
            var userPrincipal = new UserPrincipal(userMapper.toDto(userFromDb.get()), userCredential);
            validAccount.accept(userPrincipal);
            if(encoder.matches(maplAuthentication.getPassword(), userCredential.getPassword())) {
                return authenticated(userMapper.toDto(userFromDb.get()), userPrincipal.getAuthorities()); //new UsernamePasswordAuthenticationToken(userPrincipal, "[PASSWORD_PROTECTED]", userPrincipal.getAuthorities());
            } else throw new BadCredentialsException("Invalid username or password");
        } throw new ApiException("Invalid username or password");
    }

    /**
     * @param authentication
     * @return
     */
    @Override

    public boolean supports(Class<?> authentication) {
        //return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        return MaplAuthentication.class.isAssignableFrom(authentication);
    }

    private final Function<Authentication, MaplAuthentication> authenticationFunction = authentication -> (MaplAuthentication) authentication;

    private final Consumer<UserPrincipal> validAccount = userPrincipal -> {
        if (userPrincipal == null) {      throw new ApiException("Invalid username or password");   }
        if (userPrincipal.isAccountNonLocked()) {      throw new LockedException("Account NonLocked");  }
        if (userPrincipal.isEnabled()) {      throw new DisabledException("Account is Disabled");  }
        if (userPrincipal.isCredentialsNonExpired()) {      throw new CredentialsExpiredException("Account is Credentials NonExpired");  }
        if (userPrincipal.isAccountNonExpired()) {      throw new DisabledException("Account is expired");  }

    };
}
