package com.concept.threadlocal;

public class ThreadLocalTest extends Thread {
	
	public static void main(String[] args) {
		ThreadLocalTest t1 = new ThreadLocalTest();
		ThreadLocalTest t2 = new ThreadLocalTest();
		
		t1.start();
		t2.start();
	}
	
	public void run() {
		MyThreadLocal.set(new Context(getName()));
		
		BusinessDelegate bd = new BusinessDelegate();
		bd.doBusiness();
		
		MyThreadLocal.unset();
	}

}
