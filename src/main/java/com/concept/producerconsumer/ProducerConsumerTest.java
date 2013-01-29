package com.concept.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		SharedInstance si = new SharedInstance();
		Producer p = new Producer(si);
		
		Consumer c = new Consumer(si);
		
		//Thread t1 = new Thread(p);
		//Thread t2 = new Thread(c);
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		pool.execute(p);
		pool.execute(c);
		
		pool.shutdown();
		//t1.start();
		//t2.start();
	}
}
