package xyz.climongoapp.methods;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateLegacy {
    private String name = "dateLegacy";

    public DateLegacy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println("\nDate class: ");
        Date currentDate = new Date();
        System.out.println("current" + currentDate);
        System.out.println("current in Milli: " + currentDate.getTime());

        Calendar expiryDate = new GregorianCalendar(2022, 9, 23);
        System.out.println("expiryDate " + expiryDate);
        System.out.println("expiryDate.getTime(); " + expiryDate.getTime());


        expiryDate.roll(Calendar.MONTH, 11);
        System.out.println("new expiryDate (roll): " + expiryDate.getTime());

        // Time Zone Demo
        System.out.println("\nTimeZones ... ");
        String[] timeZones = TimeZone.getAvailableIDs();
        for (int i = 0; i < timeZones.length;i++) {
            System.out.println(timeZones[i]);
            i += 20;
        }
        // no-arg constructor below ==> default timezone
        Calendar gameStartTime = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
        gameStartTime.set(2017, Calendar.JULY, 03, 9, 00);
        // System.out.println("gameStartTime: " +  gameStartTime);
        System.out.println("gameStartTime.getTime: " + gameStartTime.getTime());
        System.out.println("London time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");

        gameStartTime.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        System.out.println("Indian time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");

        gameStartTime.setTimeZone(TimeZone.getTimeZone("GMT-08:30"));
        System.out.println("Custome time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");

        // DST: Change Calendar.JANUARY to Calendar.JULY. GMT would be 8 and London would be at 9 (GMT+1)
        // UK observes DST from March to October (British Summer Time)

        // After/Before demonstration
        Calendar gameFinal = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
        gameFinal.set(2017, Calendar.JULY, 16, 9, 00);
        System.out.println("After? " + gameStartTime.after(gameFinal));
        System.out.println("Before? " + gameStartTime.before(gameFinal));
    }
}