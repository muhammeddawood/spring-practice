package com.dp.state;

public class StateContext {
	private StateLike state;

	public void setState(StateLike state) {
		this.state = state;
	}
	
	public StateContext() {
		setState(new StateA());
	}
	
	public void write(String name) {
		state.write(this, name);
	}
}
