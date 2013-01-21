package com.dp.bridge;

public abstract class Shape {
	private DrawingAPI drawingAPI;
	
	public Shape(DrawingAPI drawingAPI) {
		this.drawingAPI = drawingAPI; 
	}

	public DrawingAPI getDrawingAPI() {
		return drawingAPI;
	}

	public void setDrawingAPI(DrawingAPI drawingAPI) {
		this.drawingAPI = drawingAPI;
	}
	
	public abstract void draw();
	public abstract void resizeByPercentage(double percentage);
}
