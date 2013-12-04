package com.concept.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CDLTest {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch cdl = new CountDownLatch(5);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			executor.submit(new TestRunnable(cdl));
		}
		
		executor.shutdown();
		cdl.await();
	}
	
}

class TestRunnable implements Runnable {
	private CountDownLatch cdl;
	
	public TestRunnable(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getId() + " waiting ");
			cdl.countDown();
			System.out.println("Thread " + Thread.currentThread().getId() + " started ");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
}


