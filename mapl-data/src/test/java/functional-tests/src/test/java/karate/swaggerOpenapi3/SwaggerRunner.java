package karate.swaggerOpenapi3;

import com.intuit.karate.junit5.Karate;

public class SwaggerRunner {

    @Karate.Test
    Karate testStartup() {
        return Karate.run( "swagger").relativeTo(getClass());
    }
}
