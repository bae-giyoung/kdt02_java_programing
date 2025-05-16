package com.ruby.java.ch07.inheritance;

public class Professor extends Person {
	private String subject;
	
	public Professor () {
		super();
		System.out.println("Professor 생성자 실행");
	}
	
	public Professor(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
		System.out.println("Professor 생성자 실행");
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
//		return getName() + " : " + getAge() + " : " + subject;
		return super.toString() + " : " + subject;
	}
}
