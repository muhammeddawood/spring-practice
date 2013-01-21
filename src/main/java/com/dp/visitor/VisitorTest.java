package com.dp.visitor;


// visitor pattern allows to add virtual functions to a family of classes without modifying the classes themselves
// instead one creates a visitor class which implements all of the specializations of a virtual function
public class VisitorTest {
	
	// Double dispatch: 
	public static void main(String[] args) {
		Car car = new Car();
		car.accept(new CarDoVisitor());
		car.accept(new CarPrintVisitor());
	}
}
