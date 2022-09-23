package apps;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static Boolean regExThis(String str) {

 
		Pattern pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("my name is thomas milton");
		boolean matchFound = matcher.find();
		if(matchFound) {
			System.out.println("match found");
		} else {
			System.out.println("match not found");
		}
		return matchFound; 
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
