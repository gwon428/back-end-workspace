package com.kh.step4;

import javax.swing.JOptionPane;
/*	두 스레드 간의 Communication은 프로세스의 자원으로 해야한다.
 
 
 	프로세스 공간 : main 메서드가 속한 공간?
 	프로세스도 객체이기 때문에 다른 클래스에서 프로세스.를 매개변수로 담을 수 있는 생성자를 새로 만들고, this. () = ();에 프로세스로
 	-- 생성자 만들기 전에 클래스 내에서 지정한 변수.(프로세스)에 프로세스를 담아내기!--
 */
public class InputThreadTest3 {
	// 공유 자원 활용 가능. => 스레드끼리 Communication 가능

	// 공유하는 자원 (모든 클래스가 공유하기 위해 (프로세스)에 선언)
	boolean check = false;
	
	
	public static void main(String[] args) {
		
		// process 객체를 생성!
		InputThreadTest3 process = new InputThreadTest3();
		
		// process를 매개변수로 받는 스레드 생성?
		InThread3 in = new InThread3(process);
		in.start();

		// process 를 매개변수로 받는 스레드 생성?
		CountThread3 count = new CountThread3(process);
		count.start();

	}

}

class InThread3 extends Thread {
	
	// 클래스 내에서 지정한 변수에 프로세스 담아내기
	InputThreadTest3 process;
	
	// 프로세스를 담을 수 있는 생성자 만들기
	public InThread3(InputThreadTest3 process) {
		this.process = process;
	}

	public void run() {
		// 1. 데이터 입력 작업
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요..");
		System.out.println("입력하신 숫자는 " + input + "입니다.");
		
		process.check = true; // 입력하는 순간 true로 변경하겠다는 구문
	}

}

class CountThread3 extends Thread{
	
	InputThreadTest3 process;
	
	public CountThread3(InputThreadTest3 process) {
		this.process = process;
	}
	
	public void run() {
		// 2. 카운팅 작업
		for (int i = 10; i > 0; i--) {
			if(process.check) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		if(!process.check) {
			System.out.println("10초 경과! 값 입력 금지");
			System.exit(0);			// 강제 종료.
		}
	}
}