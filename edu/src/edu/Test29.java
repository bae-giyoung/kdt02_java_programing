package edu;

public class Test29 {

	public static void main(String[] args) {
		// continue문 : 그 다음 조건으로 계속 실행하기
		for (int i = 0; i < 10; i++) {
			if(i%2 == 0) continue;
			System.out.println(i);	// 결과적으로 0 ~ 9 사이의 홀수 출력
		}
	}

}
