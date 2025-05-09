package edu.test;

import java.util.Scanner;

public class MinBillCount {

	public static void main(String[] args) {
		// 상품 가격을 입력 받아서 최소로 지불하기 위한 지폐 수를 구하세요. 5만원 1만원 5천원 1천원 지폐
		
		// 가격 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.print("총액: ");
		int bill = scanner.nextInt(); // 가격 입력받아서 변수에 넣기
		
		// 단위별 지폐 변수 생성
		int bill5M = 0;
		int bill1M = 0;
		int bill5K = 0;
		int bill1K = 0;
		
		// 가격을 나눈 나머지 계산 : 5만원, 1만원, 5천원, 1천원
		bill5M = bill / 50000;
		bill %= 50000;
		System.out.println("5만원: " + bill5M + "장");
		bill1M = bill / 10000;
		bill %= 10000;
		System.out.println("1만원: " + bill1M + "장");
		bill5K = bill / 5000;
		bill %= 5000;
		System.out.println("5천원: " + bill5K + "장");
		bill1K = bill / 1000;
		System.out.println("1천원: " + bill1K + "장");
		
	}

}
