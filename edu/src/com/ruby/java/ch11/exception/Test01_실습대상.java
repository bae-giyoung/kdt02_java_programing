
package com.ruby.java.ch11.exception;

//catch된 객체를 출력하는 실습
public class Test01_실습대상 {

	public static void main(String[] args) {
		
		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		// at com.ruby.java.ch11.exception.Test01_실습대상.main(Test01_실습대상.java:9)
		int arr2[] = new int[3];
		//arr2[3] = 0;

		// "main" 실행 중 예외 "클래스이름" : 내용
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		// at com.ruby.java.ch11.exception.Test01_실습대상.main(Test01_실습대상.java:12)
		//int n = 10;
		//n = n / 0;
		
		
		// Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "st" is null
		// at com.ruby.java.ch11.exception.Test01_실습대상.main(Test01_실습대상.java:19)
		String st = "hello";
		//st = null;
		//System.out.println(st.length()); // 예외 발생 => JVM이 처리 - 종료

		try {
			String s = new String("java");
			int len = s.length();
			//s = null;
			//s.length(); // new NullPointerException() 객체 만들어서 => throw 던짐
			int arr[] = new int[3];
			arr[3] = 30; // new ArrayIndexOutOfBoundsException()
			System.out.println("OK");
		}
		// Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
		// Unreachable catch block for ArrayIndexOutOfBoundsException. It is already handled by the catch block for Exception
		// Unreachable catch block for NullPointerException. It is already handled by the catch block for Exception
		// Unreachable catch block for Exception. It is already handled by the catch block for Exception
//
		// 순서상 마지막에 와야 하는 이유는? upcasting은 가능, downcasting은 안됨
		/*
		* catch(Exception e) { //unreachable - 상위 클래스로서 모두 여기서 capture하기 때문이다.
		* System.out.println("Exception 처리"); }
		*/ 
		catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();// 교재 542
			System.out.println(e1.getMessage());// 교재 542
		} catch (NullPointerException e2) {
			e2.printStackTrace();
			System.out.print(e2.getMessage());
			System.out.println();
		} catch (Exception e) {// 순서상 마지막에 와야
			System.out.println("오류 발생 : " + e);// e.toString()
		} finally {// try block에서 할당된 자원의 해제 처리
			System.out.println("GOOD");
		}
		System.out.println("프로그램은 계속 실행");
	}
}