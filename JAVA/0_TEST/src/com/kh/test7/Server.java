package com.kh.test7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(3000);
			Socket s = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
