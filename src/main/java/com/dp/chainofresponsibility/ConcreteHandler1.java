package com.dp.chainofresponsibility;

public class ConcreteHandler1 extends Handler {

	@Override
	public void hanleRequest(Request request) {
		
		if(request.getValue() > 0) {
			System.out.println("Positive values are handled by handler1 " + request.getValue()
					+ " description : " + request.getDescription());
		}
		else {
			super.getSuccessor().hanleRequest(request);
		}

	}

}
