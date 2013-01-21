package com.dp.visitor;

public interface CarElementVisitor {
	void visit(Wheel wheel);
	void visit(Car car);
	void visit(Engine engine);
	void visit(Body body);
	
}
