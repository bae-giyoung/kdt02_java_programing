package com.ruby.java.ch08.innerClass;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		myList.print();
		
		myList.add("JAVA");
		myList.add("JSP");
		myList.add("Servlet");
		myList.print();
		
		myList.remove("JAVA");
		myList.remove("JSP");
		myList.remove("Servlet");
		myList.print();
		
		myList.add("JAVA2");
		myList.add("Servlet2");		
		myList.print();
		
	}

}
