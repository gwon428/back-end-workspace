package com.kh.step2;

public class GoThread implements Runnable {

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
