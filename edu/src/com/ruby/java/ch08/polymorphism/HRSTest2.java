package com.ruby.java.ch08.polymorphism;

// 클래스 default: 같은 패키지 안에서만 접근 가능
// 클래스 private: 내 클래스 안에서만 접근 가능
// 클래스 public: 어디서나 접근 가능

public class HRSTest2 {
	
	// [다형성]: "하나의 타입에 여러 객체를 대입할 수 있다." 상속 관계에서는 부모 다입의 변수에 모든 자식 객체를 대입할 수 있다.
	public static void calcTax(Employee e) {
		
		if (e instanceof Salesman) {
			Salesman s = (Salesman)e;
			s.annual_sales = 6500000;
			System.out.println("Salesman입니다. " + s.annual_sales);
			
		} else if (e instanceof Manager) {
			Manager m = (Manager)e;
			m.num_team = 5;
			System.out.println("Manager입니다. " + m.num_team);
			
		} else if (e instanceof Consultant) {
			Consultant c = (Consultant)e;
			c.num_project = 35;
			System.out.println("Consultant입니다. " + c.num_project);
			
		} else {
			System.out.println("Employee입니다.");			
		}
		
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
		calcTax(s); // type Salesman
		calcTax(c); // type Consultant
		calcTax(d); // type Director
		
		
		
	}
	
	
	
	
	
}
