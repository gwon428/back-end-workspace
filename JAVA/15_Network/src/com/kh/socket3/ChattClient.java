package com.kh.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChattClient {

	public static void main(String[] args) {

		try {
			// Socket에는 IP주소, port 번호
			Socket socket = new Socket("192.168.10.51", 3000);
			System.out.println("서버와 연결되었습니다.");
			
			Thread sendThread = new SendThread(socket);
			sendThread.start();
			
			// 서버 측에서 보내는 내용
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 바로 읽어서 보낸다
			while(br != null) {
				System.out.println(br.readLine());
			}
			
		} catch (IOException e) {
			System.out.println("서버 종료.");
		}
	
	
	
	
	}

}
