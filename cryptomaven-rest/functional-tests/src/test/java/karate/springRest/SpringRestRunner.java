package karate.springRest;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class SpringRestRunner {

    @Karate.Test
    Karate testREST() {
        return Karate.run("springRest").relativeTo(getClass());
    }
}
