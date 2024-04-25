package app.mapl.models.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

@RequiredArgsConstructor
public class FilterChainConfiguration {
    DaoAuthenticationConfigurer daoAuthenticationConfigurer;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request ->
                        request.requestMatchers("api/auth/**").permitAll()
                                .requestMatchers("api/auth/register/**").permitAll()
                                .requestMatchers("api/auth/index").permitAll()
                                .requestMatchers("api/auth/users").hasRole("ADMIN")
                                .requestMatchers("api/auth/users").hasRole("USER")
                                .anyRequest().authenticated())  // GLOBAL OFF for all requests  XXXXXXXX
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//            return new DaoAuthenticationConfigurer().authenticationProvider(daoAuthenticationProvider).getAuthenticationManager();
        return new ProviderManager(daoAuthenticationProvider);
    }

    /*
    * In-memory user store
    *
    * List.of(user_noop (pw not enrypted), user, admin_noop (pw not enrypted), admin));
     */
    @Bean
    public UserDetailsService userDetailsService() {

        return new InMemoryUserDetailsManager(
        User
                .withUsername("user_noop")
                .password("{noop}password")
                .roles("USER")
                .build(),
      User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build(),

        User
                .withUsername("admin_noop")
                .password("password")
                .roles("ADMIN")
                .build(),
    User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build());

    }

}
