package com.dp.chainofresponsibility;

public abstract class Handler {
	private Handler successor;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	public abstract void hanleRequest(Request request);

	public Handler getSuccessor() {
		return successor;
	}
}
