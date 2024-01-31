package com.kh.step6;

// MegaBox에서 좌석을 예매하는 일을 전담하는 스레드라고 간주
public class MegaBoxUser implements Runnable {
	
	// 이 클래스 내에서만 쓸 변수
	private boolean seat = false; 	// 좌석 예매가 끝나면 true
	
	@Override
	public /*synchronized : 다른 기능이 올 수도 있기 때문에*/ void run() {

		try {
			reserve();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public synchronized void reserve() throws InterruptedException {
		// 예매 기능을 따로 뺌
		String name = Thread.currentThread().getName();		// 스레드를 지정한 순간에 만든 이름
		System.out.println(name + "님, 예매하러 오셨습니다.");
		
		if (seat == false) {
			Thread.sleep(2000);
			System.out.println(name + "님, 좌석 예매 성공하셨습니다.");
			seat = true;
		} else {
			System.out.println(name + "님, 해당 좌석은 이미 선택된 좌석입니다.");
		}
	}
	
}
