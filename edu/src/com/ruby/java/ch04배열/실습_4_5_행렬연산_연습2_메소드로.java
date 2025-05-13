package com.ruby.java.ch04배열;

import java.util.Arrays;
import java.util.Random;

public class 실습_4_5_행렬연산_연습2_메소드로 {

	public static void main(String[] args) {
		// 메소드 생성으로 코드 변경해보기!
		
		// 1. A 랜덤 배열 생성
		int[][] A = setMatrixRandom(3,5);
		printMatrix(A, "Matrics A");
		
		// 2. B 랜덤 배열 생성
		int[][] B = setMatrixRandom(3,5);
		printMatrix(B, "Matrics B");
		
		// 3. C = A + B
		int[][] C = addMatrices(A, B);
		printMatrix(C, "Matrics C");
		
		// 4. D
		int[][] D = setMatrixRandom(5,4);
		printMatrix(D, "Matrics D");
		
		// 5. E = A * D
		int[][] E = multiplyMatrices(A,D);
		printMatrix(E, "Matrics E");
		
		// 6. F는 A의 전치행렬
		int[][] F = makeTransposeMatrix(A);
		printMatrix(F, "Matrics F");
		
		// 7. 건너뜀
		
    	// 8. A와 E가 같은지 비교
		System.out.println("===============================");
		System.out.println("is A and E are Same Matrices?");
		System.out.println(isMatrixEquel(A,E));
		System.out.println("===============================");
		
		System.out.println("===============================");
		System.out.println("is A and A are Same Matrices?");
		System.out.println(isMatrixEquel(A,A));
		System.out.println("===============================");
		
		
		// 9.2차 배열을 table 형태로 출력하기 : printArrayToTable 메소드 만들었음.
		System.out.println();
		System.out.println("[테이블 형태로 출력]");
		printArrayToTable(A);
	}
	
	// 행력 생성 메소드 (0 ~ 99 랜덤 점수의 배열)
	public static int[][] setMatrixRandom (int r, int c){
		int[][] arr = new int[r][c];
		Random rd = new Random();
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = rd.nextInt(100);
			}
		}
		
		return arr;
	}
	
	// 행렬 출력 메소드
	public static void printMatrix(int[][] arr, String str) {
		System.out.println("=================");
		System.out.println("Matric " + str);
    	System.out.println("-----------------");
    	for (int i = 0; i < arr.length; i++) {
    		for(int j = 0; j < arr[i].length; j++) {
    			if (j == arr[i].length - 1)
    				System.out.println(arr[i][j]);
    			else
    				System.out.print(arr[i][j] + " ");
    		}
    	}
    	System.out.println("=================");
    	System.out.println();
	}
	
	// 행렬 합 연산 메소드
	public static int[][] addMatrices (int[][] A, int[][] B){
		int ar = A.length;
		int ac = A[0].length;
		int[][] newArray = new int[ar][ac];
		
		for (int i = 0; i < ar; i++) {
			for (int j = 0; j < ac; j++) {
				newArray[i][j] = A[i][j] + B[i][j];
			}
		}
		
		return newArray;
	}
	
	// 행렬 곱 연산 메소드
	public static int[][] multiplyMatrices (int[][] A, int[][] B){
		int ar = A.length;
		int ac = A[0].length; // ac == br
		int bc = B[0].length;
		int[][] newArray = new int[ar][bc];
		
		// 행렬의 곱셈 공식
		// E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][4]*D[4][j]
		// E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][k]*D[k][j]
		for (int i = 0; i < ar; i++) {
			for (int j = 0; j < bc; j++) {
				for (int k = 0; k < ac; k++) {
					newArray[i][j] += A[i][k]*B[k][j];	
				}
			}
		}
		
		return newArray;
	}
	
	// 전치 행렬 메소드
	public static int[][] makeTransposeMatrix(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int[][] newArray = new int[c][r];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newArray[j][i] = A[i][j];
			}
		}
		
		return newArray;
	}
	
	// 행렬 비교 메소드
	public static boolean isMatrixEquel(int[][] A, int[][] B) {
		Boolean isSameSize = false;
		Boolean isEquel = false;
		int ar = A.length;
		int br = B.length;
		
		// 크기가 같은 지 비교, 행의 개수가 같으면 각 행 별 열의 개수 비교
		if (ar == br) {
			for (int i = 0; i < ar; i++) {
				isSameSize = A[i].length == B[i].length;
			}
		}
		
		if (isSameSize == false) return false;
		
		// 크기가 같으면 각 성분의 값이 같은지 비교
		for (int i = 0; i < ar; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != B[i][j])
					return false;
			}
		}
		
		isEquel = true;
		
		return isEquel;
	}
	
	// 2차 배열을 table 형태로 출력
	private static void printArrayToTable(int[][] arr) {
		int r = arr.length;
		for (int i = 0; i < r; i++) {
			int c = arr[i].length;
			
			// 제일 위 테두리
			for (int j = 0; j < c; j++) {
				if (i == 0)
					System.out.print("========");
				if (j == arr[0].length - 1)
					System.out.println();
			}
			
			// 요소 출력
			for (int j = 0; j < c; j++) {
				if (j == 0)
					System.out.print("|" + arr[i][j] + "\t| ");
				else
					System.out.print(arr[i][j] + "\t| ");
			}
			
			System.out.println();
			for (int j = 0; j < c; j++) {	
				if (i != r-1)
					System.out.print("________");
			}
			System.out.println();
			
			// 제일 아래 테두리
			if (i == r - 1) {
				for (int j = 0; j < c; j++) {
					System.out.print("========");
				}				
			}
			
		}
		System.out.println();
	}

}
