package edu;

public class Test28 {
	public static void main(String[] args) {
		int cnt = 0;
		while(true) { // break를 주지 않으면 무한 루프
			System.out.println("OK");
			cnt += 2;
			if (cnt >= 10) {
				break;
			}
		}
	}
}
