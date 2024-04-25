package app.mapl.models.auth;

import app.mapl.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static app.mapl.util.Utilities.handleErrorResponse;
import static com.fasterxml.jackson.core.JsonParser.Feature.AUTO_CLOSE_SOURCE;
import static org.springframework.boot.actuate.endpoint.web.WebEndpointHttpMethod.POST;
import static org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated;

@Slf4j
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final UsersService userService;
    private final JwtService jwtService;

    public AuthenticationFilter(AuthenticationManager authenticationManager, UsersService userService, JwtService jwtService) {
        super(new AntPathRequestMatcher((String) "/login", POST.name()), authenticationManager);
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException , ServletException {

        try {
            var user = new ObjectMapper().configure(AUTO_CLOSE_SOURCE, true).readValue(request.getInputStream(), LoginRequest.class);
            userService.updateLoginAttempt(user.getEmail(), LoginType.LOGIN_ATTEMPT);
            var authentication = unauthenticated(user.getEmail(), user.getPassword());
        } catch (Exception exception) {
            throw new BadCredentialsException("Invalid username or password");
        }
            User user = userService.updateLoginAttempt(request.getParameter("email"), LoginType.valueOf(request.getParameter("password")));
            if (user == null) {
//                log.error(exception.getMessage());
                handleErrorResponse(request, response, new BadCredentialsException("User not found"));
//            throw new BadCredentialsException("User not found");
            }

            return null; //new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), user.getRoles());

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, filterChain, authResult);
    }



}
