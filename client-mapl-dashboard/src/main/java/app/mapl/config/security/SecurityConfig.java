package app.mapl.config.security;

//import app.mapl.dataLoader.UserDetailsCommanLineRunner;


//import com.mapl.app.dataLoader.UserDetailsCommanLineRunner;
import app.mapl.dto.UserDto;
import app.mapl.service.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.function.Function;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger log =
            LoggerFactory.getLogger(SecurityConfig.class);

    private UserDetailsService userDetailsService;

    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    private JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtAuthenticationEntryPoint authenticationEntryPoint,
                          JwtAuthenticationFilter authenticationFilter){
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFilter = authenticationFilter;
    }


    // DISABLE WHEN CONNECTED TO LDAP or DB
    @Bean
    @Profile(value={"test"})
    InMemoryUserDetailsManager createUserDetailsManager() {
        log.info("createUserDetailsManager");

        UserDetails userDetails1 = createNewUser("admin", "password");

        UserDetails userDetails2 = User.builder()
                .username("guest")
                .password(passwordMaplEncoder().encode("password"))
                .authorities(new SimpleGrantedAuthority("USER"))
                .build();
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }
    private UserDetails createNewUser(String username, String password) {
        log.info("createNewUser");

        Function<String, String> passwordEncoding
                = input -> passwordMaplEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoding)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();

        return userDetails;
    }

    @Bean
    public static PasswordEncoder  passwordMaplEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        log.info("authenticationManager");
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("sec___________securityFilterChain__________________ filterChain");

        //All URLs are protected A login form is shown for unauthorized requests
        http.csrf().disable()  //CSRF disable
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll() // login
                                .requestMatchers(HttpMethod.GET, "/actuator/**").permitAll() //  Spring Actuator
                                .requestMatchers(HttpMethod.GET, "/api/**").permitAll() //  API
                                .requestMatchers(HttpMethod.POST, "/api/**").permitAll() //  API
                                .requestMatchers(HttpMethod.PUT, "/api/**").permitAll() //  API
                                .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll() //  API
                                .requestMatchers(HttpMethod.GET, "/v1/**").permitAll() // native ThymeLeaf UI
                                .requestMatchers(HttpMethod.POST, "/v1/**").permitAll() // native ThymeLeaf UI
                                .requestMatchers(HttpMethod.GET, "/rest/**").permitAll() // Spring Rest API
                                .requestMatchers(HttpMethod.GET, "/v3/api-docs**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Open API
                                .requestMatchers(HttpMethod.GET, "/h2-console/**").permitAll() // H2
                                .anyRequest().authenticated()
                )
                .exceptionHandling( exception -> exception
                        .authenticationEntryPoint(authenticationEntryPoint)
                ).sessionManagement( session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // FORM
//    http.formLogin(httpwithDefaults());
//        http.authorizeRequests().anyRequest().permitAll();
        http.headers().frameOptions().disable();   //Frames disable [h2 uses]
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }


//////////////////// CUSTOM

    static final String ADMIN = "admin";
    static final String ADMIN_PASSWORD = "pass";

    static String getAuthenticatedUsername() {
        System.out.println("getAuthenticatedUsername");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = null;
        currentUsername = authentication.getName();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUsername = "SETUP FOR: *" + currentUsername + "* now complete.\n  " +
                    "  ... now preparing your Dashboard";
            return currentUsername;
        }
        currentUsername = "SETUP FOR AnonymousAuthenticationToken:" + currentUsername + "* now complete.\n  " +
                "  ... now preparing your Anonymous Dashboard";
        return currentUsername;
    }

    public static boolean checkDbUsernameAndPassword(String un, String pw) {

        UsersServiceImpl usersService = new UsersServiceImpl();
        System.out.println("checkDbUsernameAndPassword"+usersService.getUsers());
        // returns null if not in DB params: EMAIL
        UserDto login = new UserDto();
        try {
            login = usersService.getUserByEmail(un).orElseThrow(NullPointerException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //	    VALIDATION #2 - Check targeted DB User against logged-in Username & password
        if (login != null && (un.contentEquals(
                login.getEmail())
                && pw.contentEquals(  login.getPassword()  )
        )) {
            System.out.println(
                    "...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
            String name = (login.getFirstName() != null) ? login.getFirstName() : un;
            System.out.println("Welcome, *" + name + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            System.out.println("...sorry, password does not match our records for *" + un + "* #1");
        }
        return false;
    }

    public static boolean hardCodedAdminNameAndPassword(String un, String pw) {
        log.info("hardCodedAdminNameAndPassword"+" un: "+un+" pw: "+pw+" ADMIN: "+ADMIN+" ADMIN_PASSWORD: "+ADMIN_PASSWORD);

        if (un.contentEquals(ADMIN) && pw.contentEquals(ADMIN_PASSWORD)) {
            System.out.println("Welcome Internal Administrator, *" + un + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            return false;
        }
    }
}
