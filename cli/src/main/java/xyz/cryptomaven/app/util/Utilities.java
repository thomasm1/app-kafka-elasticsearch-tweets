package xyz.cryptomaven.app.util;

import xyz.cryptomaven.app.consoles.MainDashboard;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public static String startupTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static void _earlyQuit(String[] args) {
        if (args.length < 1) return;
        if (args.length < 2) {
            if (args[0].matches("quit|exit|q")) {
                MainDashboard.mainConsole();
            }
        } else {
            for (String s : args) {
                if (s.matches("quit|exit|q")) {
                    MainDashboard.mainConsole();
                }
            }
        }
    }
}
