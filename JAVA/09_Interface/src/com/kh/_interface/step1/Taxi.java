package com.kh._interface.step1;

public class Taxi implements Vehicle{

	// 강제로 재정의하도록 하는 interface를 구현했기 때문
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}

	@Override
	public void turn() {
		System.out.println("택시가 돕니다.");
	}
	
}
