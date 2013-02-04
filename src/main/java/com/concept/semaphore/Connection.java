package com.concept.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance = new Connection();
	private int connections;
	private Semaphore sem = new Semaphore(10);
	
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		return instance;
	}
	
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized (this) {
			connections++;
			System.out.println("Current Connections : " + connections);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized(this) {
			connections--;
			
		}
		
		sem.release();
	}
}
