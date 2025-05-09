package com.ruby.java.ch04배열;

import java.util.Random;

/*
 * 배열 사용, 난수로 입력된 10명의 성적 평균 구하기
 * Random rd =new Random();
 * score[i] = rd. nextInt(100);//0 ~ 99 정수 생성
 * 
 * 10명 학생의 학점 출력:
 *    ~90 A, ~80 B, ~70 C, ~60 D, 59~ F
 *    출력은 "99점 - A 학점" 등으로 출력한다.
 */
public class 실습_4_3_배열_점수평균 {
	public static void main(String[] args) {
		int[] score = new int[10];
		Random rd = new Random();
		
		// for 문으로 배열의 각 요소에 0 ~ 99 사이의 숫자 할당
		for (int i=0; i<score.length; i++) {
			score[i] = rd.nextInt(100);
			
			// 점수별 학점 출력
			System.out.println(score[i] + ": " + getGrade(score[i]));			
		}
		
	}
	
	public static char getGrade(int score) {
		char grade;
		if (score >= 90) grade = 'A';
		else if (score >= 80) grade = 'B';
		else if (score >= 70) grade = 'C';
		else if (score >= 60) grade = 'D';
		else grade = 'F';
		return grade;
	}


}
