package com.ruby.java.ch10.collection;

import java.util.ArrayList;
import java.util.Arrays;

//Book 클래스
class Book implements Comparable<Book>{
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s",
	            title, author, publicationYear, isbn);
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return title.compareTo(o.title);
	}


}

class OverflowException extends RuntimeException {
	public OverflowException() {
		super("더 이상 추가할 수 없습니다.");
	}
}

class UnderflowException extends RuntimeException {
	public UnderflowException() {
		super("더 이상 삭제할 수 없습니다.");
	}
}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>(CAPACITY);
	}

	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(Book book) {
		if (books.size() >= CAPACITY)
			throw new OverflowException();
		else
			books.add(book);
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	//public Book removeBook() {
	public Book removeBook(Book book) {
		if (books.size() == 0)
			throw new UnderflowException(); // throw를 하게 되면 return으로 메서드 종료가 되는 것일까? 그럼 else도 필요 없을 것 같은데?
		
		books.remove(book);
		return book; // 이렇게 해도 될까?
	}

	public void printBooks(String msg) {
		System.out.println(msg);
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
	}

	public void sortBooksByTitle() {
		// 람다식 모름: 실습9_1의 코드 참조: Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
		books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
		// books.sort(); // 이거는 왜 되는 것 처럼 보일까?
	}

	public void sortBooksByISBN() {
		books.sort((b1, b2) -> Integer.parseInt(b1.getIsbn()) - Integer.parseInt(b2.getIsbn()));
	}

	public Book searchBookByTitle(String title) {
		Book result = null;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().compareTo(title) == 0)
				result = books.get(i);
		}
		return result;
	}
}
public class 실습10장_컬렉션_C2_과제 {
	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		try {
			library.addBook(book1);
			library.addBook(book2);
			library.addBook(book3);
			library.addBook(book4);
			library.addBook(book5);
			// library.addBook(book5); // 예외 발생			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("======== 도서 삭제 실패: " + e.getMessage());
		}

		// 도서 목록 출력
		library.printBooks("\n[현재 도서 목록]:");

		library.sortBooksByTitle(); // 도서 목록 정렬
		// 최종 도서 목록 출력
		library.printBooks("\n\n[title 정렬후 최종 도서 목록]:");
		
		library.sortBooksByISBN(); // 도서 목록 정렬
		// 최종 도서 목록 출력
		library.printBooks("\n\n[Isbn 정렬후 최종 도서 목록]:");
		
		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		// 정렬된 도서 목록 출력
		Book foundBook = library.searchBookByTitle(searchTitle);
		System.out.println("\n[검색 결과]: " + foundBook);

		try {
			library.removeBook(book1); // 정상 삭제
			library.removeBook(book2); // 정상 삭제
			library.removeBook(book3); // 정상 삭제
			library.removeBook(book4); // 정상 삭제
			library.removeBook(book5); // 정상 삭제
			library.removeBook(book5); // 삭제 실패 (예외 발생)
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("======== 도서 삭제 실패: " + e.getMessage());
		}
		// 도서 목록 출력
		library.printBooks("\n\n[현재 도서 목록]:");
	}
}