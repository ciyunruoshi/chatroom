package com.TestServerSocketServer;

import java.awt.EventQueue;

import com.TestServerSocketServer.view.ServerView;
import com.TestServerSocketServer.view.serverviewmanager;

public class TestServer {
    public static boolean si=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerView frame = new ServerView();
					frame.setVisible(true);
					serverviewmanager.init().add(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

}
