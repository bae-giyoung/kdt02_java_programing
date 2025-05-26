//람다식 인자
package com.ruby.java.ch14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//(7) 제네릭 함수형 인터페이스
interface MyFunc<T> {
	T modify(T t);//리턴값이 T 타입
}

/*
 * 람다식을 함수 매개변수로 전달
 */

interface StringFunc {
	String modify(String s);
}

public class Test07_실습대상 {

	static String test(StringFunc sf, String s) {
		return sf.modify(s);
	}

	public static void main(String[] args) {
		
		MyFunc<String> mf1 = (str) -> str.toUpperCase() + ":" + str.length();
		System.out.println(mf1.modify("java"));
		System.out.println(mf1.modify("java programming"));

		MyFunc<Integer> mf2 = (n) -> n * 2;
		System.out.println(mf2.modify(23));
		System.out.println(mf2.modify(42));
		

		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		StringFunc sf1 = (s) -> {//comma를 blank로 바꾸는 modify() 본문
			String result = "";
			char c;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c == ',')
					result += " ";
				else
					result += c;
			}
			return result;
		};
		//람다식을 전달
		String s1 = test(sf1, str);//실행 흐름을 이해하는 노력 필요 > 자료구조에서 comparator를 이해할 수 있음!
		System.out.println(s1);

		//람다식을 메소드 매개변수로 전달: 매우 중요!! 인터페이스가 무엇인지 찾을 수 있어야 한다!
		String s2 = test((s) -> {//단어의 길이가 가장 단어를 찾는 코드
			int max = 0;
			int index = 0;
			String[] word = s.split(",");
			for (int i = 0; i < word.length; i++) {
				if (max < word[i].length()) {
					max = word[i].length();
					index = i;
				}
			}
			return word[index];
		}, str);//실행 흐름을 이해하는 노력 필요
		System.out.println(s2);
	}
}