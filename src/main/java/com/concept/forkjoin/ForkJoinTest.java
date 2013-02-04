package com.concept.forkjoin;

import java.util.concurrent.ForkJoinPool;

import org.springframework.util.StopWatch;

public class ForkJoinTest {
	public static void main(String[] args) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		
		System.out.println("Available Processors : " + availableProcessors);
		FibonacciProblem fp = new FibonacciProblem(40);
		FibonacciTask ft = new FibonacciTask(fp);
		
		
		ForkJoinPool fjp = new ForkJoinPool(availableProcessors);
		StopWatch sw = new StopWatch();
		sw.start();
		fjp.invoke(ft);
		sw.stop();
		
		System.out.println("Result : " + ft.getResult());
		System.out.println("RawResult : " + ft.getRawResult());
		System.out.println("ElapsedTime : " + sw.getTotalTimeMillis());
		
	}

}
