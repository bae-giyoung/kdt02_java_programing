package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {

	public static void main(String[] args) {
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.txt"))){ // user.dat .dat확장자를 많이 쓴다.
			Userbean user1 = (Userbean) in.readObject();
			System.out.println(user1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
