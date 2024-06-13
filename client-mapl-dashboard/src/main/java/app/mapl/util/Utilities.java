package app.mapl.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Response;
import org.springframework.http.HttpStatus;

import java.nio.file.AccessDeniedException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;
import static org.apache.logging.log4j.util.Strings.EMPTY;

public class Utilities {

    public static String startupTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
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

    public static String currentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
