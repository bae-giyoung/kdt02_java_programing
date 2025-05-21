package com.ruby.java.ch09.기본API;
/*
 * 교재 397 - 405 실습 코드> 아래 코드를 이해할 수 있어야 한다.
 */
class MyObject {
	int num;
	public MyObject(int num) {
		this.num = num;
	}
	public String toString() {
		return "오버라이딩 결과: MyObject";
	}
}
class MyObject2 {
	public MyObject2() {}
	public String toString() {
		return "오버라이딩 결과: MyObject2";
	}
}
public class Test01_실습대상 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		obj1.hashCode()
;		Object obj2 = new Object();
		Object obj3 = new MyObject2();
		System.out.println("===397페이지- 해시코드===");
		System.out.println("obj1.hashCode()=" + obj1.hashCode());//출력이 정수
		System.out.println(Integer.toHexString(obj1.hashCode()));
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		System.out.println("===398페이지- 클래스정보===");
		Class c = obj3.getClass();//c는 객체이고 toString()이 있음
		System.out.println(c);
		System.out.println("객체의 클래스 이름:: " + c.getName());
		String st = "hello";
		if ((c.getName()).compareTo("MyObject2")== 1)//클래스 이름에 패키지 이름도 있으므로
			System.out.println("클래스는 " + c.getName()); 
		
		System.out.println("===399페이지- 문자열로 표현===");
		System.out.println(obj1);//toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임 > 정수를 hexa로 변경한 것
		System.out.println(obj1.toString());//399 페이지 하단의 클래스 이름이 string
		System.out.println(obj2);
		System.out.println(obj3);//재정의된 toString() 호출
		
		System.out.println("===403페이지- 같은지 비교===");
		MyObject obj4 = new MyObject(123);
		System.out.println(obj4);
		MyObject obj5 = new MyObject(123);
		//obj4.equals(obj5) //MyObject의 equals()가 실행됨
		if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
			System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
		} else {
			System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
		}
		System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
		if (obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		System.out.println("obj4 = " + obj4);
		MyObject2 mo2 = new MyObject2();//402페이지의 toString() 오버라이딩
		System.out.println(mo2);
	}
}