package com.ruby.java.ch09.기본API;
/*
 * split()와 StringTokenizer 클래스 사용
 * - iterator 개념 실습
 */
 
import java.util.StringTokenizer;

public class Test14_실습대상 {
	public static void main(String[] args) {

		String msg = "Although the world is full of suffering, it is full also of the overcoming of it.";
		String arrayMessage[] = msg.split(" ");
		for (String st: arrayMessage)
			System.out.println(st);
		
		StringTokenizer st1 = new StringTokenizer(msg);//st1은 객체임, 배열이 아님
		//st1. //dot 후에 나타나는 메소드를 확인하는 것이 필요함 - 교재 433페이지 표
		
		System.out.println("단어 수 : " + st1.countTokens());
		while (st1.hasMoreTokens()) {
			System.out.print(st1.nextToken() + " + " );
		}
		System.out.println("\n");
		StringTokenizer st11 = new StringTokenizer(msg, ",.");//delimiter 사용. ',' 또는 '.'를 구분자로 사용한다는 뜻
		System.out.println("단어 수 : " + st11.countTokens());
		while (st11.hasMoreTokens()) {
			System.out.print(st11.nextToken() + " + " );
		}
		
		System.out.println("\n================");
		String s = "id=guest&name=Amy&pwd=1004";
		StringTokenizer st2 = new StringTokenizer(s, "&"); // 분리 기호를 &으로 사용한다.
		while (st2.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}

		System.out.println("================");
		StringTokenizer st3 = new StringTokenizer(s, "=&");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
	}
}