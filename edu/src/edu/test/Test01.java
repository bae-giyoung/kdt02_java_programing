package edu.test;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// 짝수 합, 홀수 합, 전체 합 , 범위 1~100
		
		Scanner scanner = new Scanner(System.in); // 표준 입력 장치
		System.out.print("num: ");
		int num = scanner.nextInt();
		
		// 답안지 합치기
		int sumOfEvens1 = 0;
		int sumOfOdds1 = 0;
		int totalSum1 = 0;
		
		for (int m = 1; m <= num; m++) {
			if ((m%2) == 0)
				sumOfEvens1+=m;
			else
				sumOfOdds1+=m;
			
		}
		
		totalSum1 = sumOfEvens1 + sumOfOdds1;
		
		System.out.println(sumOfEvens1);
		System.out.println(sumOfOdds1);
		System.out.println(totalSum1);
		

	}

}
