package com.thread.exception;

public class Task implements Runnable {

	@Override
	public void run() {
		try {
			int numero=Integer.parseInt("TTT");
		} catch(NumberFormatException nfe) {
			System.out.println("eating exception...");
		}
		System.out.println("after exception...");
	}

}
