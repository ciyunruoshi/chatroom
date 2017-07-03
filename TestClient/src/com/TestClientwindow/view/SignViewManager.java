package com.TestClientwindow.view;

import com.TestClientSocket.StartClient;

public class SignViewManager {

	private SignViewManager() {}
	private static final SignViewManager svm= new SignViewManager();
	public static SignViewManager init(){
		return svm;
	}
	
	ChatVerification c;

	 public void setchatverfication(ChatVerification c){
		 this.c=c;
	 }
	 
	 public void ifoandsign(String name,String password){

		 c.dispose();
		 //System.out.println(this.name+this.password);
		 new StartClient(name,password).execute();
	 }	 
}
