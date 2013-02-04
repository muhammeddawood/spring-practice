package com.concept.callablefuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<Integer> future = exec.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				System.out.println("Starting....");
				
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if(duration > 2000) {
					throw new IOException("Sleeping for too long...");
				}
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finished ...");
				
				return duration;
			}
			
		});
		
		exec.shutdown();
		
		System.out.println("Result is :" + future.get());
	}
}
