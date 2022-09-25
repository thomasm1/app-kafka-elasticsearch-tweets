package apps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		DateActions.intervalTiming("a b c a b abc cc cc a");
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
		String[] str = { "5.6", "7.4", "4", "1", "2.3" };
		StreamThis.staticStreamer(str);
		StreamThis.nullable(str);
		int[] ints = { 1, 2, 3, 4 };
		StreamThis.reduceFilterInts(ints);

		// ENCODING
		SerializeTest.encodeThis("a");

		// BufferedReader(InputStreamReader)
		String data;
		try(BufferedReader inputManual = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
			while ((data = inputManual.readLine()) !=null && !data.equals("start")) {
				System.out.println("\"...did not enter \"start\". Enter Start: ");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("BufferedReader(InputStreamReader(System.in)  - Continue"); 
		// SCANNER  -- 
		String data2;
		Scanner inputScan = new Scanner(System.in);
		System.out.println("\nEnter \"Start\" :");
		while (!(data2 = inputScan.nextLine()).equals("start")) {
			System.out.println("\"...did not enter \"start\". Enter Start: ");
		}
		;
		System.out.println("Scanner(System.in)  continue");
		System.out.println("Enter start code: ");
		int code = inputScan.nextInt();
		System.out.println("Thanks. You entered " + code);
		while (inputScan.hasNextLine()) {
			System.out.println("Enter Input here ::");
			String inputStr = inputScan.nextLine();
			boolean matched = RegEx.regExThis(inputStr);
			System.out.println("\"" + inputStr + "\" input match: " + matched);
		}
		inputScan.close();
	}

	private static String staticStreaming() {
		System.out.println("Streaming");
		String s = "Streaming returned";
		return s;
	}
}
