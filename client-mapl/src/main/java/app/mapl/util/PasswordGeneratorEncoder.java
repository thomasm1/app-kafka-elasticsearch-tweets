package app.mapl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGeneratorEncoder {
    private static final Logger log =
            LoggerFactory.getLogger(PasswordGeneratorEncoder.class);

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("password"));
        log.info(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("guest"));
        System.out.println(passwordEncoder.encode("pass"));
    }
}
