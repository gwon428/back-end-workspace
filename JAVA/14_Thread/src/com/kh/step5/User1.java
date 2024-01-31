package com.kh.step5;

public class User1 extends Thread {
	
	// 여기에서만 쓸 변수를 지정
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		setName("CalculatorUser1");
		this.calculator = calculator;
	}
	
	public void run() {
		// calculator가 공유자원인데, 이 공유 자원의 memory를 100.으로 세팅하려고 함.
		calculator.setMemory(100);
	}
}
