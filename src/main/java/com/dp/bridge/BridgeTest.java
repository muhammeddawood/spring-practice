package com.dp.bridge;

public class BridgeTest {

	/**
	 * decouple abstraction from implementation so that both can vary independently
	 * @param args
	 */
	public static void main(String[] args) {
		DrawingAPI drawingAPI = new DrawingAPI1();
		Shape shape = new CircleShape(drawingAPI);
		shape.resizeByPercentage(10);
		shape.draw();

	}

}
