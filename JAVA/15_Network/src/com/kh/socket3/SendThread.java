package com.kh.socket3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	
	Socket socket;
	Scanner sc = new Scanner(System.in);
	
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	
	// 스레드에서 실제 구현되는 메소드
	public void run() {
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			while(true) {
				ps.println(sc.nextLine());
				ps.flush(); 				// 보낼 때마다 마무리? (flush)
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
