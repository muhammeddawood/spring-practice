package com.concept.forkjoin;

public class FibonacciProblem {
	private int n;
	
	public FibonacciProblem(int n) {
		this.n = n;
	}
	
	public long solve() {
		return fibonacci(n);
	}

	private long fibonacci(int n2) {
		//System.out.println("Calculates " + n2);
		if(n2 <= 1) {
			return n2;
		}
		
		long l = fibonacci(n2 - 1) + fibonacci(n2 - 2);
		//System.out.println("fibonacci for " + n2 + " : " + l);
		return l;
	}

	public int getN() {
		return n;
	}

}
