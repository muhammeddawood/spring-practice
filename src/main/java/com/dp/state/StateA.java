package com.dp.state;

public class StateA implements StateLike {

	@Override
	public void write(StateContext context, String name) {
		System.out.println(name.toLowerCase());
		context.setState(new StateB());
	}

}
