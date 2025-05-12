package com.ruby.java.ch04배열;

import java.util.Random;

/*
 * 난수 배열의 최대, 최소, 평균 구하기
 * 0부터 100까지의 정수 난수 10개를 생성하여 배열에 저장
 * 배열에서 최대값, 최소값, 평균을 구하기
 *   >> for문을 사용한 최대값 찾기 - 교재 149 페이지의 배열 길이: length 사용
 * 출력 내용:
 *   배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
 *   [1,2,3,4,5]
 *   최대값 출력은 다음과 같다
 *   최대값 = **
 *   최소값, 평균값 출력은 최대값 출력과 같다.
 *   
 */


public class 실습_4_4_배열생성최대값_연습2 {
	
	public static void main(String[] args) {
		// input: [1,2,3,4,5,6,7,8,9,10]
		// output: 최대값 = **, 최소값 = **, 평균값 = **
		// [TODO]
		// 1. 선언: 배열 생성, Random 클래스 인스턴스 생성
		// 2. for문으로 배열에 값 넣기
		// 3. 출력: 배열을 [1,2,3,4,5] 형태로 출력
		// 4. 최대, 최소 => 최대값 최소값 변수 선언, 비교 후 값 저장
		// 5. 평균값 => 배열 요소의 총함 / 배열의 길이
		int[] arr = new int[10];
		int min;
		int max;
		int sum = 0;
		float avg = 0;
		Random rd = new Random();
		
		// 배열의 요소에 값 할당 및 출력
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(100);
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
		
		// 최대, 최소값, 평균값
		min = arr[0];
		max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
			if (max < arr[i])
				max = arr[i];
			sum += arr[i];
		}
		avg = sum/arr.length;
		System.out.println("최소값 = " + min);
		System.out.println("최대값 = " + max);
		System.out.println("평균값 = " + avg);
		
		
		
	}
	
}
