package com.ruby.java.ch10;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class SetTestLotto {

	public static void main(String[] args) {
		// == 사용자 입력
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> userNums = new HashSet<Integer>();
		System.out.println("로또 번호를 입력하세요.");
		while (userNums.size() < 7) {
			// 기존의 hashSet 사이즈 저장
			int oriSize = userNums.size();
			
			// 입력받아서 hasSet에 저장 
			System.out.print(userNums.size() + "번째 숫자 입력: ");
			int n = sc.nextInt();
			if (n > 45 || n < 0) {
				System.out.println("1 ~ 45 사이의 숫자를 입력하세요.");
				continue;
			}
			userNums.add(n);
			
			// 같은 값이 들어왔을 때
			if (userNums.size() == oriSize) {
				System.out.println("입력 실패: 중복되지 않는 값을 입력하세요.");
			}
		}
		
		// == 로또 번호 생성
		// 1. HashSet 만들기
		HashSet<Integer> hash = new HashSet<Integer>();
		
		// 2. 랜덤한 정수 생성 1 ~ 45
		Random rd = new Random();
		while (hash.size() < 7) {
			int n = rd.nextInt(45); // 시드 넘버
			hash.add(n);			
		}
		
		// == 사용자 입력값과 로또 번호 출력
		System.out.println("============== 입력 번호 ================");
		for (Integer unum : userNums) {
			System.out.print(unum + " + ");
		}
		System.out.println();
		
		System.out.println("============== 로또 번호 ================");
		for (Integer h : hash) {
			System.out.print(h + " + ");
		}
		System.out.println();
		
		// == 사용자가 입력한 값과 같은지 비교 후 결과 출력
		System.out.println("================ 결과 ==================");
		if (userNums.equals(hash))
			System.out.println("당첨: 축하합니다! 당첨되셨습니다!");
		else
			System.out.println("꽝: 다음 기회에");
		
	}

}
