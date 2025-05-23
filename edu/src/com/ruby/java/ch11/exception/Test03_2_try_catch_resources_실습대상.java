package com.ruby.java.ch11.exception;

//try - catch - resources
//try-catch-finally를 간단하게 사용하는 방법이다

//try catch resources를 사용하지 않는 경우
import java.io.FileInputStream;
import java.io.IOException;


public class Test03_2_try_catch_resources_실습대상 {
	public static void main(String[] args) {
		//try-catch-resources문
		try(FileInputStream fi = new FileInputStream("a.txt"))//547페이지 하단의 파일처리 
		{
			int c = fi.read();
			fi.read(null); //에러 발생시킨 것
			System.out.println((char) c);
//		} catch (IOException e) {
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		
		}
		
		System.out.println("정상실행");
	}
}
