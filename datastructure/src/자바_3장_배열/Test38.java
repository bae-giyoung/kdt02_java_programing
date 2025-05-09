package 자바_3장_배열;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) {
		// 2차원 배열 만들기!
		
//		int[][] arr = new int[5][2];
		
//		int[][] arr = {{1,2},{3,4},{5,6},{7,8},{9,10}};
//		int[][] arr2 = {{1,2},{3,4,33,44},{5,6},{7,8,77},{9,10}};
		
		int[][] arr = new int[5][5];
		Random rnd = new Random();
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length; j++) {
				arr[i][j] = rnd.nextInt(100);
				
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		

		System.out.println();
		// 2차원 배열에서 확장형 for문 사용하기!
		for (int[] row : arr) { // int[] row는 arr 배열의 각 행을 나타냄
			for (int v : row) { // row변수가 각 행이므로 row는 1차원 배열(열), v는 1차원 배열(열)의 각 요소
				System.out.print(v + " ");
			}
			System.out.println();
		}
		
	}

}
