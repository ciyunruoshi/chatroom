package com.TestServerSocketServer.view;
import com.TestServerSocketServer.TestServerListener;
public class serverviewmanager {
	
	private serverviewmanager() {}
	TestServerListener newlistener;
	private static final serverviewmanager svm = new serverviewmanager();
//	public static boolean flag= false;
	public static serverviewmanager init(){
		return svm;
	}
	private ServerView ser;
	public void add(ServerView s){
		this.ser=s;
	}
	
	public void start(){
		newlistener=new TestServerListener();
		newlistener.start();
		
	}
	
	 public void stop(){
//		 newlistener.end();
//		 TestServer.si=true;
		// chatsocket.flag=true;
		 newlistener.end();
		 ser.dispose();
		 
	 }
	
}
