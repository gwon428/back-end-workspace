package com.kh.controller;

import com.kh.controller.component.AllShowController;
import com.kh.controller.component.FindMemberController;
import com.kh.controller.component.LoginController;
import com.kh.controller.component.LogoutController;
import com.kh.controller.component.RegisterController;

// Controller의 공장 역할!
public class HandlerMapping {

	// 싱글톤 패턴 [캡슐화를 통한 정보 은닉] : 생성자의 제어 접근자를 private으로 생성 => 객체 생성을 막아버림.
	// 싱글톤 패턴 : 특정 클래스의 객체가 오직 한 개만 존재하도록 하기 위해서
	
	// [싱글톤 패턴] 여기에서만 딱 한 번, 객체 생성을 할 수 있음.
	private static HandlerMapping handler = new HandlerMapping();
	
	private HandlerMapping() {}
	
	// getter를 getInstance로 사용하고, handler를 return 해서 접근
	public static HandlerMapping getInstance() {
		return handler;
	}

	// controller 생성
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if (command.equals("login.do")) {
			controller = new LoginController();
		} else if (command.equals("search.do")) {
			controller = new FindMemberController();
		} else if (command.equals("allshow.do")){
			controller = new AllShowController();
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
		}
		return controller;
		
	}
	
}
