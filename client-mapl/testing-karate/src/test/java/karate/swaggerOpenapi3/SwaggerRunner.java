package karate.startup;

import com.intuit.karate.junit5.Karate;

public class SwaggerRunner {

    @Karate.Test
    Karate testStartup() {
        return Karate.run( "karate/swaggerOpenapi3").relativeTo(getClass());
    }
}
