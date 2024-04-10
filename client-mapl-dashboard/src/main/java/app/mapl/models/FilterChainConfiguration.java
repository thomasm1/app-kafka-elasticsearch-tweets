package app.mapl.models;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;


public class FilterChainConfiguration {
DaoAuthenticationConfigurer daoAuthenticationConfigurer;

@Bean
        public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//            return new DaoAuthenticationConfigurer().authenticationProvider(daoAuthenticationProvider).getAuthenticationManager();
            return new ProviderManager(daoAuthenticationProvider);
    }
    
    @Bean 
    public UserDetailsService userDetailsService() {
      var thomas = User.withDefaultPasswordEncoder().username("thomas").password("password").roles("USER").build();
      var admin = User.withDefaultPasswordEncoder().username("admin").password("password").roles("USER").build();
        return new InMemoryUserDetailsManager(List.of(thomas, admin));
    }
 
}
