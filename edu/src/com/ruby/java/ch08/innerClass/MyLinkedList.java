package com.ruby.java.ch08.innerClass;

public class MyLinkedList {
	
	private Node head = null; // head에 첫 할당 한 후 재 할당은 절대 하면 안됨!
	
	private class Node {
		private String data;
		private Node link;
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	public void add(String data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else {
			Node next = head;
			
			while(next.link != null) { // 현재 링크의 마지막으로 가는 코드
				next = next.link;
			}
			next.link = newNode;
		}
	}
	
	public void remove(String data) {
		if (head == null) return;
		
		// 예외1: 첫번째를 삭제하는 경우
		// 예외2: 마지막을 삭제하는 경우 
		
		Node next = head;
		Node prev = null;
		while(next != null) {
			
			// 탐색
			if (data.equals(next.data)) {

				// 첫번째를 삭제할 때의 로직(prev 없음): head 자체가 변경되어야 함. 작업 후 break.
				if (prev == null) {
					head = next.link;
					break;
				}
				
				// 마지막 번째의 로직(next.link 없음): prev의 link를 null. break.
				if (next.link == null) {
					prev.link = null;
					break;
				}
				
				prev.link = next.link;
				break;
			}
			
			prev = next;
			next = next.link;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			
			while(next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
}
