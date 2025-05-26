
package com.ruby.java.ch13.generic;
/*
 * C4 - 도서관리시스템 - generic 적용 실습
 */
import java.util.ArrayList;

//Overflow 예외 클래스
class OverflowException extends RuntimeException { // 교재 553
	public OverflowException(String msg) {
		super(msg);
	}
}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {
	public UnderflowException(String msg) {
		super(msg);
	}
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
	
	public Book5(String title, String author, int publicationYear, String isbn) {
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
	public String getISBN() {
		return isbn;
	}
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public int compareTo(Book5 o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class CDBook implements MediaBook, Comparable<CDBook> {
	private String cdStory;
	private String artist;
	private String catalogNumber;
	
	public String getCdStory() {
		return cdStory;
	}
	public void setCdStory(String cdStory) {
		this.cdStory = cdStory;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getCatalogNumber() {
		return catalogNumber;
	}
	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}
	
	@Override
	public int compareTo(CDBook o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getISBN() {
		// TODO Auto-generated method stub
		return null;
	}

}
class USBBook implements MediaBook, Comparable<USBBook> {
	private String usbName;
	private int capacity;
	private String serialNumber;
	private static String mediaType = "USB";
	
	public USBBook(String usbName, int capacity, String serialNumber) {
		super();
		this.usbName = usbName;
		this.capacity = capacity;
		this.serialNumber = serialNumber;
	}
	
	public String getUsbName() {
		return usbName;
	}
	public void setUsbName(String usbName) {
		this.usbName = usbName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public static String getMediaType() {
		return mediaType;
	}
	public static void setMediaType(String mediaType) {
		USBBook.mediaType = mediaType;
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getISBN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(USBBook o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Library<T extends MediaBook> {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<T> items;

	public Library() {
		super();
		this.items = new ArrayList<T>(CAPACITY);
	}

	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(T item) {
		if (items.size()>=CAPACITY) {
			throw new OverflowException("===== [add 실패]: 최대 등록 용량 초과");
		}
		items.add(item);
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public T removeBook() {
		if (items.size()==0) {
			throw new UnderflowException("===== [remove 실패]: 등록된 도서가 없음");
		}
		T item = items.get(items.size() - 1);
		items.remove(items.size() - 1);
		return item;
	}

	public void printBooks(String msg) {
		for(int i = 0; i < items.size(); i++) {
			System.out.println("제목: " + items.get(i).getTitle() + ", ISBN: "+items.get(i).getISBN());
		}
	}

	public void sortBooksByTitle() {
		items.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}

	public void sortBooksByISBN() {
//		items.sort((b1, b2)-> Integer.parseInt(b1.getISBN()) - Integer.parseInt(b2.getISBN()));
		items.sort((b1, b2) -> {
			int i1 = Integer.parseInt(b1.getISBN());
			int i2 = Integer.parseInt(b2.getISBN());
			
			if(i1 == i2) return 0;
			if(i1 < i2) return -1;
			return 1;
			
		});
	}

	public T searchBookByTitle(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (title.equals(items.get(i).getTitle())) {
				return items.get(i);
			}
		}
		return null;
	}
}
public class 실습13_C4_generic_실습과제 {
	public static void main(String[] args) {
		Library<Book5> library = new Library<>();

		// 5개의 Book 객체 초기화
		Book5 book1 = new Book5("자바", "강감찬", 1995, "12");
		Book5 book2 = new Book5("파이썬", "이순신", 2008, "9");
		Book5 book3 = new Book5("C#", "을지문덕", 2008, "8");
		Book5 book4 = new Book5("자료구조", "연개소문", 1994, "45");
		Book5 book5 = new Book5("리액트", "김춘추", 1999, "7");
		Book5 book6 = new Book5("스프링", "홍길동", 2025, "99");
		// 예외 처리를 적용한 책 추가 및 삭제
		try {
			library.addBook(book1);
			library.addBook(book2);
			library.addBook(book3);
			library.addBook(book4);
			library.addBook(book5);
			library.addBook(book6);

			// 도서관의 용량을 초과하여 책을 추가 (예외 발생)
			Book5 book7 = new Book5("SQL", "이기자", 2024, "34");
			library.addBook(book7); // 이 부분에서 OverflowException 발생
		} catch (OverflowException e) {
			System.out.println(e.getMessage());// OverflowException 생성시 전달된 메시지 출력
			//e.printStackTrace();
		}
		
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

		try {
			// 책 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제

			// 빈 도서관에서 책을 삭제 (예외 발생)
			library.removeBook(); // 이 부분에서 UnderflowException 발생
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
		}

		// 최종 도서 목록 출력
		library.printBooks("\n최종 도서 목록:");
	}
}