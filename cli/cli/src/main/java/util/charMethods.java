package util;

public class charMethods {

	
	boolean permutationChars(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] letters = new int[128]; // ASCII here... who know Unicode
		for (int i=0;i<s.length();i++) {
			letters[s.charAt(i)]++;
			}
		for (int i=0;i<t.length();i++) {
			letters[t.charAt(i)]--;
			if(letters[t.charAt(i)]<0) {			// After going through 2nd time checking 
				return false;
			}
		}
		return true;
	}
}
