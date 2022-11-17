package xyz.climongoapp.methods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegEx {
	static String users = "src/data/files/fileInUsers.txt";
	public static void main(String[] args) throws IOException {
		StringActions s = new StringActions();
		s.stringCounts(users);
		regExPattMatch("food", "foodSALAD");

		String[] wrong = {"[AZ[a-z](a-z)", "", "^(\\d{3}[- .]?){2}\\d{4}$"};
		String[] right = {   "^(\\d{3}[- .]?){2}\\d{4}$"};

		System.out.println("checkValid(): "+ checkValid(wrong));
		System.out.println("checkValid(): "+ checkValid(right));
	}
	public static Boolean regExPattMatch(String strPattern, String findMatch) {
		Pattern patt = Pattern.compile(strPattern);
		Matcher match = patt.matcher(findMatch);
		System.out.println("first test: "+match.find());

		Pattern pattern = Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(findMatch);
		boolean matchFound = matcher.find();
		if(matchFound) {
			System.out.println("match found");
		} else {
			System.out.println("match not found");
		}
		return matchFound; 
	}
	public static Boolean checkValid(String[] uncertainStrArr){

		for(int i = 0;i<uncertainStrArr.length;i++){
			String pattern = uncertainStrArr[i];
			if(pattern != null && !pattern.equals("")){
				try{
					Pattern.compile(pattern);
					System.out.println("Valid");
				}catch(PatternSyntaxException e){
					System.out.println("Invalid");
					return false;
				}
			}
		}
		return true;
	}
}
//Pattern.UNICODE_CASE - 
//Use with the CASE_INSENSITIVE to also ignore case of letters outside of the English alphabet

// [abc]	Find one character from the options between the brackets
// [^abc]	Find one character NOT between the brackets
// [0-9]	Find one character from the range 0 to 9

// n{x}	Matches any string that contains a sequence of X n's
// n{x,y}	Matches any string that contains a sequence of X to Y n's
// n{x,}	Matches any string that contains a sequence of at least X n's

// |	Find a match for any one of the patterns separated by | as in: cat|dog|fish
// .	Find just one instance of any character
// ^	Finds a match as the beginning of a string as in: ^Hello
// $	Finds a match at the end of the string as in: World$
// \d	Find a digit
// \s	Find a whitespace character
// \b	Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b
