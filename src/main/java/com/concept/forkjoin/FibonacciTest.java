package com.concept.forkjoin;

import org.springframework.util.StopWatch;

public class FibonacciTest {

	public static void main(String[] args) {

		FibonacciProblem fp = new FibonacciProblem(40);
		StopWatch sw = new StopWatch();
		sw.start();
		long solve = fp.solve();
		sw.stop();
		System.out.println( "Milliseconds : " +sw.getTotalTimeMillis());
		System.out.println( "Fibonnaci answer : " +solve);
	}
}
 