package com.ruby.java.ch08.polymorphism;

// 추상 메서드는 인스턴스를 생성할 수 없다!! => 그렇다면 상속받은 클래스에서 인스턴스를 만들때 super()은 어떻게 되는 것일까?
abstract class Employee { // 추상 클래스는 하나 이상의 추상 메서드를 가진 클래스
	String name;
	int salary;
	
	public abstract void calcSalary(); // 추상 메서드
	public abstract void calcBonus();
}

class Salesman extends Employee { // The type Salesman must implement the inherited abstract method Employee.calcSalary()
	int annual_sales; // 연간 판매 실척
	
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	int num_project; // 컨설팅 참여 수
	
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 팀 성과 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 2");
	}
}

class Manager extends Employee {
	int num_team; // 관리 팀 수
	
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
	
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
	}
}

class Director extends Manager {

	@Override
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 6");
	}
	
}

public class HRSTest {
	
	// [다형성]: "하나의 타입에 여러 객체를 대입할 수 있다." 상속 관계에서는 부모 다입의 변수에 모든 자식 객체를 대입할 수 있다.
	public static void calcTax(Employee e) {
		System.out.println("소득세를 계산합니다.");
	}
	
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
		
		// 다형성
//		calcTax(s); // type Salesman
//		calcTax(c); // type Consultant
//		calcTax(d); // type Director
		
		System.out.println(s.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		
		Salesman s2 = s;
		System.out.println(s2.toString());
		
		if (s.equals(s2)) {
			System.out.println("동일한 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
//		System.out.println(s.hashCode()); // hashCode는 무엇인가? => 메모리 주소를 JVM이 내부적으로 암호화 한 것?
		
		Object o; // Ctrl + Open Declaration 클릭 Object 클래스 소스 볼 수 있음.
		
		Salesman s1 = new Salesman();
		Employee s22 = new Salesman();
		Object s3 = new Salesman();
		
		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
		
		Object arr[] = new Object[6]; // 다형성
		
		arr[0] = s1;
		arr[1] = s22;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}
	
	
	
	
	
}
