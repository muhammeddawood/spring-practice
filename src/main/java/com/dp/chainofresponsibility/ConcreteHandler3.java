package com.dp.chainofresponsibility;

public class ConcreteHandler3 extends Handler{

	@Override
	public void hanleRequest(Request request) {
		
		if(request.getValue() < 0) {
			System.out.println("Negative values are handled by handler3 " + request.getValue()
					+ " description : " + request.getDescription());
		}
		else {
			super.getSuccessor().hanleRequest(request);
		}
		
	}

}
