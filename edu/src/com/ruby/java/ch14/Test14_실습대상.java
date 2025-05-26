//스트링 부트에서 사용
package com.ruby.java.ch14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test14_실습대상 {
	public static void main(String[] args) {
		//Function
		Function<String, Integer> func = (s) -> {
			int cnt = 0;
			String[] word = s.split(" ");
			cnt = word.length;
			return cnt;
		};
		
		int wordCnt = func.apply("고개를 들어 별들을 보라 당신 발만 내다 보지말고");
		System.out.println("단어 수 : " + wordCnt);
		
		//Predicate
		Predicate<Integer> func2 = (n) -> n % 2 == 0;
		// 위의 람다식을 아래의 식으로 컴파일러가 컴파일 해준다.
		func2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
			
		};
		if (func2.test(123))
			System.out.println("짝수입니다.");
		else
			System.out.println("홀수입니다.");
		
		//Consumer
		Consumer<Date> date = (d) -> {
			String s = new SimpleDateFormat("YY-MM-dd").format(d);
			System.out.println(s);
		};

		date.accept(new Date());
		
		//Supplier
		Supplier<String> day = () -> new SimpleDateFormat("E요일").format(new Date());
		String result = day.get();
		System.out.println(result);
	}
}