package 자료구조제5장재귀알고리즘;

/*
 * 실습 5-3: 피보나치 수열을 간결한 코딩으로 해결
 * 삼항 조건 연산자를 사용한 대표적 사례로서 기억해야 함
 * f(n) = f(n-1) + f(n-2)
 * f(n) = f(n-1) + f(n-2) + f(n-3)를 구현하는 실습: 현재 코드를 수정하여 완료 
 */


import java.util.Scanner;

public class 실습5_1_2피보나치수열 {
// https://oeis.org/A000045
// 
 static int fibonacci(int n) {
	 //[두개를 더할 때]recursive 함수를 간결한 코딩으로 해결 - 학습 요점이다 
//   return (n > 1) ? fibonacci(n - 1) + fibonacci(n - 2) : 1;
     return (n > 1) ? fibonacci(n - 1) + fibonacci(n - 2) : n;
	 
 }
 static int notfibonacci(int n) {
	 //[세개를 더할 때] : f(n) = f(n-1) + f(n-2) + f(n-3), f(0)=0, f(1)=1, f(2)=2로 설정
	 return (n > 2) ? notfibonacci(n - 1) + notfibonacci(n - 2) + notfibonacci(n - 3) : n;
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.print("정수를 입력하세요 : ");
     int x = stdIn.nextInt();

     System.out.println(x + "의 피보나치 수열은 " + fibonacci(x) + "입니다.");
     System.out.println(x + "의 수열은 " + notfibonacci(x) + "입니다.");
 }
}
