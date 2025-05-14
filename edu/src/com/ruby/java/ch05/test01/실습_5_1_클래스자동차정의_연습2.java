package com.ruby.java.ch05.test01;


// [목표]
// [input]
// [output]


// 필드
//String manufacturer; // 제조사
//String model;        // 모델명
//double weight;       // 차중량 (kg)
//int length;          // 전장(mm)
//int width;           // 전폭(mm)
//int speed;           // 속도


//C-세그먼트 (준중형, 소형 패밀리카) > 4,200mm ~ 4,600mm > 약 1,750mm > 현대 아반떼, 기아 K3, 폭스바겐 골프, 도요타 코롤라
//D-세그먼트 (중형차, 패밀리 세단) > 4,600mm ~ 4,900mm > 약 1,800mm ~ 1,850mm > 현대 쏘나타, 기아 K5, BMW 3시리즈, 벤츠 C클래스
//E-세그먼트 (대형차, 고급 세단) > 4,900mm ~ 5,100mm > 약 1,850mm ~ 1,900mm > 현대 그랜저, 기아 K8, BMW 5시리즈, 벤츠 E클래스
//F-세그먼트 (초대형차, 플래그십 세단) > 5,100mm 이상 > 1,900mm 이상 > 제네시스 G90, 벤츠 S클래스, BMW 7시리즈, 아우디 A8    



class Car {
	// 필드
	String manufacturer; // 제조사
	String model;        // 모델명
	double weight;       // 차중량 (kg)
	int length;          // 전장(mm)
	int width;           // 전폭(mm)
	int speed;           // 속도
	
	
	// 전장 기준으로 차급 세그먼트 분류
	public String getSegment() {
		String segment = "";
		
		if (this.length > 5100)
			segment = "F-세그먼트 (초대형차, 플래그십 세단)";
		else if (this.length > 4900)
			segment = "E-세그먼트 (대형차, 고급 세단)";
		else if (this.length > 4900)
			segment = "D-세그먼트 (중형차, 패밀리 세단)";
		else if (this.length > 4900)
			segment = "C-세그먼트 (준중형, 소형 패밀리카)";
		else
			segment = "B-세그먼트";
			
		return segment;
	}
	
	
	// 과속 여부 판단 메소드
	public void isOverSpeed () {
		if (this.speed > 100)
			System.out.println("과속 경고!");
		else
			System.out.println("정상 속도입니다.");
	}
	
	// 과속 여부 판단 메소드 (오버로딩)
	public void isOverSpeed (int speedLimit) {
		if (this.speed > speedLimit)
			System.out.println("과속 경고!");
		else
			System.out.println("정상 속도입니다.");
	}
	
	// toString() 메소드 재정의
	@Override
	public String toString() {
		return "제도사= " + manufacturer + ", 모델= " + model + ", 차 중량(kg)= " + weight + ", 전장(mm)= " + length + ", 전폭(mm)= " + width + ", 속도= " + speed;
	}
	
	
	// 생성자
	public Car (String manufacturer, String model, double weight, int length, int width, int speed) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.speed = speed;
	}
	
}

public class 실습_5_1_클래스자동차정의_연습2 {

	public static void main(String[] args) {
		// 자동차 객체 생성
		Car car1 = new Car("Hyundai", "Sonata", 1400,4600,1800, 95);
        Car car2 = new Car("BMW", "M3", 1200, 4500, 1700, 110);
		
		// 도로별 제한 속도 설정
        int cityLimit = 50;  // 도심 제한 속도
        int highwayLimit = 100; // 고속도로 제한 속도
        
		// 과속 여부 확인
		System.out.println("[도심 주행 테스트]");
		car1.isOverSpeed(cityLimit);// 도심에서 주행
		car2.isOverSpeed(cityLimit);// 도심에서 주행
		car1.isOverSpeed();// method overloading
		car2.isOverSpeed();// method overloading
		System.out.println();
		
		
		System.out.println("[고속도로 주행 테스트]");
		// 고속도로에서 주행
		car1.isOverSpeed(highwayLimit);// 도심에서 주행
		car2.isOverSpeed(highwayLimit);// 도심에서 주행
		System.out.println();
		
		
		// 차량 객체 출력 + 차량 크기 분류
		System.out.println("차량 크기 분류:");
		System.out.println("[car1]");
		System.out.println(car1);
		System.out.println("car1의 세그먼트: " + car1.getSegment());
		System.out.println();
		
		System.out.println("[car2]");
		System.out.println(car2);
		System.out.println("car2의 세그먼트: " + car2.getSegment());
		System.out.println();
		

	}

}
