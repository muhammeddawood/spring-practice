package com.concept.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(0);
		sem.release();
		sem.acquire();
		
		System.out.println("Available permits :" + sem.availablePermits());
		
		//Connection conn = Connection.getInstance();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
					
				}
			});
		}
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
