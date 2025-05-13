package edu.test;

public class Armor2 {
	
	// private field: 클래스 내부에서만 접근 및 수정 가능, 하지만 Getter와 Setter로 외부에서 접근 가능.
	private String name;
	private int height;
	
	// public field: 클래스 외부에서 접근 가능!
	public int age;
	
	// private method: 클래스 내부에서만 사용
	private int aaa() {
		return 0;
	}
	
	// public method: 클래스 외부에서 사용 가능!
	public int bbb() {
		return 0;
	}
	
	// Getter Setter : 외부에서 private field에 접근, 수정할 수 있게 하는 메소드!!
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}	
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static void main(String[] args) {
		
		
		
		
		
		
		// 그냥 문법 연습, 나중에 지우기
		String str = "masterpiece of something";
		String b = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				return;
			else
				b += str.charAt(i);
		}
		System.out.println(b);
	}

}
