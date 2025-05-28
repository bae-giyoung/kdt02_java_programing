package edu.test;

// 그냥 문제 풀어보기
public class p1 {

    public static int solution(int a, int b) {
        // input a,b
        // output a(+)b와 2*a*b 중 더 큰 값 리턴
        // 같으면 a(+)b 리턴 => 같은 값이면 그냥 하나를 리턴하라는 뜻
        // a와 b가 10진수로 몇 자리수인지 계산
        int acc1 = 0; // 덧셈의 항등원으로 설정!
        int acc2 = 2 * a * b;
        
        int base = 1; // 10진수의 base
        int[] aNums;
        int[] bNums;
        int ac = 0;
        int bc = 0;
        
        while (a / base >= 1) { // 정수/10의거듭제곱이 0(1이하의 소수)가 될때까지 반복, 각 자리의 숫자를 구하고, count로 자리수 구하기 
            base *= 10; // 10의 거듭제곱 1, 10, 100 ...
            ac++; // 최종 자리수 계산, 기본 1
        }
        base /= 10;
        
        aNums = new int[ac]; // 각 자리수 배열에 넣기, 순서대로! 1, 10, 100 ...
        for (int i = 0; i < ac; i++) { // 자리수 만큼 반복
        	aNums[i] = a / base; // 큰 자리수부터 1의 자리까지!
        	a %= base;
            if (base != 1) base /= 10; // base는 다시 1까지 100, 10, 1 ...
        }
        
        base = 1;
        while (b / base >= 1) {
        	base *= 10; // 10의 거듭제곱 1, 10, 100 ...
            bc++; // 최종 자리수 계산
        }
        base /= 10;
        
        bNums = new int[bc];
        for (int i = 0; i < bc; i++) {
        	bNums[i] = b / base; // 큰 자리수부터 1의 자리까지!
        	b %= base;
            if (base != 1) base /= 10;
        }
        
        // base를 다시 최종 자리수까지 연산
        for (int i = 0; i < (ac +bc); i++) {
            if (i != 0) base *= 10;
        }
        
        // a(+)b 연산, 최종 자리수 ac + bc
        for (int i = 0; i < (ac + bc); i++) {
            if (i < ac) {
                acc1 += aNums[i] * base;
            } else {
                acc1 += bNums[i - ac] * base;
            }
            base /= 10; // 차수? 계속 내림
        }
        
        System.out.println(acc1 + " " + acc2);
        
        return acc1 >= acc2 ? acc1 : acc2;
        
    }
	
	public static void main(String[] args) {
		int s1 = solution(9,12);
		int s2 = solution(101,12);
		int s3 = solution(5090,2030);
		
	}
	
	// 그냥 숫자로 풀어봤는데, 다른 방법이 있을 것 같다....... 추후 다시 풀기!!!!!!

}
