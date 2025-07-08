package 자료구조제6장정렬.다시풀기;
/* Lamuto partition algorithm
 * 
 * 초기 상태
 * i: -1
 * j: 0 ~ n-2까지 포인터 이동하며 검사
 * pivot: 배열[n-1] 배열의 마지막 요소
 * 
 * 의사 코드 먼저 적어보기
 * 1. a[j] > pivot 이면 -> j 증가
 * 	  a[j] <= pivot 이면 -> i증가 -> a[i] a[j] 교환
 *    다음 탐색을 위해 j++ 커서 이동
 * 2. 기저 조건: j == n-1 일때 반복문 종료
 * 3. 마지막으로: 배열[i+1]와 pivot요소(배열[n-1])를 교환
 * 
 * 결과
 * a[0 ~ i]: pivot 이하 (pivot과 중복값이 있을 수 있음)
 * a[i+1]: pivot
 * a[i+2 ~ n-1]: pivot 초과
 */
import java.util.Random;

//배열을 나눔

import java.util.Scanner;

public class 실습6_8Partition3 {

	 //--- 배열 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
	 static void swap(int[] a, int idx1, int idx2) {
	     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
	 }
	
	 //--- 배열을 나눔 ---//
	 static void partition(int[] a, int n) {
		 // 3개의 커서 사용
	     int i = -1;
	     int j = 0;
	     int pivot = a[n - 1]; // 피벗(마지막 요소)
	
	     while(j < n-1) { // 피벗의 위치 전까지만 탐색하고, 마지막에 pivot을 적절한 위치로 이동시킨다.
	    	 
	    	 while(j < n-1 && a[j] > pivot) j++; // a[j]가 피벗보다 작거나 같을 때 탐색을 멈춤. j == n-1이면 비교하지 않는다.
	    	 if(j < n-1) // j == n-1이면 pivot이므로 swap하지 않는다.
	    		 swap(a, ++i, j++); // j=0, i=-1 => j=0, i=0 -> j=1, i=0, 첫 요소가 pivot보다 작거나 같은 경우에는 같은 0번째 요소가 swap됨
	     }
	     swap(a, i+1, n-1);
	     
	
	     System.out.println("피벗의 값은 " + pivot + "입니다.");
	
	     System.out.println("피벗 이하 그룹 ");
	     for (int k = 0; k <= i + 1; k++)              // a[0] ～ 피벗(a[i+1])
	         System.out.print(a[k] + " ");
	     System.out.println();

	     // 이 알고리즘 역시 pivot과 일치하는 그룹은 partition만으로는 찾을 수 없다. 정렬이 아니기 때문에.
	
	     System.out.println("피벗 초과 그룹 ");
	     for (int k = i + 2; k < n; k++)              // a[i+2] ～ a[n - 1]
	         System.out.print(a[k] + " ");
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
	    //int []x = {1,8,5,5,5,5,5,3,1};
	    //int []x = {5,8,5,5,1,5,5,3,5};
	    //int []x = {1,8,5,5,9,5,5,3,9};
	    //int []x = {1,8,5,5,8,5,5,3,1};
	    int []x = {8,8,8,8,8,8,8,8,5};
	
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
