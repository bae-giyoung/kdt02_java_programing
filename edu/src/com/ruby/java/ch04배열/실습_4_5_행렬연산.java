package com.ruby.java.ch04배열;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/*
 * 2차원 배열과 행렬 연산
 * 
 * 학습 목표
 *  1) 2차원 배열 만들기
 *  2) 난수로 배열 값 채우기
 *  3) 배열 간 덧셈, 곱셈, 전치(transpose) 개념 익히기
 *  4) 두 배열이 같은지 비교하기
 *  5) 배열을 테이블 형태로 출력하기
 *  
 *  구체적 설명:

1. 3줄 5칸짜리 표 A를 만든다.

	A[3][5]는 3명의 학생이 5과목 시험 본 점수표라고 생각하자.

	점수는 0~99 사이의 무작위 숫자로 채운다.

2. 같은 크기의 표 B도 만들어서 무작위 점수로 채운다.

3. C = A + B

	A와 B의 각 자리에 있는 값을 더해서 C라는 새로운 표를 만든다.

	예: C[0][0] = A[0][0] + B[0][0]

4. 5줄 4칸짜리 표 D를 만든다.

	D[5][4]는 예를 들어 과목별 프로젝트 점수라고 생각해보자.

5. E = A × D (행렬 곱셈)

	A(3x5)와 D(5x4)를 곱해서 E(3x4)라는 표를 만든다.

	E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][4]*D[4][j]

6. F = D의 전치 행렬 (Transpose)

	D[5][4]의 전치는 F[4][5]가 된다.

	행과 열의 위치를 바꾼 표이다.

7. G = A × F (A 곱하기 D의 전치 행렬)

	A[3][5] × F[5][4] → G[3][4]

8. E와 G가 같은지 비교

	Arrays.deepEquals(E, G) 같은 방법으로 E와 G가 완전히 같은지 확인한다.
9. 2차원 배열을 테이블 형태로 출력한다 

 */

