package com.strings;

public class UniqueCharacters {

	public static void main(String[] args) {
		
		System.out.println("Has Unique char 'salma' : " + hasUniqueCharacters("salma"));
		System.out.println("Has Unique char 'sami' : " + hasUniqueCharacters("sami"));

	}
	
	public static boolean hasUniqueCharacters(String str) {
		char[] charArray = str.toCharArray();
		
		boolean[] boolArr = new boolean[256];
		
		for(char c : charArray) {
			
			if(boolArr[c]) {
				return false;
			}
			
			boolArr[c] = true;
		}
		
		return true;
	}

}
