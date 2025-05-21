package com.ruby.java.ch09.기본API.test;
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
		
	}
}