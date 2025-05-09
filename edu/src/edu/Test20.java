package edu;

public class Test20 {

	public static void main(String[] args) {
		// if~else if문 연습
		int score = 90;
		//char grade;
		//char grade = 0; // char의 초기화 값은 0인가? unicode 0번 문자 \u0000를 나타내는 것일까?
		char grade = '\u0000';
		System.out.println(grade);
		
		if(score >= 90){
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println(grade);

	}

}
