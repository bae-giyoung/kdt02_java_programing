package edu;

public class Test19 {

	public static void main(String[] args) {
		// 문제 : score 값에 따라 합격, 불합격 출력하기
		int score = 90;
		
		//1. if else문 사용
		String result = "";
		
		if(score >= 60) {
			result = "합격";
		} else {
			result = "불합격";
		}
		System.out.println(result);
		
		//2. 삼항연산자 사용
		System.out.println(score >= 60 ? "합격" : "불합격");
	}
}
