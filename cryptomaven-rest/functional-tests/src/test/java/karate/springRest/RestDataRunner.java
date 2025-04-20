package karate.springRest;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class RestDataRunner {

    @Karate.Test
    Karate testREST() {
        return Karate.run("restData").relativeTo(getClass());
    }
}