package com.dp.visitor;

public class Car implements CarElement {
	private CarElement[] elements;
	
	public Car() {
		elements = new CarElement[] {new Body(), new Wheel("Front Left Wheel"), new Wheel("Front Right Wheel"),
				new Wheel("Back Left Wheel"), new Wheel("Back Right Wheel"), new Engine()};
	}
	
	@Override
	public void accept(CarElementVisitor visitor) {
		for(CarElement element : elements ) {
			element.accept(visitor);
		}
		visitor.visit(this);
	}
}