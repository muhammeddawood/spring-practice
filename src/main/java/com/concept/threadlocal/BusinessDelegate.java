package com.concept.threadlocal;

public class BusinessDelegate {

	public void doBusiness() {
		System.out.println(MyThreadLocal.get().getTransactionId());
	}
}
