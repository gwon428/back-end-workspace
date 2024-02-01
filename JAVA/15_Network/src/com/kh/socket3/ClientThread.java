package com.kh.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientThread extends Thread {
	
	Socket socket;
	
	BufferedReader br;
	
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>()) ;
	
	public ClientThread(Socket socket) {
		this.socket = socket;
		
		
		try {
			// 클라이언트에서 서버로 [생성될 때마다 스트림 생성]
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 서버에서 클라이언트로 [생성될 때마다 스트림 생성]
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			list.add(pw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendAll(String message) {
		// 누군가 로그인하거나 메세지를 보낼 때마다 pw에 저장된 모든 Client의 화면에 출력될 수 있도록 데이터 전송
		for(PrintWriter pw : list) {
			pw.println(message);
			pw.flush();
		}
	}
	
	public void run() {
		try {
			String login = socket.getInetAddress() + "님이 접속하셨습니다.";
			System.out.println(login);
			sendAll(login);

			while (br != null) {

				String line = br.readLine();
				System.out.println("[" + socket.getInetAddress() + "] 가 보낸 메세지 : " + line);		// 서버에 출력
				sendAll("[" + socket.getInetAddress() + "] 가 보낸 메세지 : " + line);					// 클라이언트에 전송
				
			}
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + "님이 나가셨습니다..");
		}
		
	}
}
