package app.mapl.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilitiesTest {
    public static final String THOMASM_1_MAESTAS_GMAIL_COM = "thomas1.maestas@gmail.com";

    public static final String INVALID_NO_ASTERISK_COM = "thomas1.maestasgmail.com";

    @BeforeEach
    void setUp() {
        String email = THOMASM_1_MAESTAS_GMAIL_COM;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void isAValidEmailAddress() {
        String email = THOMASM_1_MAESTAS_GMAIL_COM;
        boolean isValid = Utilities.isAValidEmailAddress(email);
        assert(isValid);
    }
    @Test
    public void isAValidEmailAddressNoAsterisk() {
        String email = INVALID_NO_ASTERISK_COM;
        boolean isValid = Utilities.isAValidEmailAddress(email);
        assert(!isValid);
    }

    @Test
    void startupTime() {
    }

    @Test
    void getReflectionInfo_getName() {

    }

    @Test
    void getReflectionInfo_isInterface() {

    }

    @Test
    void getReflectionInfo_getInterfaces_length() {
    }

    @Test
    void getReflectionInfo_getSuperclass() {
    }

    @Test
    void _earlyQuit() {
    }
}
