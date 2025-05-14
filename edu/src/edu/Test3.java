package edu;

import java.util.Scanner;

// 객체 생성을 위한 클래스
class Armor {
	String name;
	int height;
	int weight;
	String color;
	boolean isFly;
	
	// 이륙할때 실행할 것! 클래스 메서드로 해보자!
	static void takeOff() {
		System.out.println("Armor: 이륙합니다!");
	}
	
	// 착륙할 때 실행할 것! 정적 메서드로 해보자! 인스턴스 메서드로 해야 할 때는 어떤 경우일까?
	static void land() {
		System.out.println("Armor: 착륙합니다. ");
	}
	
	// 레이저를 쏘는 기능!
	static void shootLaser() {
		System.out.println("Armor: 개체를 타격하겠습니다.");
	}
	
	// 미사일을 쏘는 기능!
	static void launchMissile() {
		System.out.println("Armor: 미사일 타격을 시작하겠습니다.");
	}
	
	// 입력 받은 명령을 실행하는 기능!
	static void executeOrder (String order) {
		
		System.out.println(order);
		
		if (order.equals("이륙")) {
			takeOff();
		} else if (order.equals("착륙")) {
			land();
		} else if (order.equals("레이저")) {
			shootLaser();
		} else if (order.equals("미사일")) {
			launchMissile();
		} else {
			System.out.println("올바른 명령어를 입력해 주세요.");
		}
	}
}

public class Test3 {

	public static void main(String[] args) {
		Armor armor = new Armor();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("명령어를 입력하세요. (이륙, 착륙, 레이저, 미사일)");
		System.out.print("입력: ");
		
		String order = sc.next();
		
		armor.executeOrder(order);
		
	}

}
