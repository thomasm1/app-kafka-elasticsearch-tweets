package apps;

import java.io.IOException;
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
		
		StringActions s = new StringActions();
		String filename = "C:\\Users\\thoma\\eclipse-workspace\\cli-cryptomaven\\src\\file.txt";
		s.stringCounts(filename);
		 
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
