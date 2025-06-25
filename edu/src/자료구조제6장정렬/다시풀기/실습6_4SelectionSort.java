package 자료구조제6장정렬.다시풀기;
//최소가 되는 min을 select이므로 straight selection sort이다 
import java.util.Random;

//단순 선택 정렬 6.3

import java.util.Scanner;

public class 실습6_4SelectionSort {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
 }

 //--- 단순 선택 정렬 ---//
 static void selectionSort(int[] a, int n) {
	 int count = 0;
     for(int i=0; i<n-1; i++) {
    	 int min = i;
    	 for(int j=n-1; j>i; j--) {
    		 count++;
    		 if(a[min] > a[j]) {
    			 min = j;
    		 }
    	 }
    	 swap(a, min, i);
     }
     System.out.println("\n비교횟수 = " + count);
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("단순 선택 정렬");
     System.out.print("요솟수: ");
     int nx = stdIn.nextInt();
     int[] x = new int[nx];

     Random rand = new Random(42);

     for (int i = 0; i < nx; i++) {
    	x[i] = rand.nextInt(999);
     }
     System.out.println("정렬전:");
     showData(x);
     selectionSort(x, nx);            // 배열 x를 단순선택정렬

     System.out.println("정렬후:");
     showData(x);
 }
}
