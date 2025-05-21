
package com.ruby.java.ch09.기본API;

import java.util.Arrays;

public class Test19_실습대상 {

	public static void main(String[] args) {
		String title = "**** 2018 Olympic ****";
		//447페이지 표: *는 메타 문자 > \*는 * 문자를 나타냄 > 함수에 \* 전달하려면 \\* 필요
		title = title.replaceAll("\\*", "%");
		System.out.println(title);
		
		// \w는 교재 446 표: 메타 문자 > \\w+는 1번 이상 반복
		//정규표현식에서 \\w는 알파벳(a-z, A-Z), 숫자(0-9), 밑줄(_) 중 하나
		title = title.replaceAll("\\w+", "Winter");
		System.out.println(title);
		title = title.replaceAll("Winter", "Olympic");
		System.out.println(title);

		title = title.replaceAll("[^a-z]", "X");
		System.out.println(title);

		String str = "1, 2, , 3, 4, 5, 6   7,, 8";
		String[] result = str.split("[\\s,]+");
		System.out.println(Arrays.toString(result));

		String temp = "-20";
		temp = temp.replaceFirst("\\W", "+");
		System.out.println(temp);
	}
}