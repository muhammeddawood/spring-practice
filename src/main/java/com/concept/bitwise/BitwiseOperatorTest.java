package com.concept.bitwise;

public class BitwiseOperatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 8;
		System.out.println("Number: " + i + " in Binary : " + Integer.toBinaryString(i) + " : signed Left Shift : " + (i << 1));
		
		i = -8;
		System.out.println("Number: " + i + " in Binary : " + Integer.toBinaryString(i) + " : signed Right Shift : " + (i >> 1));
		i = 8;
		System.out.println("Number: " + i + " in Binary : " + Integer.toBinaryString(i) + " : signed Right Shift : " + (i >> 1));
		i = 8;
		System.out.println("Number: " + i + " in Binary : " + Integer.toBinaryString(i) + " : unsigned Right Shift : " + (i >>> 1));
		i = -8;
		System.out.println("Number: " + i + " in Binary : " + Integer.toBinaryString(i) + " : unsigned Right Shift : " + (i >>> 1));
	}

}
