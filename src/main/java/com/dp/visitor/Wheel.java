package com.dp.visitor;

public class Wheel implements CarElement { 
	private String name;
	
	public Wheel(String name) {
		this.name = name;
	}

	@Override
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
