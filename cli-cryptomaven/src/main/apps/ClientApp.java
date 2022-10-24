package main.apps;

import main.apps.files.SerializeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;

public class ClientApp {

	public static void clientApp(String[] args) throws IOException {

		// NEW TIME
		DateSingleton.intervalTiming("a b c a b abc cc cc a");
		// Time
		DateSingleton.timeFormatterThis("yyyy-MM-dd");
		// Time using Text
		try {
			DateSingleton.convertToText("yyyy-MM-dd");
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		// Serializing
		SerializeTest.serialTest(1, "file.txt");
//
//		// String
		StringActions s = new StringActions();
		String filename = "file.txt";
		s.stringCounts(filename);
//
//		// Streams
		String[] str = { "5.6", "7.4", "4", "1", "2.3" }; 
		StreamThis.staticStreaming(str);

		StreamThis.nullable(str);
		int[] ints = { 1, 2, 3, 4 };
		StreamThis.reduceFilterInts(ints);
//
//		// ENCODING
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
 // SCANNER
		Scanner inputScan = new Scanner(System.in);
 
		System.out.println("Scanner(System.in)  continue");
		System.out.println("Enter start code: ");
		while (inputScan.hasNextLine()) {
			System.out.println( " Enter Input here ::");
			String inputStr = inputScan.nextLine(); 
		}
		inputScan.close();
	}

	
}
