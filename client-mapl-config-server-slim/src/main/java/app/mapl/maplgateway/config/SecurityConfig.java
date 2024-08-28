package app.mapl.maplgateway.config;

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
