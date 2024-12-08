package com.friendsofgroot.app;

import com.friendsofgroot.app.models.Role;
import com.friendsofgroot.app.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//@propertySource("classpath:address.properties")
@PropertySources({
        @PropertySource("classpath:app-mapl.properties"),
        @PropertySource("classpath:address.properties"),
})
public class SpringConfig {


}
