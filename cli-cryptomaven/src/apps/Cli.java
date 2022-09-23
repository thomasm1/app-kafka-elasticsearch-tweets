package apps;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Cli {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("CLI CRYPTO MAVEN");
		staticStreaming();
		String Streaming = staticStreaming();
		System.out.println(Streaming);
		
		Finalizable f = new Finalizable();
		f.readFirstLine();  
		
		// NEW TIME
		DateActions.intervalTiming( "a b c a b abc cc cc a");
		// Time
		DateActions.timeFormatterThis("yyyy-MM-dd");
		// Time using Text
		try {
			DateActions.convertToText("yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Serializing
		SerializeTest.serialTest(1, "file.txt");
		
		// String
		StringActions s = new StringActions();
		String filename = "file.txt";
		s.stringCounts(filename);
		 
		// Streams
		String[] str = { "5.6", "7.4", "4", "1", "2.3"};
		StreamThis.staticStreamer(str);
		StreamThis.nullable(str);
		int[] ints = {1,2,3,4};
		StreamThis.reduceFilterInts(ints);
		
		// ENCODING
		SerializeTest.encodeThis("a");
		
		Scanner inputObj = new Scanner(System.in);
		System.out.println("Enter Input here - |");
			while(inputObj.hasNextLine()) {
				System.out.println("Enter Input here - |"); 
				String inputStr = inputObj.nextLine(); 
				boolean matched = RegEx.regExThis(inputStr);
				System.out.println("\""+inputStr+"\" input match: "+matched); 
			}
		inputObj.close(); 
		}
	 

	 private static String staticStreaming() {
		System.out.println("Streaming");
		String s = "Streaming returned";
		return s;
	}
}
