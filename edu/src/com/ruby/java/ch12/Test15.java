package com.ruby.java.ch12;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test15 {

	public static void main(String[] args) {
		Userbean user = new Userbean("purum","오정임","010-123-4567","서울");
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt"))){ // user.dat .dat확장자를 많이 쓴다.
			out.writeObject(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
