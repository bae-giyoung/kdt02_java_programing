package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		
		System.out.println("===================== 정방향으로 출력 ====================");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("===================== 역방향으로 출력 ====================");
		
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
		
		System.out.println("===================== 이터레이터 요소 출력 ====================");
		// 이터레이터 : 커서에 대해 더 알아보기!
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
