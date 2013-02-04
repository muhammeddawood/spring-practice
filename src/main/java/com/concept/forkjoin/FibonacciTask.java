package com.concept.forkjoin;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
	private static final long serialVersionUID = -1231946249563397001L;
	
	private FibonacciProblem fp;
	private final static int THRESHOLD = 5;
	private Long result;
	
	public FibonacciTask(FibonacciProblem fp) {
		this.fp = fp;
	}

	@Override
	protected Long compute() {
		
		if(fp.getN() < THRESHOLD)  {
			result = fp.solve();
		}
		else {
			FibonacciTask worker1 = new FibonacciTask(new FibonacciProblem(fp.getN() - 1));
			FibonacciTask worker2 = new FibonacciTask(new FibonacciProblem(fp.getN() - 2));
			worker1.fork();
			result = worker2.compute() + worker1.join();
		}
		
		return result;
	}

	public Long getResult() {
		return result;
	}

}
