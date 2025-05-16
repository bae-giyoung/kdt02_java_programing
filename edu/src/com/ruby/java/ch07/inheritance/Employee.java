package com.ruby.java.ch07.inheritance;

public class Employee extends Person {
	private String dept;
	
	public Employee() {
		super();
		System.out.println("Employee 생성자 실행");
	}
	
	public Employee(String name, int age, String dept) {
		super(name, age); // super(null, 0)
		this.dept = dept;
		System.out.println("Employee 생성자 실행");
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept (String dept) {
		this.dept = dept;
	}
	
	@Override // @Override를 사용하고 사용하지 않고의 차이는 무엇일까? 지금 코드에서는 변화가 없는데?
	public String toString() {
		//return name + " : " + age + " : " + dept; 
		// 오류가 뜨는 이유! 부모 클래스의 private 메서드인데 외부(자식 클래스)에서 접근하려고 했기 때문!
		// => Setter 사용해야함!
		// => 그렇다면 부모 클래스의 객체 인스턴스는 따로 만들어지고, 자식 클래스는 어떤 방법으로 그것을 참조하고 있는 것일까? 내부 메커니즘?
		
		//return getName() + " : " + getAge() + " : " + dept; // 방법1 getName()과 this.getName() 이 부분에 대해 생각해보기!
		return super.toString() + " : " + dept;
	}
	
}
