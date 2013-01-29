package com.concept.threadlocal;

public class Context {
	private String transactionId;

	public Context() {
		
	}
	
	public Context(String transid) {
		this.transactionId = transid;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
}
