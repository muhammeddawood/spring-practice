package com.strings;

public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = String.format("%s after removed duplicates %s", "aaabbbccc", removeDuplicates("aaabbbccc".toCharArray()));
		System.out.println(str);

	}

	public static String removeDuplicates(char[] str) {
		if (str == null) return new String(str);
		int len = str.length;
		if (len < 2) return new String(str);

		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) { 
					System.out.println(str[i]);
					break;
				}
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		
		return new String(str);
	}

}
