package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	private Snack s = new Snack();	// Controller에서만 사용할 Snack 객체 생성
	
	// 저장 기능
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		
		System.out.println("서버 시작!");
		// 클라이언트에서 서버에 전달한 것을 확인
		System.out.println(kind + ", " + name + ", " + flavor + ", " + numOf + ", " + price);
		
		// setter를 이용해 저장
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		// 저장 완료되었다는 결과를 클라이언트에게 반환
		return "저장 완료되었습니다.";
	}
	
	// 저장한 데이터 반환
	public String confirmData() {
		return s.getKind() + "(" + s.getName() + " - " + s.getFlavor() + ")" + s.getNumOf() + " 개 " + s.getPrice() + "원";
	}
}
