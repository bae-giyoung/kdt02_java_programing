package com.ruby.java.ch08.innerClass;

import java.util.Arrays;

/*
 * 외부 클래스 구현 
 */

class Node3 {
	int data;
	Node3 link;
	public Node3(int data) {
		this.data = data; link = null;
	}
}

class LinkedList3 {
	Node3 first;
	
	void append(int data) { // 뒤에 붙이기
		Node3 newNode = new Node3(data);
		Node3 p = first;
		
		if (first == null) {
			first = newNode;
		} else {
			while (p.link != null) { // p.link == null인 것 찾기 => "마지막 요소" 찾기
				p = p.link;
			}
			p.link = newNode;
		}
		
	}
	
	void showList() {
		System.out.println();
		System.out.println("============== 목록 출력 ==============");
		Node3 p = first;
		int step = 1;
		
		if (first == null) {
			System.out.println("등록된 목록이 없습니다.");
		} else {
			while(p != null) { // 마지막 요소까지 반복
				System.out.println("[" + step + "] : " + p.data);
				p = p.link;
				step++;
			}
		}
	}
	
	void insert(int data) { // 10을 가정
		Node3 newNode = new Node3(data);
		Node3 p = first, q = null;
		
		while(p != null) {
			if(p.data > data) { // 15 > 10, 큰 데이터를 가진 p, 그 이전이 q일 때 반복문 종료
				break;
			}
			q = p;
			p = p.link;
		}
		
		newNode.link = p; // 큰 데이터 가진 p를 찹조 끊기 전에 링크로 연결
		
		if(p == first) { // newNode가 제일 앞에 올 경우
			first = newNode;
		} else {
			q.link = newNode; // 작은 데이터 가진 q의 링크에 newNode 연결
		}
		
	}

}

public class 실습과제_ch08_연결리스트와배열 {
	
	// 그냥 인자로 받은 배열의 (size/2 + 1)번까지의 요소를 할당하고, 할당된 요소수 count를 반환하는 임시 메서드?
	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; count++;
		}
		return count;
	}
	
	// 출력 메서드
	static void showList(int[]data) {
		System.out.println();
		
		for (int i=0; i < data.length; i++)
			System.out.print(" " + i + " "); // 인덱스 넘버 출력
		
		System.out.println();
		
		for (int i = 0; i < data.length; i++) { // 할당된 요소의 값 출력
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
		
		System.out.println();		
	}
	
	// 마지막 요소에 삽입 시키고 count 반환
	static int appendList(int[] data, int count, int x) {
		if (data.length > count) 
			return count;
		
		data[count] = x; // 인덱스: count - 1 + 1
		count++;
		return count;
	}
	
	// 크기 순(작->큰)으로 정렬이 됐다고 가정하고 사용하는 메서드
	static int insertList(int[] data, int count, int x) {
		
		// 요소의 길이를 초과하는 상황
		if (count >= data.length) {
			System.out.println("insert 실패: ");
			return count;
		}
		
		
		// 비교 탐색, 제일 큰 경우
		int idx = 0;
		for(int i = 0; i < count; i++) {
			if (data[i] >= x) {
				break;
			}
			idx++;
		}
		
		// x보다 큰 첫 번째 요소의 인덱스: idx
		// idx부터 값이 할당된 요소의 수 count까지 1씩 뒤로 옮김
		// 뒤에서부터 앞으로 수행
		for(int i = count - 1; i >= idx; i--) {
			data[i + 1] = data[i];
		}
		
		data[idx] = x;
		
		count++;
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int[]list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		// 정렬이 됐다고 가정
		count = insertList(list, count, -1);
		showList(list);
		count = insertList(list, count, 3);
		showList(list);
		count = insertList(list, count, 7);
		count = insertList(list, count, 100);
		showList(list);
		// 요소의 길이 초과하는 상황
		count = insertList(list, count, 7);
		count = insertList(list, count, 7);
		count = insertList(list, count, 7);
		count = insertList(list, count, 7);
		showList(list);
		System.out.println("count: " + count);
		
		LinkedList3 ll = new LinkedList3();
		ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25);
		ll.showList();
		System.out.println("============= insert 실행 =============");
		ll.insert(3);ll.showList();
		ll.insert(7);ll.showList();
	}
}
