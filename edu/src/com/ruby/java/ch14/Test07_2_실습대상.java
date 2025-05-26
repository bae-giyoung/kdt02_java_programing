//람다식 인자
package com.ruby.java.ch14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;

    public Student(String name, int korScore, int engScore, int mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }
    
    public String getName() {
    	return name;
    }
}

public class Test07_2_실습대상 {


	public static void main(String[] args) {
		ArrayList<Student> classRoom = new ArrayList<>();
		Collections.sort(null);
		//Comparator<Student> c = (s1, s2) -> s1.getName().compareTo(s2.getName());
		//Collections.sort(classRoom, c);
		Collections.sort(classRoom, (s1, s2) -> s1.getName().compareTo(s2.getName())); // Comparator<Student> c = (s1, s2) -> s1.getName().compareTo(s2.getName())

		
	}
}