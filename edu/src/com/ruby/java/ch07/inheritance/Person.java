package com.ruby.java.ch07.inheritance;

//public final class Person {
public class Person {
	
	private String name;
	private int age;
	
	public Person () {
		System.out.println("Person 기본 생성자 실행");
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person 생성자 실행");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	//public final String toString() {
	public String toString() {
		return name + " : " + age;
	}
	

}
