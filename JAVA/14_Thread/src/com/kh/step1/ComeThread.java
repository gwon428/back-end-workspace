package com.kh.step1;

/*	스레드 생성하는 방법
 	1. Thread 클래스를 상속받는 방법
 		- Thread 클래스를 상속 후에 run() 메서드를 오버라이딩
 		- Thread 클래스를 상속한 자식 클래스의 객체 생성 후 start() 메서드를 호출한다
 */
public class ComeThread extends Thread {
	
	public ComeThread(String name) {
		super(name);
	}
	
	// run() : 스레드가 작동하는 부분
	public void run() {
		for(int i=0; i<20; i++) {
			try {
					// sleep() : 지정된 시간동안 스레드를 멈추게 한다
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println("CurrentThread :: " + name + ", " + i);
		}
	}
}
