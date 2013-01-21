package com.dp.state;

// state pattern resembles strategy pattern
public class StateTest {

	public static void main(String[] args) {
		StateContext context = new StateContext();
		context.write("Sunday");
		context.write("Monday");
		context.write("Tuesday");
		context.write("Wednesday");
		context.write("Thursday");
		context.write("Friday");
		context.write("Saturday");
	}
}
