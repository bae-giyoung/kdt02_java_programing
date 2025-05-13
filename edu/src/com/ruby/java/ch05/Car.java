package com.ruby.java.ch05;

public class Car {
	
	// 필드
	String manufacturer; // 제조사
    String model;        // 모델명
    double weight;       // 차중량 (kg)
    int length;          // 전장(mm)
    int width;           // 전폭(mm)
    int speed;           // 속도
    
    
//    C-세그먼트 (준중형, 소형 패밀리카) > 4,200mm ~ 4,600mm > 약 1,750mm > 현대 아반떼, 기아 K3, 폭스바겐 골프, 도요타 코롤라
//    D-세그먼트 (중형차, 패밀리 세단) > 4,600mm ~ 4,900mm > 약 1,800mm ~ 1,850mm > 현대 쏘나타, 기아 K5, BMW 3시리즈, 벤츠 C클래스
//    E-세그먼트 (대형차, 고급 세단) > 4,900mm ~ 5,100mm > 약 1,850mm ~ 1,900mm > 현대 그랜저, 기아 K8, BMW 5시리즈, 벤츠 E클래스
//    F-세그먼트 (초대형차, 플래그십 세단) > 5,100mm 이상 > 1,900mm 이상 > 제네시스 G90, 벤츠 S클래스, BMW 7시리즈, 아우디 A8    

    
    // 전장 기준으로 차급 세그먼트 분류
    String getSegment() {
    	if (this.length < 4200) {
            return "B-세그먼트 (소형차)";
        } else if (this.length < 4600) {
        	return "C-세그먼트 (준중형, 소형 패밀리카)";
        } else if (this.length < 4900) {
        	return "D-세그먼트 (중형차, 패밀리 세단)";
        } else if (this.length < 5100) {
        	return "E-세그먼트 (대형차, 고급 세단)";
        } else {
        	return "F-세그먼트 (초대형차, 플래그십 세단)";
        }
    }
    
    // 과속 여부 판단 메소드
	void checkSpeeding(int speedLimit) {
	    if (speed > speedLimit) {
	        System.out.println("과속 경고!");
	    } else {
	        System.out.println("정상 주행");
	    }
	}
	        // 과속 여부 판단 메소드
	void checkSpeeding() {
	    if (speed > 60) {
	        System.out.println("과속 경고!");
	    } else {
	        System.out.println("정상 주행");
	    }
	}
	
	// toString() 메소드 재정의
    @Override
    public String toString() {
        return "제조사= " + manufacturer + ", 모델= " + model + ", 중량= " + weight + ", 전장= "+length+", 전폭= "+width+", 속도= "+speed;
    }
    
	

	public Car(String manufacturer, String model, double weight, int length, int width, int speed) {
		//super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.speed = speed;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
