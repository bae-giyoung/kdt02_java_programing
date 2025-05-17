package com.ruby.java.ch05;

public class 실습_5_3_배열필드 {
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
	       
	        // 교육과목 및 수강 연도 출력
	    	/*
	    	 * while 문을 사용하여 교육과목과 수강연도를 출력
	    	 */
	    	if (subjects == null || years == null) {
	    		System.out.println("출력 실패: 수강과목 또는 수강년도 정보가 없습니다.");
	    		return;
	    	}
	    	
	    	if (subjects.length != years.length) {
	    		System.out.println("출력 실패: 수강과목과 수강연도의 수가 다릅니다.");
	    		return;
	    	}
	    		
	    	int i = 0;
	    	System.out.print("교육과목(수강연도): ");
	    	while (i < count) {
	    		if (i == count - 1)
	    			System.out.println(subjects[i] + "(" + years[i] + ")");
	    		else
	    			System.out.print(subjects[i] + "(" + years[i] + "), ");
				i++;
		    }
		    
	    	
	    }
	    
	    public void setName(String name) {
	    	this.name = name;
	    	
	    }
	    
	    public void setAge(int age) {
	    	this.age = age;
	    }
	    
	    public void setWeight(float weight) {
	    	this.weight = weight;
	    }
	    
	    public void setSubjects (String[] subjects) {
	    	if (this.years != null) {
	    		if (this.years.length != subjects.length) {
	    			System.out.println("실패. 입력하려는 수강과목 배열의 길이를 맞춰주세요.");
	    			return;
	    		}
	    	}
	    	this.subjects = subjects;
	    	count = subjects.length;
	    }
	    
	    public void setYears (int[] years) {
	    	if (this.subjects != null) {
	    		if (this.subjects.length != years.length) {
	    			System.out.println("실패. 입력하려는 수강년도 배열의 길이를 맞춰주세요.");
	    			return;
	    		}
	    	}
	    	this.years = years;
	    }
	    
	    //과목, 수강연도를 매개변수로 전달받아 배열에 추가
		public void addSubjectYear(String subject, int year) {
			
			if (this.subjects == null) { // 기존의 subjects가 null인 경우
				
				this.subjects = new String[] {subject};
				this.years = new int[] {year};
				
			} else {
				
				int size = this.subjects.length + 1;
				
				String[] newSubjects = new String[size];
				int[] newYears = new int[size];
				
				for (int i = 0; i < size; i++) {
					if (i != size - 1) {
						newSubjects[i] = this.subjects[i];
						newYears[i] = this.years[i];
					} else {
						newSubjects[i] = subject;
						newYears[i] = year;
					}
				}
			
				this.subjects = newSubjects;
				this.years = newYears;
			}
			count++; // 수강 과목 수 증가
			
		};
		
		//[오버라이딩] 과목, 수강연도를 매개변수로 전달받아 배열에 추가
		public void addSubjectYear(String[] subjects, int[] years) {
			
			if (subjects.length != years.length) {
				System.out.println("교육과목(수강연도)가 추가 실패. 추가하려는 교육과목과 수강연도의 개수를 맞춰서 다시 시도해주세요.");
				return;
			}
			
			if (this.subjects == null) { // 기존의 subjects가 null인 경우
				
				this.subjects = subjects;
				this.years = years;
				count = subjects.length;
				
			} else {
			
				int s1 = this.subjects.length;
				int s2 = subjects.length;
				int size = s1 + s2;
				
				String[] newSubjects = new String[size];
				int[] newYears = new int[size];
				
				for (int i = 0; i < size; i++) {
					if (i < s1) {
						newSubjects[i] = this.subjects[i];
						newYears[i] = this.years[i];
					} else {
						newSubjects[i] = subjects[i - s1];
						newYears[i] = years[i - s1];
					}
				}
				
				this.subjects = newSubjects;
				this.years = newYears;
				count = size;
			}
			
		};
	}
	
	public static void main(String[] args) {
		Main.main(args);
	}

	public class Main {
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
	        
	        
	        // 두 번째 객체 생성 및 초기화
	        Person p2 = new Person();
	        p2.setName("강감찬");
	        p2.setAge(55);
	        p2.setWeight(62.34f);
	        p2.setSubjects(new String[] {"Literature", "Philosophy", "Physics"});
	        p2.setYears(new int[] {2018, 2019, 2020});

	        // 메소드 호출
	        System.out.println("[p2출력]");
	        p2.show();
	    }

	}
}
