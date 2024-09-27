package utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class JavaUtils {
    public JavaUtils() {
        System.out.println("JAVA_UTILS_____________________ ");
    }

    public long timestampFromDate(String unit, int count) throws ParseException {
        String pattern = "MM/dd/yyyy";
        String dateString = dateStringRelative(unit, count, pattern);
        return getTimestampFromDate(Long.valueOf(dateString), pattern);
    }
    public long getTimestampFromDate(Long dateString, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(String.valueOf(dateString));
        return (date.getTime()) / 1000;
    }
    public String dateStringCurrent(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    public String dateStringRelative(String unit, int count, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime past;
        switch(unit) {
            case "years":
                past = LocalDateTime.now().plusYears(count);
                break;
            case "months":
                past = LocalDateTime.now().plusMonths(count);
                break;
            case "weeks":
                past = LocalDateTime.now().plusWeeks(count);
                break;
            case "days":
                past = LocalDateTime.now().plusDays(count);
                break;
            case "hours":
                past = LocalDateTime.now().plusHours(count);
                break;
            case "minutes":
                past = LocalDateTime.now().plusMinutes(count);
                break;
            case "secondss":
            default:
                past = LocalDateTime.now().plusSeconds(count);
        }
        return formatter.format(past);
    }

    public boolean isValidDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            formatter.parse(dateString);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public String insertCommas(String s) {
        double d = Double.parseDouble(s);
        DecimalFormat formatter = new DecimalFormat("#,###");

        return formatter.format(d);
    }

//    public String getValueFromJSONArray(String json, int index, String key) {
//        JSONArray arr = new JSONArray(json);
//        JSONObject obj = arr.get(index);
//        return obj.getString(key);
//    }

    public void writeToFile(String dir, String filename, String text) throws IOException {
        FileWriter fw = new FileWriter(dir + filename, false);
        fw.write(text);
        fw.close();
        System.out.println(":::::: .......filename  {}"+ filename+" ...text : "+ text);
    }

}
