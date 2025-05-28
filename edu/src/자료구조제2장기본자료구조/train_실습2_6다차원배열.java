package 자료구조제2장기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = 4*3아닌가?");
		System.out.println("F[4][3] = ");
		showData("행렬 F", F);
//		C= multiplyMatrixTransposed(A,F); // 위의 C와 결과가 같아야 한다고 하심 -> 2*3, 4*3 인데...? 3*2 x 3*4 안될듯, 2*3 x 3*4로 생각해보자
		int [][]G = multiplyMatrixTransposed(A,F); // 위의 C와 결과가 같아야 한다고 하심 -> 2*3, 4*3 인데...? 3*2 x 3*4 안될듯, 2*3 x 3*4로 생각해보자
		showData("행렬 곱셈 결과-전치행렬 사용", C);
//		boolean result = equals(A,C);
		boolean result = equals(C,G);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}
	
	static void inputData(int [][]data) {
		Random rnd = new Random();
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j] = rnd.nextInt(50) + 10;
			}
		}
	}
	
	static void showData(String msg, int[][]items) {
		System.out.println("====== " + "[" + msg + "]" + " ======");
		for(int i=0; i<items.length; i++) {
			for(int j=0; j<items[i].length; j++) {
				System.out.print(items[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("=====================\n");
	}
	
	static boolean equals(int[][]a, int[][]b) {
		//행렬 a,b의 행의 수, 열의 수가 같아야 하고 각 원소가 같아야 한다.
		if(a.length != b.length) return false;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i].length != b[i].length) return false;
				if(a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}
	
	static int[][] addMatrix(int [][]X, int[][]Y) {
		int[][] newMatrix = new int[X.length][X[0].length];
		for(int i=0; i<X.length; i++) {
			for(int j=0; j<X[i].length; j++) {
				newMatrix[i][j] = X[i][j] + Y[i][j];
			}
		}
		return newMatrix;
	}
	
	static int[][] multiplyMatrix(int [][]X, int[][]Y) { // 결과: 2*4 크기, 변화하고 있는 수 3개임
		int[][] newMatrix = new int[X.length][Y[0].length];
		for(int i=0; i<X.length; i++) { // X 2*3 -> 2: 0~1
			for(int j=0; j<Y[0].length; j++) { // Y 3*4 -> 4: 0~3
				for(int k=0; k<X[0].length; k++) { // 3: 0~2
					newMatrix[i][j] += X[i][k] * Y[k][j];
				}
			}
		}
		return newMatrix;
	}
	
	static int[][] transposeMatrix(int [][]X) {
		int[][] newMatrix = new int[X[0].length][X.length];
		for(int i=0; i<X.length; i++) {
			for(int j=0; j<X[i].length; j++) {
				newMatrix[j][i] = X[i][j];
			}
		}
		return newMatrix;
	}
	
	static int[][] multiplyMatrixTransposed(int [][]X, int[][]Y){
		int[][] Yt = transposeMatrix(Y);
		return multiplyMatrix(X, Yt);
	}
}
