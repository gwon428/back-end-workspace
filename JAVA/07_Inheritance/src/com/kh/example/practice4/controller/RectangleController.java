package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Rectangle;

public class RectangleController {

	private Rectangle r = new Rectangle();
	
	// 받은 매개변수를 통해 필드 초기화 -> 정보와 면적 반환
	public String calcArea(int x, int y, int height, int width) {
		// 면적 : 너비 * 높이
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r + "넓이 : " + (height * width);
	}
	
	// 받은 매개변수를 통해 필드 초기화 => 정보와 둘레 반환
	public String calcPerimeter(int x, int y, int height, int width) {
		// 둘레 : 2 * (너비 + 높이)
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r + "둘레 : " + (2 * (height + width));
	}
}
