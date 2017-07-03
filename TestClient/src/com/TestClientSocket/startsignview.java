package com.TestClientSocket;

import java.awt.EventQueue;

import com.TestClientwindow.view.ChatVerification;
import com.TestClientwindow.view.SignViewManager;

public class startsignview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatVerification frame = new ChatVerification();
					frame.setVisible(true);
					SignViewManager.init().setchatverfication(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
