package com.ruby.java.ch05;

public class Member {
	private String name; // 필드 변수이기 때문에 참조 변수는 null로 초기화!
	private int age; // 필드 변수이기 때문에 int 변수는 0으로 초기화! boolean은 false로 초기화된다는 것 기억하자!
	
	public Member() {
		this("guest");
	}
	
	public Member(String name) {
		this("guest", 0);
	}
	
	public Member(String name, int num) {
		this.name = name;
		this.age = num;
	}
	
	public void setName(String name) {
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		
		//Member m = new Member(); // public Member 생성자 메소드를 작성하지 않더라도!(없으면) 기본 생성자는 자동 추가해준다! 누가? 컴파일러가!!
		//System.out.println(m); // 참조값 출력해보자!
		
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Amy", 123);
		
		System.out.println("회원명: " + m1.name + ", 연령: " + m1.age);
		System.out.println("회원명: " + m2.name + ", 연령: " + m2.age);
		System.out.println("회원명: " + m3.name + ", 연령: " + m3.age);
	}


}
