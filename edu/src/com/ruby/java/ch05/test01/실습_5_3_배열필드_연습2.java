package com.ruby.java.ch05.test01;

public class 실습_5_3_배열필드_연습2 {
	static class Person {
	    // 필드 (private)
		/*
		 * name은 String, age는 int, weight는 float로 필드들을 private 선언
		 * subjects을 교육과목 private 배열
	     * years을 수강 연도 private 배열
	     * count 필드를 사용하여 수강 과목 증가시마다 ++count
		 */
	    // 필드
		private String name;
		private int age;
		private float weight;
		private String[] subjects;
		private int[] years;
		private int count;
		
	    // 메소드
	    void show() {
	        // 기본 정보 출력::name=**, age=**, weight=**로 출력
	    	System.out.println("name=" + name + ", age=" + age + ", weight=" + weight);
	       
	        // 교육과목 및 수강 연도 출력: while 문을 사용하여 교육과목과 수강연도를 출력
	    	System.out.print("교육과목(수강연도): ");
	    	while (count < subjects.length) {
	    		if (count != subjects.length - 1)
	    			System.out.print(subjects[count] + "(" + years[count] + "), ");
	    		else
	    			System.out.println(subjects[count] + "(" + years[count] + ")");
	    		count++;
	    	}
	    	
	    	count = 0;
	    	
	    }
	    
	    
	    // 세터
	    public void setName (String name) {
	    	this.name = name;
	    }
	    
	    public void setAge (int age) {
	    	this.age = age;
	    }
	    
	    public void setWeight (float weight) {
	    	this.weight = weight;
	    }
	    
	    public void setSubjects (String[] subjects) {
	    	this.subjects = subjects;
	    }
	    
	    public void setYears (int[] years) {
	    	this.years = years;
	    }
	    
	    
	    //과목, 수강연도를 매개변수로 전달받아 배열에 추가
		public void addSubjectYear(String subject, int year) {
			
			// 새로운 길이
			int size = this.subjects.length + 1;
			
			// 새로운 배열 생성
			String[] newSubjects = new String[size];
			int[] newYears = new int[size];
			
			// 새로운 배열에 요소 할당
			for (int i = 0; i < size; i++) {
				if (i != size - 1) {
					newSubjects[i] = this.subjects[i];
					newYears[i] = this.years[i];
				} else {
					newSubjects[i] = subject;
					newYears[i] = year;
				}
					
			}
			
			// 필드 재할당
			this.subjects = newSubjects;
			this.years = newYears;
			
		};
		
		
		//[오버라이딩] 과목, 수강연도를 매개변수로 전달받아 배열에 추가
		public void addSubjectYear(String[] subjects, int[] years) {
			// 예외: 연도를 교과목의 수와 다르게 입력할 경우
			
			// 새로운 길이 계산
			int s1 = this.subjects.length;
			int s2 = subjects.length;
			int size = s1 + s2;
			
			// 새로운 배열 생성
			String[] newSubjects = new String[size];
			int[] newYears = new int[size];
			
			// 배열에 값 할당
			for (int i = 0; i < size; i++) {
				if (i < s1) { // 기존 배열의 길이만큼
					newSubjects[i] = this.subjects[i];
					newYears[i] = this.years[i];
				} else { // 기존 배열의 길이를 벗어났을 때
					newSubjects[i] = subjects[i - s1]; // 다시 0부터 시작하게 하자!
					newYears[i] = years[i - s1];
				}
			}
			
			this.subjects = newSubjects;
			this.years = newYears;
		};
	}

	
    public static void main(String[] args) {
        // 첫 번째 객체 생성 및 초기화
        Person p1 = new Person();
        //다음 코드를 setter, addSubjectYear를 사용하여 수정
        p1.setName("홍길동");
        p1.setAge(25);
        p1.setWeight(60.56f);
        p1.setSubjects(new String[] {"Mathematics", "Science", "History"});
        p1.setYears(new int[] {2020, 2021, 2022});

        // 메소드 호출
        System.out.println("[p1출력]");
        p1.show();
        System.out.println();
        
        // addSubjectYear로 수정해보기!
        System.out.println("[p1출력] 메소드 사용해서 교육과목과 수강연도 수정");
        p1.addSubjectYear("Art", 2023);
        p1.show();
        System.out.println();
        
        // addSubjectYear(String[], int[])로 수정해보기!
        System.out.println("[p1출력] 메소드(배열인자) 사용해서 교육과목과 수강연도 수정");
        p1.addSubjectYear(new String[]{"Pilosophy","Literature","Physics"}, new int[]{2022,2023,2025});
        p1.show();
        System.out.println();
        
        
        // 두 번째 객체 생성 및 초기화 : 세터 사용 안함
        Person p2 = new Person();
        p2.name = "강감찬";
        p2.age = 55;
        p2.weight = 62.34f;
        p2.subjects = new String[] {"Literature", "Philosophy", "Physics"};
        p2.years = new int[] {2018, 2019, 2020};

        // 메소드 호출
        System.out.println("[p2출력]");
        p2.show();
    }


}