public class 실습_4_5_행렬연산 {
    public static void main(String[] args) {

    	/*
    	 * [목표1] A, B: 3명의 학생들의 5과목 점수를 담은 2차 배열 생성.
    	 * [목표2] 행렬의 합 연산 구현 C = A + B
    	 * [설명] 
    	 * 	- 행- 학생, 열- 5과목의 점수, 점수는 0 ~ 99 사이의 무작워 정수
    	 * 	- A와 B, C는 모두 같은 크기의 2차 배열
    	 * [단계 쪼개기]
    	 * 1. A, B 배열 생성: int[3][5];
    	 * 2. Random 클래스 인스턴스 생성: new Random();
    	 * 3. 반복문으로 배열의 각 요소에 램덤한 정수 할당: for문 중첩해보자!
    	 * 4. 반복문을 사용해서 행렬의 합연산: C[i][j] = A[i][j] + B[i][j];
		 */
    	int[][] A = new int[3][5]; // 3명의 학생들의 5과목 점수를 담은 배열
    	int[][] B = new int[3][5]; // A와 크기가 같은 배열
    	int[][] C = new int[3][5]; // A+B의 결과가 될 것
    	Random rd = new Random();
    	
    	
    	// for 확장문으로 했을 때, 원하는 결과가 안나옴 => 디버깅해보자!
    	for (int[] x : A) {
    		for (int y : x) {
    			y = rd.nextInt(100);
    			//System.out.print(y + ", "); // 랜덤한 y값은 잘 나옴
    		}
    	}
    	//System.out.println();
    	//System.out.println(Arrays.deepToString(A)); // [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
    	
    	
    	
    	// 3*5: 원하는 코드 A[i][j] 성분에 정수 할당 A[0][0], A[0][1], A[0][2], ...
    	for (int i = 0; i < A.length; i++) { // 행을 순회
    		for (int j = 0; j < A[i].length; j++) { // 각 행 별 열을 순회
    			A[i][j] = rd.nextInt(100);
    			B[i][j] = rd.nextInt(100);
    			C[i][j] = A[i][j] + B[i][j]; // C = A + B 행렬의 합연산
    		}
    	}
    	
    	System.out.println();
    	System.out.println("A: " + Arrays.deepToString(A));
    	System.out.println("B: " + Arrays.deepToString(B));
    	System.out.println("C = A + B => " + Arrays.deepToString(C));
    	
    	
    	/* 
    	 * [목표3] 2차 배열로 다양한 행렬의 연산을 구현해보자!
    	 * 	- D(int[5][4]) 생성: 과목별 프로젝트 점수
    	 * 	- 행렬의 곱: E = A * D
    	 *  - 전치 행렬: F = D의 전치행렬 (Transpose)
    	 *  - G = A * F(D의 전치행렬)
    	 *  - 대칭행렬: E == G 인지 비교
    	 *  - 2차원 배열을 테이블 형태로 출력
    	 *  
    	 * [필요한 지식] 
    	 * 	- Arrays.deepEquals(E, G) 같은 방법으로 E와 G가 완전히 같은지 확인한다.
    	 * 	- 
    	 * 
    	 * [단계 쪼개기]
    	 * 1. 5*4 2차 배녈 D 생성 (int[5][4])
    	 * 2. 행렬의 곱: (3*5) * (5*4)이므로 E의 크기는 3*4 
    	 * 		E[0][0] = A[0][0]*D[0][0] + A[0][1]*D[1][0] + .... + A[i][j]*D[j][i]
		 */
    	int[][] D = new int[5][4]; // 과목별 프로젝트 점수
    	int[][] E = new int[3][4]; // A*D 곱연산의 결과가 될 것
    	int[][] F = new int[4][5]; // F = D의 전치 행렬, 사이즈는 당연히 4*5
    	int ar = A.length;
    	int ac = A[0].length;
    	int dr = D.length;
    	int dc = D[0].length;
    	
    	// 5*4: D에 랜덤 점수를 요소로 넣기 : (0,0*0,0)+(0,1*1,0)+(0,2*2,0)+(0,3+3,0)+(0,4*4,0)+(0,5*5,0)
    	for (int i = 0; i < dr; i++) {
    		for (int j = 0; j < dc; j++) {
    			D[i][j] = rd.nextInt(100);
    		}
    	}
    	System.out.println("D: " + Arrays.deepToString(D));
    	
    	// 3*4 반복문: E에 요소 할당
    	for (int i = 0; i < ar; i++) { // A의 행을 순회: 0 ~ 2
    		for (int j = 0; j < dc; j++) { // D의 열을 순회: 0 ~ 3
    			
    			// 3*5 반복문: 각 요소별 곱연산 계싼
    			int value = 0;
    	    	for (int k = 0; k < ac; k++) { // A의 열을 순회: 0 ~ 4
    	    			value += A[i][k]*D[k][j];
    	    	}
    			
    	    	// E에 값 할
    			E[i][j] = value;
    		}
    	}
    	System.out.println("E = A * D => " + Arrays.deepToString(E));
    	
    	
    	
    	
    	// ================= [ 전치행렬: F = D의 전치행렬 ] ================= //
    	for (int i = 0; i < dr; i++) { // D의 행을 순회 0 ~ 4
    		for (int j = 0; j < dc; j++) { // D의 열을 순회 0 ~ 3
    			F[j][i] = D[i][j];
    		}
    	}
    	System.out.println("F = D의 전치행렬: " + Arrays.deepToString(F));
    	
    	
    	
    	
    	// ================= [ G = A × F ] ====================//
    	// 에러가 남
    	// A[3][5] × F[4][5] 인데?? [5][4]가 아닌데...? 
    	// [5][4]인 D를 복사해서 새로운 F2를 만들어서 곱연산 시작
    	// G = A × F2 => 3*5
    	int[][] F2 = new int[5][4];
    	int[][] G = new int[3][5];
    	
    	//D를 F2로 복사
    	for (int i = 0; i < dr; i++) {
    		for (int j = 0; j < dc; j++) {
    			F2[i][j] = D[i][j];
    		}
    	}
    	System.out.println("F2: " + Arrays.deepToString(F2));
    	
    	//배열 G에 요소 할당
    	for (int i = 0; i < ar; i++) { // 0 ~ 2
    		for (int j = 0; j < dc; j++) { // 0 ~ 3
    			int value = 0;
    			for (int k = 0; k < dr; k++) {
    				value += A[i][k]*F2[k][i];
    			}
    			G[i][j] = value;
    		}
    	}
    	System.out.println("G: " + Arrays.deepToString(G));
    	
    	
    	
    	
    	// ================= [ E와 G가 같은지 비교 ] ================= //
    	System.out.println("E와 G는 같은 행렬인가? " + Arrays.deepEquals(E, G));
    	System.out.println();
    	
    	
    	
    	
    	// ================= [ 2차원의 배열을 테이블 형태로 출력: A, ar, ac ] ================= //
    	System.out.println("[2차 배열을 테이블 형태로 출력]");
    	
    	// 테이블의 제일 위 테두리
    	for (int i = 0; i < ac; i++) {// 열의 개수만큼 찍기
    		if (i == (ac - 1))
    			System.out.print("〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
    		else
    			System.out.print("〓〓〓〓〓〓〓〓〓〓〓");
    	}
    	System.out.println();
    	
    	// 배열을 행렬 형태로 출력
    	for (int i = 0; i < ar; i++) {
    		String sLine = "";
    		
    		for (int j = 0; j < ac; j++) {
    			if (j == 0)
    				System.out.print("|\t" + A[i][j] + "\t|\t");
    			else if (j == (ac - 1))
    				System.out.println(A[i][j] + "\t|\t");
    			else
    				System.out.print(A[i][j] + "\t|\t");
    			
    			sLine += "ㅡ\tㅡ\t";
			}
    		
    		if (i != (ar - 1))
    			System.out.println(sLine);
    	}
    	
    	// 테이블의 제일 아래 테두리
    	for (int i = 0; i < ac; i++) {// 열의 개수만큼 찍기
    		if (i == (ac - 1))
    			System.out.print("〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
    		else
    			System.out.print("〓〓〓〓〓〓〓〓〓〓〓");
    	}
    	System.out.println();

    }
}
