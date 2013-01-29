package com.concept.producerconsumer;

public class Consumer implements Runnable {
	private SharedInstance si;

	public Consumer(SharedInstance si) {
		this.si = si;
	}

	@Override
	public void run() {

		for(int i = 0; i < 10; i++) {
			synchronized (si){
				if(si.isEmpty()) {
					try {
						si.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				si.consume();
				si.notifyAll();
			}
		}
	}
}
