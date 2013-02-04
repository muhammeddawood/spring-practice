package com.concept.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// countdownlatch lets u one or more thread wait till it reaches a count down 0
public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService exec = Executors.newFixedThreadPool(3);
		
		for(int i =0; i <3; i++) {
			exec.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed");
		exec.shutdown();
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Processor implements Runnable {
	private CountDownLatch latch;
	
	public Processor(CountDownLatch cdl) {
		this.latch = cdl;
	}

	@Override
	public void run() {
		System.out.println("Started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
		
	}
	
}