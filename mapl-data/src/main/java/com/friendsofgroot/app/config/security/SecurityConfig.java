package com.friendsofgroot.app.config.security;

//import com.friendsofgroot.app.dataLoader.UserDetailsCommanLineRunner;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.function.Function;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SecurityConfig {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    private UserDetailsService userDetailsService;
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    private JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(
            UserDetailsService userDetailsService,
            JwtAuthenticationEntryPoint authenticationEntryPoint,
            JwtAuthenticationFilter authenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public static PasswordEncoder passwordMaplEncoder() {
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
        http.csrf().disable()  //CSRF disablec
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll() // login & register

                                .requestMatchers(HttpMethod.GET, "/actuator/**").permitAll() //  Spring Actuator
                                .requestMatchers(HttpMethod.GET, "/rest/**").permitAll() // Spring Rest API (singular: /address,/user)
                                .requestMatchers(HttpMethod.GET, "/v1/**").permitAll() // native ad-hoc jstl admin dashboard UI
                                .requestMatchers(HttpMethod.GET, "/api/**").permitAll() //  API

                                .requestMatchers(HttpMethod.POST, "/api/**").permitAll() //  API
                                .requestMatchers(HttpMethod.PUT, "/api/**").permitAll() //  API
                                .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll() //  API

                                .requestMatchers(HttpMethod.GET, "/v3/api-docs").permitAll() // Open API
                                .requestMatchers(HttpMethod.GET, "/v3/api-docs", "/v3/api-docs/**").permitAll() // Open API
                                .requestMatchers(HttpMethod.GET,  "/swagger-ui/**","/swagger-ui/index.html" ).permitAll() // Open API

                                .requestMatchers(HttpMethod.GET, "/h2-console/**","/h2-console/","/h2-console").permitAll() // H2
                                .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(authenticationEntryPoint)
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().disable();  //Frames disable [h2 uses]
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    // FORM
//    http.formLogin(httpwithDefaults());
//        http.authorizeRequests().anyRequest().permitAll();

}
