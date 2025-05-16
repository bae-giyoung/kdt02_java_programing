package com.ruby.java.ch07.abstraction;

public interface Messenger { // 인터페이스 역시 인스턴스를 생성할 수 없다!
	
	// int MIN_SIZE = 1; 이렇게 선언해도 컴파일러가 자동으로 public static final을 추가해줌!
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 104857600;
	
	public abstract String getMessage(); // 추상 클래스 abstract를 안붙여도 자동으로 컴파일러가 추가해줌
	
	public abstract void setMessage(String msg);
	
	public default void setLogin(boolean login) {
		log();
		if(login) {
			System.out.println("로그인 처리합니다.");
		} else {
			System.out.println("로그아웃 처리합니다.");
		}
	}
	
	public static void getConnection() {
		System.out.println("network에 연결합니다.");
	}
	
	private void log() { // !!!!!
		System.out.println("start job!");
	}
	
	// 그냥 Getter Setter 궁금증
	// Getter 이렇게 만들 수 있지만, 인터페이스의 필드는 무조건 public static final이기 때문에 인터페이스명.필드명 이렇게 접근하는 것이 합리적이다!
	public static int getMIN_SIZE() { // Getter 사용 하지 말것!
		return MIN_SIZE;
	}
	
	// Setter는 사용할 수 없음! 인터페이스의 필드는 무조건 public static final이기 때문에 Setter는 안됨.
}


