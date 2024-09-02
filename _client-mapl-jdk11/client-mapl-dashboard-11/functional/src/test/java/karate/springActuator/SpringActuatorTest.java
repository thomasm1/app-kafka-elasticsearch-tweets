package karate.springActuator;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class SpringActuatorTest {

    @Karate.Test
    Karate testActuator() {
        return Karate.run("springActuator").relativeTo(getClass());
    }
}
