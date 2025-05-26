package com.ruby.java.ch13;

class StringUtil {
	private String value;
	
	<T extends CharSequence> StringUtil(T value) {
		this.value = value.toString();
	}
	
	void printVal() {
		System.out.println("value: " + value);
	}
}

public class GenConsTest {

	public static void main(String[] args) {
		String s = new String("서울"); // [new 키워드] Heap에 저장.
		String s1 = "서울"; // [문자열 리터럴] String Constant Pool에 저장
		String s2 = "서울"; // 새로운 객체를 생성하지 않고 String Constnat Pool에 이미 저장이 되어 있는 "서울"의 참조값을 받아와서 저장
		StringBuffer sbuf = new StringBuffer("대전");
		StringBuilder sbui = new StringBuilder("대구");
		
		StringUtil su1 = new StringUtil(s);
		StringUtil su2 = new StringUtil(sbuf);
		StringUtil su3 = new StringUtil(sbui);
		
		su1.printVal();
		su2.printVal();
		su3.printVal();

	}

}
