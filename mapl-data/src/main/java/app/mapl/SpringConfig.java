package app.mapl;

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
