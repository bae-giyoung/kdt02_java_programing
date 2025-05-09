package edu.test;

import java.util.Scanner;

public class PrimeNumber1 {
	public static void main(String[] args) {
		// 임의의 수 N을 입력 받아서 해당 수가 소수인지 확인하는 프로그램을 작성해보세요.
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Number[0:exit]");
			int num = sc.nextInt();
			if (num == 0) break;
			if (isPrime(num) == true) {
				System.out.println(num + " is a Prime.");
			} else {
				System.out.println(num + " is not a Prime.");
			}
		}
		sc.close();
		System.out.println("Done!");
	}
	
	public static boolean isPrime (int num) {
		for (int i = 2; i < num; i++) {
			if ((num % i) == 0) return false;
		}
		return true;
	}
}
