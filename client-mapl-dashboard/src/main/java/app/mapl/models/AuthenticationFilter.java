package app.mapl.models;

import app.mapl.dto.UserRequest;
import app.mapl.service.UsersService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

import static org.springframework.boot.actuate.endpoint.web.WebEndpointHttpMethod.POST;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final UsersService userService;
    private final JwtService jwtService;
    public AuthenticationFilter(AuthenticationManager authenticationManager, UsersService userService, JwtService jwtService) {
        super(new AntPathRequestMatcher((String) "/login", POST.name()), authenticationManager);
        this.userService = userService;
        this.jwtService = jwtService;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        UserRequest user = userService.updateLoginAttempt( request.getParameter("email") , request.getParameter("password"));
        if (user == null) {
            throw new BadCredentialsException("User not found");
        }
        return null;
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws ServletException, IOException {
       super.successfulAuthentication(request, response, chain, authResult);
    }
}
