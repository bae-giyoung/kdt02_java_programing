package com.ruby.java.ch07.abstraction;

public class MessengerTest {

	public static void main(String[] args) {
		
		IPhonMessenger iphone = new IPhonMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		
		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);
		System.out.println();
		
		iphone.setLogin(true);
		iphone.getMessage();
		iphone.setMessage("hello");
		iphone.clearMessage();
		
		iphone.draw_textBox();
		iphone.draw_submitButton();
		
		System.out.println();
		
		galaxy.setLogin(true);
		galaxy.getMessage();
		galaxy.setMessage("hi");
		galaxy.changeKeyboard();
		
		galaxy.fileUpload();
		galaxy.fileDownload();

	}

}
