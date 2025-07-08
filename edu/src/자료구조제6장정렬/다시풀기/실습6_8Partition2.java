package 자료구조제6장정렬.다시풀기;
/* 3-way-partitioning
 * 
 * 1그룹: 피벗보다 작은 값들
 * 2그룹: 피벗보다 큰 값들
 * 3그룹: 피벗과 같은 값들
 * 
 * [pivot보다 작은 값] [pivot과 같은값] [pivot보다 큰 값]
 * 
 * 단계
 * 1. pivot과 a[i]를 비교
 * 		a[i] < pivot ===> a[i], a[lt] 교환 ===> i++, lt++
 * 		a[i] > pivot ===> a[i], a[gt] 교환 ===> gt--
 * 		a[i] == pivot ===> i++
 * 2. i <= gt까지 1을 반복
 * 
 */
import java.util.Random;

//배열을 나눔

import java.util.Scanner;

public class 실습6_8Partition2 {

	 //--- 배열 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
	 static void swap(int[] a, int idx1, int idx2) {
	     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
	 }
	
	 //--- 배열을 나눔 ---//
	 static void partition(int[] a, int n) {
		 // 3개의 커서 사용
	     int pl = 0;       		// 피벗보다 작은 값을 넣을 위치를 가리키는 포인터 -> 그렇기 때문에 배열의 첫 인덱스에서 시작해서 증가. -> 0 ~ pivot과 같은 그룹의 첫번째까지
	     int idx = 0;			// 현재 탐색 위치 -> 0 ~ pr+1이 될 때까지 증가.
	     int pr = n - 1;    	// 피벗보다 큰 값을 넣을 위치를 가리키는 포인터 -> 그렇기 때문에 배열의 마지막 인덱스에서 시작해서 감소. -> n-1 ~ pivot과 같은 그룹의 마지막 번째까지
	     int pivot = a[0];		// 피벗(보통 첫 번째 요소로 한다)
	
	     while(idx <= pr) {
	    	 // 피벗보다 작으면
	    	 if(idx < n && a[idx] < pivot) swap(a, idx++, pl++);
	    	 // 피벗보다 크면
	    	 else if(idx < n && pr > 0 && a[idx] > pivot) swap(a, idx, pr--);
	    	 // 피벗과 같으면
	    	 else idx++;
	     }
	     
	     System.out.println("pr: " + pl + ", idx: " + idx + ", pr: " + pr + "\n");
	     
	
	     System.out.println("피벗의 값은 " + pivot + "입니다.");
	
	     System.out.println("피벗 미만 그룹 ");
	     for (int i = 0; i <= pl-1; i++)              // a[0] ～ a[pl - 1]
	         System.out.print(a[i] + " ");
	     System.out.println();
	     
         System.out.println("피벗과 일치하는 그룹 ");
         for (int i = pl; i <= pr; i++)    // a[pl] ～ a[pr]
             System.out.print(a[i] + " ");
         System.out.println();
	
	     System.out.println("피벗 초과 그룹 ");
	     for (int i = pr+1; i < n; i++)              // a[pr+1] ～ a[n - 1]
	         System.out.print(a[i] + " ");
	     System.out.println();
	 }
	 
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	 }
	 
	 public static void main(String[] args) {
	     Scanner stdIn = new Scanner(System.in);
	
	    System.out.println("배열을 나눕니다.");
	    System.out.print("요솟수: ");
	    //int nx = stdIn.nextInt();
	    //int[] x = new int[nx];
	    int nx = 9;
	    //int []x = {1,8,7,4,5,2,6,3,9};
	    //int []x = {9,3,4,9,5,2,9,1,7};
	    int []x = {1,8,5,5,5,5,5,3,9};
	    //int []x = {5,8,5,5,1,5,5,3,9};
	    //int []x = {1,8,5,5,5,5,5,3,9};
	    //int []x = {1,8,5,5,9,5,5,3,9};
	    //int []x = {1,8,5,5,8,5,5,3,9};
	    //int []x = {5,5,5,5,5,5,5,5,5};
	
	     //Random rand = new Random(42);
	
	     //for (int i = 0; i < nx; i++) {
//	    	x[i] = rand.nextInt(999);
	     //}
	     for (int n: x)
	    	 System.out.print(" " + n);
	     System.out.println();
	     partition(x, nx);
	 }
}
