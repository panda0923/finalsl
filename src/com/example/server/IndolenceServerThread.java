package com.example.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IndolenceServerThread extends Thread {
	Socket socket = null;
	
	public  IndolenceServerThread(Socket socket){
		this.socket=socket;
	}

	@Override
	public void run() {
		BufferedReader br=null;
		PrintWriter  pw=null;
	try{
		br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw=new PrintWriter(socket.getOutputStream());
		
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetSocketAddress.getHostName();
		int remoteHostPort = inetSocketAddress.getPort();
		
		while(true){
			
	
		}
	}catch(IOException ex){
		ex.printStackTrace();
	}
	}
	
	//1.流盔 历厘
	
	//2.流盔 昏力
	
	//3.包府磊
	
	//4.皋技瘤 傈价
}


