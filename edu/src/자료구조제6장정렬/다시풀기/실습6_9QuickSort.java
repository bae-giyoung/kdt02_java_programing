package 자료구조제6장정렬.다시풀기;

import java.util.Random;
import java.util.Scanner;

class 실습6_9QuickSort {
	static int count = 0;
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 퀵 정렬 ---//
 static void quickSort(int[] a, int left, int right) {

     int pl = left;                   // 왼쪽 커서
     int pr = right;                  // 오른쪽 커서
     int x = a[(pl + pr) / 2];        // 피벗(가운데 요소)
     System.out.printf("a[%d] ~ a[%d]: {", left, right);
     for (int i = left; i < right; i++)
    	 System.out.printf("%d, ", a[i]);
     System.out.printf("%d}\n", a[right]);

     // 무한 재귀로 터진 코드! 재귀를 사용할때 주의할 점!
     do {
    	 // partition과 다르게..... pivot과 같은 값이 왼쪽 그룹과 오른쪽 그룹에 모두 들어있어도 정렬에는 아무 문제 없는 것 같다! 
    	 while(pl < a.length && a[pl] <= x) pl++;
    	 while(pr >= 0 && a[pr] > x) pr--; // pr >= 0 -> 방어 조건 필요 없음!
    	 
    	 if(pl <= pr) swap(a, pl++, pr--); // pr < 0 이하이거나 pl >= a.length인 경우는 여기 안들어옴!
     } while(pl <= pr);
     
    // System.out.println("pl = " + pl + ", pr = " + pr); 
     if (left < pr) quickSort(a, left, pr); // a[left] ~ a[right]가 전부 같은 요소이거나 pivot보다 전부 작은 값일 때 => left, pr이 모두 변하지 않았기 때문에 재귀함수가 콜스택에 계속 쌓여서 터짐! -> 결국 교재 코드대로 하거나, 3-way-partitioning으로 해야 할 듯! 
     if (pl < right) quickSort(a, pl, right);
     // left == pr, left == right이면, 즉 최종적으로 요소가 1개이면 재귀가 끝남

 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("배열을 나눕니다.");
     //System.out.print("요솟수: ");
     //int nx = stdIn.nextInt();
     //int[] x = new int[nx];
     int nx = 9;
//     int []x = {1,8,7,4,5,2,6,3,9};
//     int []x = {5,8,5,4,5,5,6,3,5};
     int []x = {2,2,2,2,5,5,6,3,5};

      Random rand = new Random(42);

//      for (int i = 0; i < nx; i++) {
//     	x[i] = rand.nextInt(999);
//      }
    // */
     //int []x = {5,7,1,4,6,2,3,9,8};
     System.out.println("quick 정렬전");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
     System.out.println();

     quickSort(x, 0, nx-1);            // 배열 x를 퀵정렬
     System.out.println("비교횟수= " + count);
     System.out.println("quick 정렬후:");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
