package day1;

import java.util.Arrays;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		/*[목표]
		 *정수 sNum와 eNum가 주어질 때, 
		 *sNum부터 eNum까지의 숫자를 
		 *차례로 담은 배열을 return하도록 solution 함수를 완성해주세요. 
		 * 조건: 0 <= sNum <= eNum <= 100
		 */

		// [문제 풀이1]
		// 단계 나누기 언습
		// 목표 확인: sNum에서 eNum까지의 숫자를 차례로 담은 배열을 return하는 함수 만들기
		// input: sNum, eNum
		// output: [sNum, sNum+1, sNum+2, ..... , eNum]
		// 조건: 0 <= sNum <= eNum <= 100
		// (메모): 위의 조건이 없었다면 sNum과 eNum의 크기를 비교후 시작 숫자 끝 숫자를 변경 했어야 함.
		// 단계1: sNum, eNum 입력 받음
		// 단계2: 배열 arr 선언 및 초기화, 사이즈는 sNum ~ eNum 사이의 정수의 개수
		// 단계3: 배열의 사이즈만큼 순회
		// 단계4: sNum부터 시작해서 1씩 증가하며 배열의 요소로 할당
		// 단계5: 배열 arr 리턴
		// 필요한 것: 배열 변수, 배열의 사이즈, 순회 구문;
		
		System.out.println(Arrays.toString(solution(10, 20)));
		System.out.println(Arrays.toString(solution(0, 0)));
		System.out.println(Arrays.toString(solution(99, 100)));
		
	}
	
	public static int[] solution (int sNum, int eNum) {
		int size = eNum - sNum + 1;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sNum + i;
		}
		return arr;
	}
	
	
	
	// [다시 단계 나누기 연습: 의사 코드]
	// 목표: sNum ~ eNum 사이의 정수를 차례로 담은 배열을 생성 후 리턴
	// input: 정수 sNum, 정수 eNum , (조건: 0<=sNum<=eNum<=100)
	// output: [sNum, sNum+1, sNum+2, ... , eNum] (int[] 배열)
	// 단계: 배열의 사이즈 계산. 사이즈 == (eNum - sNum + 1)
	// 단계: 배열 생성과 사이즈 설정.
	// 단계: 반복문으로 순회, 배열의 사이즈만큼
	// 단계: 정수를 배열의 요소로 순차적으로 할당 arr[i] = sNum + i;
	// 단계: 반복문 종료 후 배열 반환
	// 예외 없음: sNum과 eNum의 조건이 명확함

	// 구체적 출력 예시
	// input: 1, 5
	// output: [1, 2, 3, 4, 5]
	
	
	// [다시 단계 나누기 연습2: 의사 코드 더 간단하게]
		// 목표: 정수 sNum ~ 정수 eNum 사이의 정수를 차례로 담은 배열을 생성 후 리턴
		// input: 정수 sNum, 정수 eNum
		// output: [sNum, sNum+1, sNum+2, ... , eNum] (int[] 배열)
	
		// 조건: 0<=sNum<=eNum<=100
		// 예외 상황: 예외 없음. sNum > eNum일 경우가 없음.
	
		// 1. 배열의 길이 = eNum - sNum;
		// 2. 배열 생성: int[배열의 길이];
		// 3. 반복문 0부터 배열의 길이만큼 실행: arr[i] = sNum + i;
		// 4. 배열 반환

		// 구해야 할 것: 배결의 길이, 배열 인덱싱 및 재할당
	
		// 구체적 출력 예시
		// input			output
		// 1, 5 		[1, 2, 3, 4, 5]
		// 0, 0 		[0]
		// 99, 100		[99, 100]
        
        
}
