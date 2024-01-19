package com.kh.example.practice4.model;

public class Circle extends Point {
	private int radius;

	public Circle() {
	}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
		
		// 이걸 하지 않으면 toString()에 super.getX(), super.getY()의 형태로 문장을 새로 재정의
		super.setX(x);
		super.setY(y);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + "반지름 : " + radius + " / ";
	}
	
	
}
