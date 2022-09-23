package apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

// convert calendar date to yyyy-MM-dd format.
//inActiveDate = Wed Sep 26 00:00:00 IST 2012. ==> 2012-09-26. 
public class DateActions {
	
	// java.time.formatter.DataTimeFormatter
	public static void timeFormatterThis(String sPattern) { //"yyyy-MM-dd"
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(sPattern);
		String date = dateObj.format(formatter);
		System.out.println("java.time.formatter.DataTimeFormatter[.ofPattern]");
		System.out.println(date);
		// ===>2021-02-18
	}
	
	// java.text.simpleDateFormat
	public static void newLocalDateTime(String sPattern) throws ParseException {
		// No point of parsing date and keep that as Date object.
		// format the calender date object when you want 
			// to display and keep that as a string.
	
 
		System.out.println("java.time.LocalDate");
		LocalDate dateDate = LocalDate.of(2022, Month.JULY, 14);
		System.out.println(dateDate.plusMonths(2).plusDays(7));
		System.out.println(dateDate.getDayOfMonth());
		
		System.out.println("java.time.LocalTime");
		LocalTime timeTime = LocalTime.of(9, 05,30); 
		
		System.out.println("java.time.LocalDateTime");
		LocalDateTime gameStartTime = LocalDateTime.of(dateDate,  timeTime);
		
		System.out.println("ava.time.ZonedDateTime==> java.time.ZoneId");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(gameStartTime, ZoneId.of("Europe/London"));
		
		ZonedDateTime zonedDateTimeLA = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		
	}
	
	public static void intervalTiming(String stringLetters) {
		//		stringLetters = "a b c a b abc cc cc a";

		System.out.println("java.time.Duration");
		Instant startTime = Instant.now();
		
		HashMap<String,Integer> map = new HashMap<String, Integer>(); 
		String[] strArray = stringLetters.split(" "); 
		int count = 0;
		for(int i = 0;i<strArray.length;i++) {
			if(!map.containsKey(strArray[i])) {
				map.put(strArray[i], count+1);
			} else {
				map.computeIfPresent(strArray[i], (k,v) -> v+1);
			} 
		}
		System.out.println(map); 
		
		Instant endTime = Instant.now();
		Duration timeTaken = Duration.between(startTime, endTime);
		System.out.println("TimeTaken for MApping: "+ timeTaken);
	}
	
	// java.text.simpleDateFormat
	public static void convertToText(String sPattern) throws ParseException { 
		// java.util.Calendaa
		System.out.println("java.util.Calendar");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date date = cal.getTime();   
		
		SimpleDateFormat format1 = new SimpleDateFormat(sPattern);          
		String inActiveDate = null;
		 
		inActiveDate = format1.format(date); 
		System.out.println(inActiveDate );
	} 
}
