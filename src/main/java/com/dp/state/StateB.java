package com.dp.state;

public class StateB implements StateLike {
	private int count = 0;

	@Override
	public void write(StateContext context, String name) {
		System.out.println(name.toUpperCase());
		
		if(++count > 1) {
			context.setState(new StateA());
		}
	}
	
}
