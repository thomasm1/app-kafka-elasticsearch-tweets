package com.doggywood.utilities;
 
import java.time.temporal.Temporal;
import java.util.*;

import jakarta.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.doggywood.services.CustomerService;


public class StringService {

	public String fullName(String first, String last) {
		return  first+" "+last;
	}

	public String reverse(String string) {
			StringBuilder sb = new StringBuilder(string);
			return sb.reverse().toString();
	}

	public String acronym(String phrase) {
		String[] sarr = phrase.split(" |-");
		StringBuilder acr = new StringBuilder("");
		for (String s: sarr) {
			acr.append(String.valueOf(s.charAt(0)));
		}
		return acr.toString().toUpperCase();
	}

	public String[] cleanPhoneNumber(String string) {
	int leftParen = string.indexOf('(');
	String countryCode = string.substring(0,leftParen).trim();
	String nineDigits = string.substring(leftParen).trim();
	nineDigits = nineDigits.replaceAll("[^0-9]","");
		return new String[] {countryCode,nineDigits};
	}
	public Boolean isValidPhoneNumber(String string) {
		boolean ok = false;
		if(string.matches("\\d{9}|\\d{10}")) ok = true;
		return ok;
	}
	public boolean isValidEmail(String str) {
		return false;
	}

	public boolean isValidIsbn(String string) {
		String newStr = string.replace("-", "");
		String newStr1 = newStr.replace("X", "10");
		String[] strArr = newStr1.split("");
		int[] intArr= new int[10];
		int x = 10;
		try {
			for (int i = 0; i<10;i++) {
			intArr[i] =	Integer.parseInt(strArr[i]) * x;
			x--;
			}
			int answer = 0;
			for(int i : intArr) {
				answer+=i;
			}
			if (!(answer % 11 == 0)) {
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


}
