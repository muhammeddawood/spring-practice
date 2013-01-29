package com.concept.producerconsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedInstance {
	private AtomicInteger i = new AtomicInteger(0);
	
	public void produce() {
		System.out.println("Produced : " + i.incrementAndGet());
	}
	
	public void consume() {
		System.out.println("Consumed : " + i.decrementAndGet());
	}
	
	public boolean isEmpty() {
		return i.get() == 0;
	}
}
