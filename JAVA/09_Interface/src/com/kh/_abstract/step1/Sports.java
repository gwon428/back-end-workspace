package com.kh._abstract.step1;

public abstract class Sports {
	
	protected int numberOfPlayers;	// 참여하는 사람의 수
	
	public Sports (int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	// 추상 메서드 -> 자식 클래스에서 무조건 재정의 해주어야 한다!
	public abstract void rule();	// abstract 메서드를 생성하면 클래스도 abstract로 만들어줘야 함.
	// 부모에서는 정의하지 않고, 자식 개체에서 재정의하도록 강제성을 부여함. (재정의하지 않을 때 오류가 나도록)
	
}
