package com.kh._abstract.step1;

public class BasketBall extends Sports{
	
	public BasketBall (int numberOfPlayers) {
		super(numberOfPlayers);
	}
	
	public void rule() {
		System.out.println("BasketBall의 선수의 수는 " + this.numberOfPlayers + "명, 공을 던져서 링에 넣어야 한다.");
							// this. 로 접근하기 위해서는 protected로 (protected : 자식 객체까지 접근 허용) [사실 this 를 생략해도 사용이 가능하긴 함.]
	}
	
	
	
}
