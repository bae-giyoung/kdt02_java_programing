package edu.test;

import java.util.Scanner;

public class Test31 {

	public static void main(String[] args) {
		// 입력한 구구단 출력 : 숫자 2개 입력 받아서, 작은수부터 큰수까지 단을 출력하라
		Scanner scanner = new Scanner(System.in);
		System.out.println("구구단 출력기 : 출력을 원하는 구구단 단수의 법위를 입력하세요. 2부터 9까지의 숫자를 입력하세요.");
		System.out.print("시작 단수: ");
		int startNum = scanner.nextInt();
		
		System.out.print("끝 단수: ");
		int endNum = scanner.nextInt();
		
		
		for (int i = startNum; i <= endNum; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + " = " + (i * j));
			}
			System.out.println();
		}
		
		// while로 변경해보기!
		
		
	}

}
