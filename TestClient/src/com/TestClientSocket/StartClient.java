package com.TestClientSocket;

import java.awt.EventQueue;

import com.TestClientwindow.view.ClientManager;
import com.TestClientwindow.view.Clientwindow;

public class StartClient {
	String password;
	String name;
	
	
	public StartClient(String name,String password) {
		this.name = name;
		 this.password= password;
	}
	
	public void execute(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientwindow frame = new Clientwindow(name,password);
					frame.setVisible(true);
					ClientManager.init().setwindow(frame);
					ClientManager.init().connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
