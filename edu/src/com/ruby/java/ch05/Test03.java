package com.ruby.java.ch05;

public class Test03 {

	public static void main(String[] args) {
		addNumberAndPrint(1, 2);
		addNumberAndPrint(1, 2, 3);
		addNumberAndPrint(1, 2, 3, 4);
		addNumberAndPrint(1, 2, 3, 4, 5);
	}
	
	public static void addNumberAndPrint(int... v) {
		System.out.print("다음의 " + v.length + "개 요소의 합산: ");
		int sum = 0;
		for (int x : v) {
			sum += x;
			System.out.print(x + " ");
		}
		System.out.println(" => " + sum);
	}

	public static int addNumber(int... v) {
		int sum = 0;
		return sum;
	}
}
