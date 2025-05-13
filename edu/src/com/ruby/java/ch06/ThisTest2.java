package com.ruby.java.ch06;

public class ThisTest2 {

	private String name; // 필드 변수이기 때문에 참조 변수는 null로 초기화!
	private int age; // 필드 변수이기 때문에 int 변수는 0으로 초기화! boolean은 false로 초기화된다는 것 기억하자!
	
	public ThisTest2() {
		this.name = "quest";
		this.age = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		ThisTest2 exam = new ThisTest2();
		exam.setName("Amy");
		
		System.out.println(exam.getName());

	}

}
