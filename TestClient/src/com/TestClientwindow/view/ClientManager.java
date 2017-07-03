package com.TestClientwindow.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientManager {
	
	private ClientManager(){} //���캯��˽�У�ֻ��������ڲ����ô���ʵ��������ʵ����ֻ��һ��clientManager��ʵ��
	private static final ClientManager cm= new ClientManager();
	public static ClientManager init(){
		return cm;
	}
	Clientwindow clientwindow;
	Socket socket ;
	BufferedWriter writer;
	BufferedReader reader;
	String IP;
	public void setwindow(Clientwindow window){
		this.clientwindow= window;
		clientwindow.appendtxt("����̨��������");
	}
	public void connect(){
		new Thread(){

			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 12347);
					
					reader = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream()));
					
					writer = new BufferedWriter(
							new OutputStreamWriter(
									socket.getOutputStream()));
					send(clientwindow.getinfo());
					String line;
					while ((line = reader.readLine())!= null) {
						clientwindow.appendtxt(line);
					}
					
					writer.close();
					reader.close();
					reader=null;
					writer=null;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
			
		  
	}
	
	public void send(String message){
		try {
			
			writer.write(message+"\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
