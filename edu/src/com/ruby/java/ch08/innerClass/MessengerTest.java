package com.ruby.java.ch08.innerClass;

public class MessengerTest {

	public static void main(String[] args) {
		
		Messenger test = new Messenger() {
			
			@Override
			public void setMessage(String msg) {
				System.out.println("test에서 메시지를 설정합니다.: " + msg);
			}
			
			public String getMessage() {
				return "test";
			}
		};
		
		System.out.println(test.getMessage());
		test.setMessage("Have a nice day!");

	}

}
