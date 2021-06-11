package com.simplilearn.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	public boolean getSpecialCharacterCount(String s) {
	     if (s == null || s.trim().isEmpty()) {
	         System.out.println("Incorrect format of string");
	         return false;
	     }
	     Pattern p = Pattern.compile("[^A-Za-z0-9]");
	     Matcher m = p.matcher(s);
	    // boolean b = m.matches();
	     boolean b = m.find();
	     if(b) 
	    	 return true;
	    return false; 
	 }
	//test
	public static void main(String[] s) {
		Utility b = new Utility();
		boolean a = b.getSpecialCharacterCount("TheLordisGood");
		if(a)
			System.out.println("It contains special characters");
		else
			System.out.println("It doesn't contain special characters");
		
	}

}
