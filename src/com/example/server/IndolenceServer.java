package com.example.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IndolenceServer {
	private static final int Port=50000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serversocket = null;
		
		try{
			//1.소캣생성
			serversocket = new ServerSocket();
			//2. 바인딩
			InetAddress inetAddress= InetAddress.getLocalHost();
			String hostAddress = inetAddress.getHostAddress();
			serversocket.bind(new InetSocketAddress(hostAddress,Port));
			//3.연결 요청 기다림
			while(true){
				Socket socket =serversocket.accept();
				Thread thread = new IndolenceServerThread(socket);
				thread.start();
			}
			
		}catch(IOException ex){
			System.out.println("에러:"+ex);
		}
	}

}
