package com.dp.chainofresponsibility;

public class ConcreteHandler2 extends Handler {

	@Override
	public void hanleRequest(Request request) {

		if(request.getValue() == 0) {
			System.out.println("Zero values are handled by handler2 " + request.getValue()
					+ " description : " + request.getDescription());
		}
		else {
			super.getSuccessor().hanleRequest(request);
		}
	}

}
