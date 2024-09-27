package app.mapl.util.methods;

import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class PerformSystemCheck implements Runnable {
    private String checkWhat;
    ReentrantLock lock = new ReentrantLock();
    public PerformSystemCheck(String checkWhat) { this.checkWhat = checkWhat; }

    @Override
     public void run() {  //synchronized public void run();
        lock.lock();
        System.out.println("LOCKED");
        System.out.println("Checking " +this.checkWhat);
        lock.unlock();
        System.out.println("UNLOCKED");
    }
}
class GetTheMail implements Runnable {
    private int startTime;
    public GetTheMail(int startTime) {        this.startTime = startTime;    }
    @Override
    public void run() {
        try {
            Thread.sleep(startTime * 1000);
        } catch (InterruptedException e) {         }
        System.out.println("checking Mail: "+ new Date());
    }
}
public class DateLegacyThread extends Thread {
    public static void addThreadsToPool() {
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);

        eventPool.scheduleAtFixedRate(new DateLegacyThread(), 0,2, TimeUnit.SECONDS);
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("System C: Calendar"), 2,3, TimeUnit.SECONDS); // ? not printing
        eventPool.scheduleAtFixedRate(new PerformSystemCheck("System G: GetMail"), 2,4, TimeUnit.SECONDS); // ? not printing
        System.out.println("Number of Threads: "+  Thread.activeCount());
        Thread[] listOfThreads = new Thread[Thread.activeCount()];
        Thread.enumerate(listOfThreads);
        for(Thread i: listOfThreads) {
            System.out.println("getName(): " + i.getName());
            System.out.println("getPriority(): " + i.getPriority());
        }
        eventPool.shutdown();
        try{
            Thread.sleep(25000);
        } catch (InterruptedException e) {      }
        for(Thread i: listOfThreads) {
            System.out.println("getName(): " + i.getName());
            System.out.println("getPriority(): " + i.getPriority());
        }
    }
    public void run() {
        Date rightNow;
        Locale currentLocale;
        DateFormat tFormatter;
        DateFormat dFormatter;
        String tOutput;
        String dOutput;

        rightNow = new Date();
        currentLocale = new Locale("en");
        tFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
        dFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);

        tOutput = tFormatter.format(rightNow);
        dOutput = dFormatter.format(rightNow);

        System.out.println("run() ...formatted time: " + tOutput);
        System.out.println("run() .... formatted date: " + dOutput);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {  }
    }

    public static void main(String[] args) {

        Runnable performSystemCheckA = new PerformSystemCheck("System A");
        Runnable performSystemCheckB = new PerformSystemCheck("System B");
        new Thread(performSystemCheckA).start();
        new Thread(performSystemCheckB).start();

        Thread getTime = new DateLegacyThread();
        Runnable getMail = new GetTheMail(3);
        Runnable getMailAgain = new GetTheMail(4);

        getTime.start();
        new Thread(getMail).start();
        new Thread(getMailAgain).start();

        addThreadsToPool();

        System.out.println("\nDate class: ");
        Date currentDate = new Date();
        System.out.println("currentDate: " + currentDate);
        System.out.println("currentDate.getTime() [in Milli]: " + currentDate.getTime());

        Calendar expiryDate = new GregorianCalendar(2022, 9, 23);
        System.out.println("expiryDate: " + expiryDate);
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
