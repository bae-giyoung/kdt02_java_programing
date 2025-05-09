package com.ruby.java.ch04배열;
/*
 * 배열 사용없이 변수 5개를 사용하여 5명 점수의 평균 구하기
 * int score1,score2,score3, score4, score5;
 */
public class 실습_4_1_변수들사용 {
	//5명 점수를 score1 등의 변수로 초기화: 49, 91, 87, 67, 73
	//최대 점수, 최소 점수, 평균 점수 계산하는 코드 구현
	
	public static void main(String[] args) {		
		int score1 = 49;
		int score2 = 91;
		int score3 = 87;
		int score4 = 67;
		int score5 = 73;
		
		//최대 점수, 최소 점수, 평균점수
		int average = (score1 + score2 + score3 + score4 + score5)/5;
		int min = score1;
		int max = score2;
		
		//min = min > score2 ? score2 : min > score3 ? score3 : min > score4 ? score4 : min > score5 ? score5 : min;
		//max = max < score2 ? score2 : max < score3 ? score3 : max < score4 ? score4 : max < score5 ? score5 : max;
		
		if (min > score2) min = score2;
		if (min > score3) min = score3;
		if (min > score4) min = score4;
		if (min > score5) min = score5;
		
		if (max < score2) max = score2;
		if (max < score3) max = score3;
		if (max < score4) max = score4;
		if (max < score5) max = score5;
		
		System.out.println("평균 점수: " + average);
		System.out.println("최소 점수: " + min);
		System.out.println("최대 점수: " + max);
		
		System.out.println();
		System.out.println("(메소드 활용)평균 점수: " + avg(score1,score2,score3,score4,score5));
		System.out.println("(메소드 활용)최소 점수: " + findMinNumber(score1,score2,score3,score4,score5));
		System.out.println("(메소드 활용)최대 점수: " + findMaxNumber(score1,score2,score3,score4,score5));
	}
	
	public static int avg(int... v) {
		int sum = 0;
		for(int x : v) {
			sum += x;
		}
		return sum/v.length;
	}
	
	public static int findMinNumber(int... v) {
		if (v.length == 0) return 0;
		int min = v[0];
		for(int x : v) {
			if (min > x) min = x;
		}
		return min;
	}
	
	public static int findMaxNumber(int... v) {
		if (v.length == 0) return 0;
		int max = v[0];
		for(int x : v) {
			if (max < x) max = x;
		}
		return max;
	}
}
