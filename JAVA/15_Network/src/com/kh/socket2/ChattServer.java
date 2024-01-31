package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트가 보낸 메시지를 받아서 다시 클라이언트에게 받은 메시지를 보내는 로직

/*	서버측 로직
 	1. ServerSocket 생성 - port : 60000
 	2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
 	3. 소켓으로부터 스트림 리턴
 	4. 
 
 */
public class ChattServer {

	public static void main(String[] args) {

		try {
			// 1. Server Socket 생성 port : 60000
			ServerSocket server = new ServerSocket(60000);
			
			// 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
			Socket s = server.accept();
			System.out.println(s.getInetAddress() + "님이 접속하셨습니다..");
			
			// 3. 소켓으로부터 스트림 리턴
			// BufferedReader, InputStreamReader <- s.getInputStream
			// 클라이언트가 보낸 메시지를 받아서
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// PrintWriter <- s.getOutputStream
			// 다시 클라이언트에게 받은 메시지를 보낸다.
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println("[" + s.getInetAddress() + "]가 보낸 메세지 : " + line);
				
				// 4. 받은 메시지를 클라이언트에게 전송
				pw.println(line);
			}

		} catch (Exception e) {
			System.out.println("Client와의 연결이 끊어졌습니다.");
		}
	}

}
