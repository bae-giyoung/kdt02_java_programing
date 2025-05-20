package com.ruby.java.ch04배열;

public class 배열_오른쪽대각선순회 {
	
	// 2차원 배열을 출력하는 매서드
	private static void printMatrix(int[][] arr) {
		
		System.out.println("================================================================");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			System.out.println("----------------------------------------------------------------");
		}
		System.out.println("================================================================");
		
	}
	
	// 오른쪽 아래 대각선 요소들의 합 구하는 메서드
	private static int addDiagnalElements(int[][] arr) {
		// 대각선 요소: 성분의 행과 열의 지표가 같다!
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == j)
					sum += arr[i][i];					
			}
		}
		return sum;
	}
	
	// 왼쪽 아래 삼각형 요소들의 합 구하는 메서드
	private static int addLeftDownCornerElements(int[][] arr) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(j <= i)
					sum += arr[i][j];
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// 2차원 배열을 오른쪽 대각선으로 순회해서 합을 구해보자!
		// [0][0],[1][1],[2][2],[3][3], ...
		
		int[][] arr = new int[5][8];
		
		// 배열에 값 넣기
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = j;
			}
		}
		
		printMatrix(arr);
		
		
		// 오른쪽 아래 대각선 요소들의 합
		System.out.println("오른쪽 아래 대각선 요소들의 합: " + addDiagnalElements(arr));
		
		// 왼쪽 삼각형 순회해서 합 구하기!
		System.out.println("왼쪽 아래 삼각형 요소들의 합: " + addLeftDownCornerElements(arr));
	}


}
