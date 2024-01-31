package com.kh.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

	// 클라이언트가 보낸 메시지를 받아서 콘솔창에 받은 메세지를 출력
	
	public static void main(String[] args) {
		
		try {
			//**
			//1
			// 1. [ServerSocket 생성 - port:60000] Socket 연결을 하려면 ServerSocket이 있어야 함.
			ServerSocket server = new ServerSocket(60000);		// 포트번호는 서버를 생성하는 순간 담아야 함.
			System.out.println("Server Ready.........");
			//**
			
			//3, 5(전송한 메시지를 받은 것.)
			// 2. Client가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
			Socket s = server.accept();
			System.out.println("Client Socket... Returning");
			
			//5
			// 3. Socket으로부터 Stream 리턴
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println("Client가 보낸 메시지 : " + line);
			}
		} catch(Exception e) {
			System.out.println("Client와의 연결이 끊어졌습니다..");
		}
	}
}
