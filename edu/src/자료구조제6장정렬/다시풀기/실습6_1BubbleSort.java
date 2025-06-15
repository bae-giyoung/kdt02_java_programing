package 자료구조제6장정렬.다시풀기;
/*
 * 버블 이동 - 교재 202, 그림 6-3, 6-4
 */
//6장 학습 목표: 코드 가독(판독) 훈련 - 변수 값을 추적: 소스 코드를 따라가면서 
import java.util.Random;

//버블 정렬(단순 교환 정렬) (버전 1)

import java.util.Scanner;

class 실습6_1BubbleSort {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
	 int x = a[idx1];
	 a[idx1] = a[idx2];
	 a[idx2] = x;
 }

 //--- 버블 정렬 ---//
 static void bubbleSort(int[] a, int n) {
	 int count = 0;
	 for(int i=0; i<a.length; i++) { // 배열의 크기가 N이라면 -> O(N) (코드에 변수 n이 있어서 N으로 표기)
		for(int j=i+1; j<a.length; j++) { // i보다 큰 인덱스의 요소들을 순회하며 검사, i == a.length-1일때는 들어오지 않음. -> O((N-1)/2)
			count++;
			if(a[i] > a[j])
				swap(a, a[i], a[j]);
		}
	 }
	 // 시간복잡도는 O(N*(N-1)/2) -> 결국 O(N*N)이 된다.
	 System.out.println("\n비교 횟수 = " + count);
 }
 
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 
 public static void main(String[] args) {
     
	 
	 
	 
 }
}
