package com.ruby.java.ch05;

public class StaticMethodTest {
	int num = 123;
	static int staticNum = 123;

	public static void main(String[] args) {
		StaticMethodTest.print1(); // 자기 클래스 안에서 저렇게는 사용하지 않음! 그냥 학습용! 자기 클래스 안에서는 그냥 print1(); 호출!
		// 위에는 연습용이고, 외부 클래스에서 사용 시 저렇게 클래스명.스태틱메소드명(); 이렇게 접근해서 메소드 호출!
//		StaticMethodTest.print2(); // 에러 남
		StaticMethodTest exam = new StaticMethodTest();
		exam.print2();
		
		print1(); // 같은 클래스에 있기 때문에 static 메소드는 사용할 수 있다!
		//print2(); static이 아니라서 ! 인스턴스를 생성 하면 사용핧  수 있는 메소드이다!

	}
	
	// 메인 메소드가 실행되기 이전에 코드 영역에 저장이 되기 때문에 인스턴스 
	public static void print1() { // 클래스 실행(?)시에 코드 영역에 바로 저장이되는 static이기 때문에! 인스턴스를 만들지 않고 사용 가능!
		System.out.println("hello");
//		int num2 = num; // 에러남! 
		int num2 = staticNum; // 에러 안남!
	}
	
	public void print2() { // 얘는 인스턴스를 
		System.out.println("java");
		int num3 = num; // 에러 안남!
		//int num3 = staticNum;
	}

}
