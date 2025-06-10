package 자료구조제5장재귀알고리즘;
/*
 * 실습 5-1 : 팩토리얼 값을 재귀적으로 구함 - 직접 입력하여 실습
 * recursive relation을 이해
 */

import java.util.Scanner;

class 실습5_1Factorial {
 //--- 음이 아닌 정수 n의 팩토리얼 값을 반환 ---//
 static int factorial(int n) {
//     if (n > 0) {
//    	 System.out.println("return " + n + " * factorial(" + n + " - 1);");
//         return n * factorial(n - 1); // n! = n * (n-1)!
//     }
//     else {
//    	 System.out.println("return 1");
//         return 1;
//     }
	 // 위를 한줄로 코딩: 삼항 연산자로 한 줄 코딩
	 return (n > 0) ? n * factorial(n - 1) : 1;
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.print("정수를 입력하세요 : ");
     int x = stdIn.nextInt();

     System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
 }
}