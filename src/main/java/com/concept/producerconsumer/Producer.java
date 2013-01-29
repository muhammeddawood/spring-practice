package com.concept.producerconsumer;

public class Producer implements Runnable{
	private SharedInstance si;

	public Producer(SharedInstance si) {
		this.si = si;
	}

	@Override
	public void run() {

		for(int i = 0; i < 10;) {
			synchronized (si) {
				if(si.isEmpty()) {
					si.produce();
					i++;
					si.notifyAll();
				}
				else {
					try {
						si.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(i);
		}
	}
}
