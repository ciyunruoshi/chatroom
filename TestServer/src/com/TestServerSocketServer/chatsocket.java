package com.TestServerSocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class chatsocket implements Runnable{
	
	private Socket socket;
	private String id="";
	
	
	
	//StringBuffer sBuffer = new StringBuffer();
	public chatsocket(Socket socket) {
		this.socket = socket;

	}
	
	public void Out(String s){
			
			try {
				
				socket.getOutputStream().write(s.getBytes());
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	
	public void clientinput(){
		try {
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			String line;
			id=br.readLine();
			boolean flag=ChatRoom.init().judge(id, br.readLine());
			if(flag==false){
				Out("sorry!");
				br.close();
			}
			while((line = br.readLine())!=null){
				System.out.println(line);
		    		ChatRoom.init().publish(this, "用戶"+id+"："+line);
		    		
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init(){
		Out("成功連接聊天室\n");
			
	}
	
    @Override
    public void run() {
    	init();
    	clientinput();
    }

}
