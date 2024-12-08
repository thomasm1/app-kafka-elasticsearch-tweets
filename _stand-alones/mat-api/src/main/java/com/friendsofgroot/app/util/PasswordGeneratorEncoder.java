//package com.friendsofgroot.app.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class PasswordGeneratorEncoder {
//    private static final Logger log =
//            LoggerFactory.getLogger(PasswordGeneratorEncoder.class);
//
//    public static void main(String[] args) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("password"));
//        log.info(passwordEncoder.encode("password"));
//        log.info("admin");
//        System.out.println(passwordEncoder.encode("admin"));
//        log.info(passwordEncoder.encode("admin"));
//    }
//}
