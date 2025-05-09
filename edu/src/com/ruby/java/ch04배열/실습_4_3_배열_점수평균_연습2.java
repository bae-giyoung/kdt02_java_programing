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
public class 실습_4_3_배열_점수평균_연습2 {
	
	public static void main(String[] args) {
		int[] score = new int[10]; // 현재는 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0] !!!
		Random rd = new Random();
		
		// 배열의 각 요소에 정수 값 넣어주고 점수를 기반으로 성적 출력하기!
		for(int i=0; i<score.length;i++) {
			score[i] = rd.nextInt(100); // 0 ~ 99 사이의 (정수)난수 생성 후 해당 인덱스의 요소에 값 넣어주기~!
			
			// 점수를 기반으로 성적 출력
			System.out.println(score[i] + "점- " + getGrade(score[i]) + "학점");
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
