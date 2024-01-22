package com.kh._interface.step1;

public interface Vehicle {
	
//	void run() {};	// 오류. => 인터페이스는 추상 메서드만 올 수 있기 때문에 구현부가 없어야 함.
	void run();	// 
	
	void turn();
}
