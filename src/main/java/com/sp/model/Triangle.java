package com.sp.model;

import javax.annotation.Resource;

public class Triangle implements Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public void draw() {
		System.out.println("Drawing Triangle");
	}

	public Point getPointA() {
		return pointA;
	}

	@Resource
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
}
