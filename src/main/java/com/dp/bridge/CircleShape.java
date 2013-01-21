package com.dp.bridge;

public class CircleShape extends Shape {
	private double x, y, radius;
	
	public CircleShape(DrawingAPI drawingAPI) {
		super(drawingAPI);
	}

	@Override
	public void draw() {
		getDrawingAPI().draw(x, y, radius);

	}

	@Override
	public void resizeByPercentage(double percentage) {
		radius *= percentage;

	}

}
