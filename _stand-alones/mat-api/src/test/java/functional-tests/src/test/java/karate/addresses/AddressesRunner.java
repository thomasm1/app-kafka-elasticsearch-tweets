package karate.addresses;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class AddressesRunner {

    @Karate.Test
    Karate testAddresses() {
        return Karate.run("addresses").relativeTo(getClass());
    }
}
