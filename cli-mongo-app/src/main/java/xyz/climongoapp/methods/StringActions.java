package xyz.climongoapp.methods;

import java.io.*;
import java.util.Scanner;

public class StringActions {
	
	public  void stringCounts(String filename) throws IOException {
 
	 
		File file = new File(filename); 
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader  = new InputStreamReader(fileInputStream);
		try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
			String line;
			int wordCount = 0;
			int characterCount = 0;
			int paraCount = 0;
			int whiteSpaceCount = 0;
			int sentenceCount = 0;
			
			while((line = bufferedReader.readLine()) != null){
				if (line.equals("")) {
					paraCount+=1;
				}
				else {
					characterCount += line.length();
					String[] words = line.split("\\s+");
					wordCount += words.length;
					whiteSpaceCount += wordCount -1;
					String sentence[] = line.split("[!?.:]+");
					sentenceCount += sentence.length;
				}
			}
			if(sentenceCount >= 1) {
				paraCount++;
			}
			System.out.println("word count = "+ wordCount);
			System.out.println("number of sentences = "+ sentenceCount);
			System.out.println("number of characters = "+ characterCount);
			System.out.println("paragraphs = "+ paraCount);
			System.out.println("number of whitespaces = "+ whiteSpaceCount);
		}
	 

		File fileScan = new File(filename); 
		Scanner scannedFile = new Scanner(fileScan );  
		while(scannedFile.hasNextLine()) {
			String scanned = scannedFile.nextLine();
			System.out.println(scanned);
		}
		scannedFile.close();
		 
	}
}
		
		
		