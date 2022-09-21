package apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

// convert calendar date to yyyy-MM-dd format.
//inActiveDate = Wed Sep 26 00:00:00 IST 2012. ==> 2012-09-26. 
public class DateActions {

	public static void timeFormatterThis(String sPattern) { //"yyyy-MM-dd"
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(sPattern);
		String date = dateObj.format(formatter);
		System.out.println(date);
		// ===>2021-02-18
	}
	public static void convertToText(String sPattern) throws ParseException {
		// No point of parsing date and keep that as Date object.
		// format the calender date object when you want 
			// to display and keep that as a string.

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date date = cal.getTime();            
		SimpleDateFormat format1 = new SimpleDateFormat(sPattern);          
		String inActiveDate = null;

		inActiveDate = format1.format(date); 
		System.out.println(inActiveDate );
	}
}
