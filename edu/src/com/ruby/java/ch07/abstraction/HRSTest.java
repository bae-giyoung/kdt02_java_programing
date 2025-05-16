package com.ruby.java.ch07.abstraction;

// 추상 메서드는 인스턴스를 생성할 수 없다!! => 그렇다면 상속받은 클래스에서 인스턴스를 만들때 super()은 어떻게 되는 것일까?
abstract class Employee { // 추상 클래스는 하나 이상의 추상 메서드를 가진 클래스
	String name;
	int salary;
	
	public abstract void calcSalary(); // 추상 메서드
	public abstract void calcBonus();
}

class Salesman extends Employee { // The type Salesman must implement the inherited abstract method Employee.calcSalary()
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 팀 성과 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 2");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager {

	@Override
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 6");
	}
	
}

public class HRSTest {
	
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		//Manager m = new Manager(); // 오류! abstract 클래스라 인스턴스를 생성할 수 없다!
		Director d = new Director();
		
		s.calcSalary();
		c.calcSalary();
		d.calcSalary();
		
		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
		
	}
	
	
	
	
	
}
