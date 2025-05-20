package com.ruby.java.ch08.innerClass;


public class cha08_test_내부클래스구현 {
	private Node head;
	
	// 생성자
	public cha08_test_내부클래스구현() {
		head = null;
	}
	
	// 내부 클래스
	private class Node {
		private String data; // 초기값 null
		private Node link; // 초기값 null

		// 내부 클래스의 생성자
		public Node(String data) {
			this.data = data;
		}
	}
	
	// 리스트 추가 메서드 > add하는 알고리즘 > 자료구조 + 알고리즘 => 문제 해결을 위한 논리적 사고
	public void add(String data) {
		// 첫번째 수행인 경우 head가 null일때
		if (head == null) {
			head = new Node(data);
			System.out.println("첫 번째 add 수행: " + head.data);
			return;
		}
		
		// 두 번째 수행부터
		Node p = head; // head에서부터 시작
		while (p != null) { // p == null일 때, 반복문 종료
			if (p.link == null) {
				p.link = new Node(data);
				System.out.println("add 수행: " + p.link.data);
				return;
			}
			p = p.link;
		}
		
	}
	
	// 리스트 출력
	public void printList() {
		//printList() 결과는 A -> B -> C 등으로 출력한다
		// 그냥 출력하기
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			Node p = head;
			while(p != null) {
				System.out.println(p.data);
				p = p.link;
			}
		}
	}
	
	// 리스트 삭제 메서드
	public void delete(String data) {
		if (head == null)
			return;
		
		Node p = head;
		Node q = null;
		
		// 그 외
		while(p != null) {
			if (p.data.equals(data)) {
				// 첫 번째 요소를 삭제할 때
				if (p == head) {
					head = p.link;
					break;
				}
				
				// 두 번째 이상의 요소를 삭제할 때
				q.link = p.link; // 마지막 요소일 경우에는 null이 할당됨
				break;
			}
			q = p;
			p = p.link;
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cha08_test_내부클래스구현 myList = new cha08_test_내부클래스구현();
		myList.printList();

		System.out.println();
		System.out.println("======== 추가 실행 내역 =========");
		myList.add("JAVA");
		myList.add("HTML");
		myList.add("CSS");
		myList.add("Javascript");
		
		System.out.println();
		System.out.println("======== 출력 시작 =========");
		myList.printList();
		
		System.out.println();
		System.out.println("======== 삭제 시작 =========");
		myList.delete("JAVA");
		myList.delete("CSS");
		myList.delete("Javascript");
		myList.printList();
	}

}
