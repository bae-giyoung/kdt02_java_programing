package com.ruby.java.ch14;

/*
 * C5 - 도서관리시스템 - 람다식 적용 실습
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Overflow 예외 클래스
class OverflowException extends RuntimeException { // 교재 553

}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {

}

interface MediaBook {
	public String getTitle();
	public String getISBN();
}

//Book 클래스

class Book5 implements MediaBook, Comparable<Book5> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	
}

class CDBook implements MediaBook, Comparable<CDBook> {
	private String cdStory;
	private String artist;
	private String catalogNumber;
	
}
class USBBook implements MediaBook, Comparable<USBBook> {
	private String usbName;
	private int capacity;
	private String serialNumber;
	private static String mediaType = "USB";
	
}

class Library<T extends MediaBook> {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<T> items;

	
	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(T book) {
		
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public T removeBook() {
		
	}

	public void printBooks(String msg) {
		
	}

	public void sortBooksByTitle() {
		
	}

	public void sortBooksByISBN() {
		
	}

	public T searchBookByTitle(String title) {
		
	}
	public ArrayList<T> filterByYear(int year) { // 출판 연도에 따른 필터링
		return (ArrayList<T>) items.stream().filter(item-> Integer.parseInt(item.getISBN()) < year)
		 .collect(Collectors.toList());
		 }

}
public class 실습14_C5_람다식_실습과제 {
	public static void main(String[] args) {
		Library library = new Library();
        List<Book5> books = List.of(
                new Book5("자바", "강감찬", 1995, "2024"),
                new Book5("파이썬", "이순신", 2008, "2023"),
                new Book5("C#", "을지문덕", 2008, "2025"),
                new Book5("자료구조", "연개소문", 1994, "2000"),
                new Book5("리액트", "김춘추", 1999, "2007")
            );
		
		// 예외 처리를 적용한 책 추가 및 삭제
	    books.forEach(book -> {
            try { library.addBook(book); }
            catch (OverflowException e) { System.out.println(e.getMessage()); }
        });

	
		// 도서 목록 출력
        library.printBooks("\n현재 도서 목록:");

        // **제목 기준 정렬 및 출력**
        System.out.println("\n=== 제목 기준 정렬 ===");
        library.sortBooksByTitle();
        library.printBooks("제목 정렬 후:");

        // **ISBN 기준 정렬 및 출력**
        System.out.println("\n=== ISBN 기준 정렬 ===");
        library.sortBooksByISBN();
        library.printBooks("ISBN 정렬 후:");

        while (true) {
            try { library.removeBook(); }
            catch (UnderflowException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        library.printBooks("\n최종 도서 목록");
        System.out.println("\n출판 연도 기준 필터링(2008년 이전)");
        library.filterByYear(2008).forEach(System.out::println);
	}
}