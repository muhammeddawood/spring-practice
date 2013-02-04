package com.concept.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private Account a1 = new Account();
	private Account a2 = new Account();
	
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void increment() {
		for(int i = 0; i < 1000; i++) {
			count++;
		}
	}
	
	private void acquireLocks(Lock firstLock, Lock secondLock) {
		while(true) {
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			try {
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();			
			}
			finally {
				if(gotFirstLock && gotSecondLock) {
					return;
				}
				
				if(gotFirstLock) {
					firstLock.unlock();
				}
				
				if(gotSecondLock) {
					secondLock.unlock();
				}
			}
			
		}
	}
	
	public void firstThread() throws InterruptedException  {
		/*lock.lock();
		System.out.println("awaiting....");
		cond.await();
		System.out.println("woken up...");
		increment();
		
		lock.unlock();*/
		
		Random random = new Random();
		for(int i = 0; i < 1000; i++) {
			/*lock1.lock();
			lock2.lock();*/
			
			acquireLocks(lock1, lock2);
			Account.transfer(a1, a2, random.nextInt(100));
			lock1.unlock();
			lock2.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException {
		/*Thread.sleep(1000);
		lock.lock();
		
		System.out.println("press the return key");
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		System.out.println("got return key");
		cond.signal();
		increment();
		lock.unlock();*/
		
		Random random = new Random();
		for(int i = 0; i < 1000; i++) {
			/*lock1.lock();
			lock2.lock();*/
			acquireLocks(lock2, lock1);
			Account.transfer(a2, a1, random.nextInt(100));
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void finished() {
		//System.out.println("Count is : " + count);
		System.out.println("Account1 : " + a1.getBalance());
		System.out.println("Account2 : " + a2.getBalance());
	}
}
