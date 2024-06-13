package app.mapl.models.auth;

import app.mapl.models.dto.UserDto;
import app.mapl.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static app.mapl.exception.ApiException.handleErrorResponse;
import static com.fasterxml.jackson.core.JsonParser.Feature.AUTO_CLOSE_SOURCE;
import static java.time.LocalTime.now;
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
            var user = new ObjectMapper().configure(AUTO_CLOSE_SOURCE, true).readValue(request.getInputStream(), LoginRequest.class);  //
            userService.updateLoginAttempt(user.getEmail(), LoginType.LOGIN_ATTEMPT);
            var authentication = unauthenticated(user.getEmail(), user.getPassword());
            return getAuthenticationManager().authenticate(authentication);
        } catch (Exception exception) {
//            throw new BadCredentialsException("Invalid username or password");
            handleErrorResponse(request, response, new BadCredentialsException("User not found"));
            return null; //new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), user.getRoles());
           } finally {
            log.info("Login attempt at {}", now());
            return null;
        }


    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authResult) throws IOException, ServletException {
        var user = (UserDto) authResult.getPrincipal(); // PRINCIPAL is the DTO
        userService.updateLoginAttempt(user.getEmail(), LoginType.LOGIN_SUCCESS);
       var httpResponse = user.isMfa();
         if (  httpResponse==true ) {
             sendQrCode(request, user); }
         else {
             sendResponse(request, response, user);
         }
        response.setContentType("application/json");
         response.setStatus(HttpStatus.OK.value());
         var out = response.getOutputStream();
         var mapper = new ObjectMapper();
         mapper.writeValue(out, httpResponse);
          out.flush();

    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response, UserDto user) {
        jwtService.addCookie(response, user, TokenType.ACCESS_TOKEN);
        jwtService.addCookie(response, user, TokenType.REFRESH_TOKEN);
    }

    private Response sendQrCode(HttpServletRequest request, UserDto user) {
        return getResponse(request,Map.of("user", (List<String>) user), "qrCode, please enter", HttpStatus.OK);
    }
    public static Response getResponse(HttpServletRequest request, Map<String, List<String>> data, String message, HttpStatus status) {
        return null; //new Response(status, null);

    }

}
