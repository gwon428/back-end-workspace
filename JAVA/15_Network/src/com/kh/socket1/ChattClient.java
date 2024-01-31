package com.kh.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ChattClient {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			//**
			//2
			// 1. [Socket 생성] - IP 주소, port 번호
			Socket s = new Socket(ip.getHostAddress(), 60000);
			System.out.println("Client Socket Creating...");
			//**
			//4
			// 2. [Stream] -> 메시지 전송
			// 콘솔창에 입력한 걸 읽어와서 BufferedReader로 담은 것임. (키보드로 입력한 것을 읽어들이는 코드)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);	// true -> 누적해서 쓰기
			
			System.out.println("Client stream Creating..");
			
			String line = "";
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
			
		} catch(Exception e) {
			System.out.println("Server와의 연결에 실패했습니다..");
		}
	}
}
