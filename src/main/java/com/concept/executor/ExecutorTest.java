package com.concept.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 10; i++) {
			executor.submit(new WorkerThread(i));
		}
		
		executor.shutdown();
		
	}
}

class WorkerThread implements Runnable {
	int id ;

	public WorkerThread(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " In Worker Thread " + id );
		process();
		System.out.println(Thread.currentThread().getName() + " Out of Worker Thread " + id);
	}

	private void process() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class MyRejectedExecutionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString() + " is Rejected ");
		
	}
	
}