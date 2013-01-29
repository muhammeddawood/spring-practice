package com.concept.precision;

import java.math.BigDecimal;

public class Rounding {
	public static void main(String[] args) {
		double dArr[] = new double[] {
				0.1,
				0.2,
				-0.3,
				0.1 + 0.2 -0.3
		};
		
		for(double d : dArr) {
			System.out.println(d + " ===> " + new BigDecimal(d));
		}
		
		System.out.println("-----------------------------------");
		
		for(double d : dArr) {
			System.out.println(d + " to two places " + roundToTwoPlaces1(d) + " => " + new BigDecimal(roundToTwoPlaces1(d)));
		}
	}

	// uses round half up, or bankers' rounding

	public static double roundToTwoPlaces1(double d) {
	    return Math.round(d * 100) / 100.0;
	}

	// OR

	public static double roundToTwoPlaces2(double d) {
	    return ((long) (d < 0 ? d * 100 - 0.5 : d * 100 + 0.5)) / 100.0;
	}

}
