package com.ruby.java.ch04배열;

public class 실습_4_2_배열생성최대값 {
	public static void main(String[] args) {
        // 1차원 배열 생성 및 초기화
		/*
		 * 정수 1차원 배열 price를 선언하고 5개 값으로 초기화:
		 * 49, 91, 87, 67, 73
		 */
		
        // for문을 사용한 최대값 찾기
		/*
		 * 최대값 변수를 priceMax로 선언한 후에 for 문을 사용하여 최대값을 찾는다
		 * 배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
		 * [1,2,3,4,5]
		 * 최대값 출력은 다음과 같다
		 * 최대값 = **
		 * 
		 */
		
		// 최대값 찾아서 출력
		int priceMax = 0;
		int[] price = {49, 93, 87, 67, 73};
		int stepNum = 0;
		
		for (int i = 0; i < price.length; i++) {
			if (priceMax < price[i]) priceMax = price[i];
		}
		System.out.println("최대값: " + priceMax);
		
		// 배열 형태 출력
		System.out.print("[");
		for(int x : price) {
			stepNum++;
			if (stepNum == price.length)
				System.out.print(x);
			else
				System.out.print(x + ", ");
		}
		System.out.println("]");
    }
}
