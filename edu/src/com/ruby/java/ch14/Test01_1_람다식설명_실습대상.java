package com.ruby.java.ch14;
//일반 인터페이스 구현
//*
interface MyInterface2{//Test01.java의 인터페이스 선언을 사용한다 
	void print();
}
//함수형 인터페이스는 메소드 하나만 가능하다
@FunctionalInterface
interface Multiply2 {
	double getValue();
	//void print();//두개 메소드를 포함하지 못하게 한다 
}

@FunctionalInterface
interface Verify {
	boolean check(int n);//매개변수를 사용하는 람다식
}

@FunctionalInterface
interface Verify2 {
	boolean check(int n, int d);//매개변수를 여러개 사용하는 람다식
}

/*
 * 람다식 본문이 블록 구현
 */
@FunctionalInterface
interface NumberFunc {
	int func(int n);
}

public class Test01_1_람다식설명_실습대상 {
	//*
	public static MyInterface2 test3() {
		return new MyInterface2() {
			@Override
			public void print() {
				System.out.println("hello");
			}
		};
	}
	//*/
	public static void main(String[] args) {
		MyInterface2 m1 = test3();
		//함수형 스타일의 람다식 구현 
		MyInterface2 m2 = ()->System.out.println("hello");//함수형 인터페이스 - 오직 한 메소드만 구현한다 
		m2.print();
		
		Multiply2 m3 = () -> 3.14 * 2;//getValue() 메소드를 overriding하는 코드
		System.out.println(m3.getValue());

		m3 = () -> 10 * 3;
		System.out.println(m3.getValue());
		
		Verify isEven = (n) -> (n % 2) == 0;//check() 함수의 구현이 람다식
		/*
		 * public boolean check(int n) {
		 *    return (n % 2) ==0;
		 *    }
		 */
		System.out.println(isEven.check(10));

		Verify isPositive = (n) -> n >= 0;
		System.out.println(isPositive.check(-5));
		
		Verify2 vf = (n, d) -> (n % d) == 0;
		System.out.println(vf.check(24, 3));
		
		//람다식 블록
		NumberFunc sum = (n) -> {
			int result = 0;
			for (int i = 0; i <= n; i++) {
				result += i;
			}
			return result;
		};

		System.out.println("1부터 10까지의 합 : " + sum.func(10));
		System.out.println("1부터 100까지의 합 : " + sum.func(100));
	}

}
