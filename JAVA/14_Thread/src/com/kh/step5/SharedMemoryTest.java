package com.kh.step5;

// 스레드들은 공유자원을 서로 공유한다.
public class SharedMemoryTest {

	// 모든 스레드가 공유할 수 있는 공유자원을 선언하는 위치 or 클래스를 새로 만들 수 있음.
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		 // 클래스에 값을 넘길 때 생성자 or setter를 통해 넣을 수 있음.
		
		User1 user1 = new User1();
		user1.setCalculator(calc);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calc);
		user2.start();
		
		// 동기화 처리 : 동시에 들어왔을 때 처리할 순서를 정리하는 것
		
		
	}

}
