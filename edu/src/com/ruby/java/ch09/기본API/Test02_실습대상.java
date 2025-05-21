package com.ruby.java.ch09.기본API;
/*
 * ==, s1.equals(s2)
 */
public class Test02_실습대상 {

	public static void main(String[] args) {
		System.out.println("=== 407페이지- String 클래스 ===");
		String s1 = new String("java");//heap에 객체 생성
		String s3 = new String("java");//객체 생성자 호출 s1 != s2 서로 다른 참조값(서로 다른 객체를 가리킴)
		String s2 = "java";//컴파일러가 static 영역에 데이터 생성한 후에 참조
		String s4 = "java";//String Constant Pool (문자열 상수 풀)에 저장

		System.out.println("=== 409페이지- 문자열 비교 ===");
		System.out.println("s1,s3의 해시코드 비교>>  " +System.identityHashCode(s1)+":" + System.identityHashCode(s3));//같은 값
		System.out.println("s1, s3의 출력값 비교>>  " + s1 + " : "+ s3.toString()); // 객체가 들어가면 자동으로 컴파일러가 객체.toString()실행해줌
		System.out.println("s2,s4의 해시코드 비교>>  " +s2.hashCode()+":" + s4.hashCode());//s2, s4 : 같은 값
		if (s1 == s3) {//s1, s3은 다른 값이다			
			System.out.println("s1 == s3::동일 객체이다.");
		} else {
			System.out.println("s1 == s3::다른 객체이다.");
		}
		
		System.out.println(System.identityHashCode(s2)+":" + System.identityHashCode(s4));//같은 값
		//객체의 참조값을 기반으로 한 해시값을 반환
		//Object 클래스의 원래 hashCode()와 동일하게 동작
		System.out.println(s2.hashCode()+":" + s4.hashCode());//같은 값
		//s2.hashCode()는 "java"라는 문자열의 내용에 기반한 해시값을 반환
		
		if (s2 == s4) {
			System.out.println("s2 == s4::동일 객체이다.");
		} else {
			System.out.println("s2 == s4::다른 객체이다.");
		}
		
		if (s1.equals(s3)) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1.equals(s3)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s3)::다른 문자열을 가집니다.");
		}
		
		if (s1 == s3) {
			System.out.println("s1 ==s3 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1 != s3::다른 문자열을 가집니다.");
		}
		
		System.out.println("s1 = " + s1 + ", s2 = " + s2);
		String s5 = "JAVA";

		if (s1.equals(s5)) {
			System.out.println("s1.equals(s5)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s5)::다른 문자열을 가집니다.");
		}

		if (s1.equalsIgnoreCase(s5)) {
			System.out.println("s1.equalsIgnoreCase(s5)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equalsIgnoreCase(s5)::다른 문자열을 가집니다.");
		}
		
	}
}