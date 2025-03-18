package xyz.cryptomaven.rest.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utilities {

    private static final Logger log = LoggerFactory.getLogger(Utilities.class);
    public static String startupTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static List<String>  getReflectionNames(Object o) {
        List<String> info = new ArrayList<>();
        String names = "getName, getSuperclass, isInterface, getInterfaces.length";
        info.add(names);
        info.add(o.getClass().getName());
        info.add(o.getClass().getSuperclass().getName());
        info.add(String.valueOf(o.getClass().isInterface()));
        info.add(String.valueOf(o.getClass().getInterfaces().length));
        return info;
    }
    public static void getReflectionInfo(Object o) {
        System.out.println("m.getClass().getName(): " + o.getClass().getName());
        System.out.println("m.getClass().isInterface(): " + o.getClass().isInterface());
        System.out.println("m.getClass().getInterfaces().length: " + o.getClass().getInterfaces().length);
        System.out.println("m.getClass().getSuperclass().getName(): " + o.getClass().getSuperclass().getName());

    }

    public static boolean isAValidEmailAddress(String email) {
        if (email == null) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
