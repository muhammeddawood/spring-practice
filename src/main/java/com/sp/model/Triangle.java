package com.sp.model;

public class Triangle {
	private String type;
	private String height;
	
	public void draw() {
		System.out.println("Drawing Triangle");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

}
