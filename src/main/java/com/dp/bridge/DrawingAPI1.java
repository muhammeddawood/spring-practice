package com.dp.bridge;

public class DrawingAPI1 implements DrawingAPI {

	@Override
	public void draw(double x, double y, double r) {
		System.out.printf("API1.draw circle %f:%f radius %f\n", x, y, r);
	}


}
