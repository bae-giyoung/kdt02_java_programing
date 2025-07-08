package 자료구조제6장정렬.다시풀기;

import java.util.Random;

//배열을 나눔

import java.util.Scanner;

public class 실습6_8Partition {

 //--- 배열 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 배열을 나눔 ---//
 static void partition(int[] a, int n) {// 정렬이 아니고, 배열을 pivot을 기준으로 나누는 단계!
     int pl = 0;        // 왼쪽 커서
     int pr = n - 1;    // 오른쪽 커서
     int x = a[n / 2];  // 피벗(가운데 요소)

     do {// 기저조건에 배열의 값 사용할 때는 인덱스 검증을 꼭 해주자!!!!!!
    	 
         while (pl < n && a[pl] <= x) pl++;// 왼쪽 커서를 먼저 움직이고 왼쪽 커서가 가리키는 값이 피벗보다 크면 멈춤
         while (pr >= 0 && a[pr] > x) pr--;// 그 다음 오른쪽 커서를 움직이고 오늘쪽 커서가 가리키는 값이 피벗보다 작거나 같으면 멈춤
         
         if (pl <= pr) // 왼쪽 커서가 가리키는 값 <= 으른쪽 커서가 가리키는 값 이면 서로의 값 교환
             swap(a, pl++, pr--);// 교환 완료 후 각각의 커서 옮겨줌
         
     } while (pl <= pr);

     System.out.println("피벗의 값은 " + x + "입니다.");

     System.out.println("피벗 이하 그룹 ");
     for (int i = 0; i <= pl - 1; i++)              // a[0] ～ a[pl - 1]
         System.out.print(a[i] + " ");
     System.out.println();

     // 피벗과 일치라는 요소가 여러개 중복으로 있을 경우 -> 정렬이 아니기 때문에 피벗과 같은 그룹은 pr, pl로 구할 수 없는 것 같다!

     System.out.println("피벗 초과 그룹 ");
     for (int i = pr + 1; i < n; i++)              // a[pr + 1] ～ a[n - 1]
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
    int []x = {1,8,5,5,5,5,5,3,9};
    //int []x = {5,8,5,5,1,5,5,3,9};
    //int []x = {1,8,5,5,9,5,5,3,9};
    //int []x = {1,8,5,5,8,5,5,3,9};
    //int []x = {5,5,5,5,5,5,5,5,5};

     //Random rand = new Random(42);

     //for (int i = 0; i < nx; i++) {
//    	x[i] = rand.nextInt(999);
     //}
     for (int n: x)
    	 System.out.print(" " + n);
     System.out.println();
     partition(x, nx);                // 배열 x를 나눔
 }
}
