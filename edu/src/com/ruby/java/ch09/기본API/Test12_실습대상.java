package com.ruby.java.ch09.기본API;
/*
 * 실습 - 스트링의 정렬
 */
import java.util.Arrays;

public class Test12_실습대상 {
	static void showData(String[]arr) {
		System.out.println();
		for (String st: arr)
			System.out.print(st + " -> ");
	}
	static void sortData(String[]arr, int[]arrInt) {
		for (int i = 0; i< arr.length;i++)
		{
			arrInt[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(arrInt);
	}
	static void showNumber(int[]arr) {
		System.out.println();
		for (int n: arr)
			System.out.print(n + " -> ");
	}
	public static void main(String[] args) {
		// string 정렬의 문제 
		String arr[] = {"12", "9", "222", "5", "888", "112"};
		showData(arr);
		Arrays.sort(arr);
		showData(arr);
		
		int n1 = 10;
		Integer obj1 = n1; // Integer.valueOf(n1) 컴파일러가 자동으로 실행해 줌. Integer 클래스 인스턴스를 만드는 구문이라. Heap에 저장이 되나?
		//obj1.* - methods를 사용하기 위해
		
		Integer obj2 = Integer.parseInt("20");// "9", "12" 정렬시에는 12,9가 온다 이때 필요:432페이지 표
		int n2 = obj2; // obj2.intValue()
		//obj2.hashCode();
		// obj2. n2. 
		
		Integer obj3 = 30; // new Integer(30)

		int n3 = obj3 + 40; // int n3 = obj3.intValue() + 40; 과 같은 코드

		System.out.println("\n" + n1 + " : " + obj1);
		System.out.println(obj2 + " : " + n2);
		System.out.println(n3);
		//정수로 배열로 변환후 정렬 
		int []arrInt = new int[arr.length];
		sortData(arr, arrInt);
		showNumber(arrInt);

	}
}