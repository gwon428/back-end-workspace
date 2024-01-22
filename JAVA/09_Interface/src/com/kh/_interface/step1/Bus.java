package com.kh._interface.step1;

public class Bus implements Vehicle {

	// 강제로 재정의
	@Override
	public void run() {
		checkFare();
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare() {
		System.out.println("승차요금을 체크합니다.");
	}

	@Override
	public void turn() {
		System.out.println("버스가 돕니다.");
	}
	
}
