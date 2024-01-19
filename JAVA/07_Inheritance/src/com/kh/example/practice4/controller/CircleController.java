package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	// 받은 매개변수를 통해 필드 초기화 -> 정보와 면적 반환
	public String calcArea(int x, int y, int radius) {
		// 면적 : PI * 반지름 * 반지름
		
		// set을 하지 않아도 나오기는 함 .. (?
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c + "넓이 : " + (Math.PI * radius * radius);
	}
	
	// 받은 매개변수를 통해 필드 초기화 => 정보와 둘레 반환
	public String calcCircum(int x, int y, int radius) {
		// 둘레 : PI * 반지름 * 2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c + "둘레 : " + (Math.PI * radius * 2);
	}
}
