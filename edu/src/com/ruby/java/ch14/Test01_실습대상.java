package com.ruby.java.ch14;
/*
 * 익명클래스로 인터페이스 구현
 * 익명객체로 인터페이스 메소드 호출
 */
//인터페이스 구현 방법
interface MyInterface {
	public void print();
}
class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}
class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}
public class Test01_실습대상 {
	//매개변수 타입이 인터페이스
	static void test(MyInterface mi) {
		mi.print();
	}
	//익명클래스 객체를 리턴
	static MyInterface test2() {//리턴 값의 타입이 인터페이스
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}

	public static void main(String[] args) {
		//방법1
//		MyClass1 mc1 = new MyClass1();
//		MyClass2 mc2 = new MyClass2();
		MyInterface mc1 = new MyClass1();
		MyInterface mc2 = new MyClass2();
		mc1.print(); // MyClass1
		mc2.print(); // MyClass2
		
		//방법2: 익명 클래스
		MyInterface mi = new MyInterface() {//interface를 구현한 것이므로 클래스 - 익명 클래스
			@Override
			public void print() {
				System.out.println("익명 클래스로 구현");
			}
		};

		test(mc1); // MyClass1
		test(mi); // 익명 클래스로 구현

		mi.print(); // 익명 클래스로 구현
		
		//방법3: 선언, 생성, 호출을 한꺼번에 처리하는 인터페이스 객체 - 익명객체
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print(); // 선언, 생성, 호출을 한번에 처리

		MyInterface mi2 = test2(); // 객체를 반환받음
		mi2.print(); // test2() 메서드에서 반환된 MyInterface
		
	}
}