package com.ruby.java.ch10;

import java.util.HashSet;
import java.util.Iterator;

class User {
	String ssn; // 주민번호
	String name; // 이름
	
	User(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ssn + " : " + name;
	}
	
	@Override
	public int hashCode() { // 문자열은 String Constant Pool에 같은 값이 하나만 저장이 되므로 목적을 위해 해시코드가 아닌 (문자열인)ssn값을 숫자로 리턴해주자
		return Integer.parseInt(ssn);
	}
	
	@Override 
	public boolean equals(Object obj) { // ssn값이 같으면 같은 객체라고 설정하고 싶어서!
		boolean result = false;
		User u = (User) obj;
		if (this.ssn.equals(u.ssn))
			result = true;
		return result;
	}
}

public class Test11 {

	public static void main(String[] args) {
		User u1 = new User("123", "김푸름");
		User u2 = new User("123", "김푸름");

		HashSet<User> users = new HashSet<User>();
		
		users.add(u1);
		users.add(u2);
		
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
