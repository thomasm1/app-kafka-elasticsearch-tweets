package app.mapl.maplconfigserver.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/actuator/**")
                    .antMatchers("/encrypt/**")
                    .antMatchers("/decrypt/**");
            super.configure(web);
        }
}
