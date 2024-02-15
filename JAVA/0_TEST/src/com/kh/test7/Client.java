package com.kh.test7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			Socket s = new Socket(ip, 3000);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
