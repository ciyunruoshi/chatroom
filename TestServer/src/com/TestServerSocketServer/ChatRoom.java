package com.TestServerSocketServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ChatRoom {
	private JsonObject object;
	private JsonParser parser; 
	private  ChatRoom(){date();}
	private static ChatRoom chatroom = new ChatRoom();
	Vector<chatsocket> roommate = new Vector<chatsocket>();
 	public static ChatRoom init(){
		return chatroom;
	}
	
 	public void stopserver(){
 		for (int i = 0; i < roommate.size(); i++) {
			chatsocket temp = roommate.get(i);
				 temp.Out("服务器已关闭"+"\n");
 		}
 	}
 	
 	
 	private void date(){
 		try {
 			parser= new JsonParser();
			object = (JsonObject) parser.parse(new FileReader(new File("inf.json")));
			
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 	}
 	
 	public boolean judge(String na,String ps){
 		String nString = object.get(na).getAsString();
 		if(nString.equals(ps)){
 			return true;
 		}
 		return false;
 		
 		
 		
 	}

 	
 	
	public void add(Runnable command){
		roommate.add((chatsocket)command);
	}
	
	public void publish(chatsocket name,String message){
		for (int i = 0; i < roommate.size(); i++) {
			chatsocket temp = roommate.get(i);
			if (!name.equals(temp)) {
				System.out.println(message);
				 temp.Out(message+"\n");//凡是输出的语句，需要用到readline()函数
				 //必需加上换行符
				 //read line()函数会缓存接收的数据知道换行符才全部输出
				 //read line()函数只有在连接中断或者异常的时候才会返回null
				 //其他的时候会处于阻塞状态一直等待读取数据，哪怕此时没有数据传入
			}
		}
	} 
}
