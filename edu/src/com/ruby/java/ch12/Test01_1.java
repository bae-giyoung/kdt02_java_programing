package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Test01_1 {

	public static void main(String[] args) {
		try(FileInputStream fi = new FileInputStream("a.txt");
				FileOutputStream fo = new FileOutputStream("b.txt");) { // Stream 계열은 1바이트 단위로 읽는다. (영여는 1글자가 1바이트, 한글은 2~3바이트)
			int c = 0;
			while((c = fi.read()) != -1) {
				System.out.println(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-".repeat(10));
		
		try(FileReader fr = new FileReader("tt.txt")) { // Reader/Writer 계열은 1글자 단위로 읽는다. 문자 파일 다룰 때 
			int c = 0;
			while((c = fr.read()) != -1) {
				System.out.println(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
