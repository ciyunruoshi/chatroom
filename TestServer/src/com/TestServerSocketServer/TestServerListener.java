package com.TestServerSocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;

import javax.swing.JOptionPane;

public class TestServerListener extends Thread {
	ServerSocket serverSocket;
	public static final Executor exec = new Executor() {
		
		@Override
		public void execute(Runnable command) {
			// TODO Auto-generated method stub
			new Thread(command).start();
			ChatRoom.init().add(command);
		}
	};
	public void end(){
		try {
			ChatRoom.init().stopserver();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void linstener(){
//		try {
//			
//			ServerSocket server = new ServerSocket(12345);
//			int count =0;
//			while(true){
//				Socket chat=server.accept();
//				count++;
//				JOptionPane.showMessageDialog(null, "有陌生人來訪");
//				//new chatsocket(chat, count).start();
//			}
//			
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	public void run() {
		try {
	
			serverSocket = new ServerSocket(12347);
			//int count =0;
			while(true){
				Socket chat=serverSocket.accept();
				
			//	count++;
				JOptionPane.showMessageDialog(null, "有陌生人來訪");
//				chatsocket newchat=new chatsocket(chat);
//				newchat.start();
//				ChatRoom.init().add(newchat);
				//效率不高，使用线程池
				chatsocket newchat = new chatsocket(chat);
				exec.execute(newchat);
				
				
		}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//linstener();
	}	
}
