package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 공장 기계 역할! (틀)
public interface Controller {
	// 인터페이스에서는 상수와 추상 메서드만 올 수 있음.
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
