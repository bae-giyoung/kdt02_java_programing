package 자료구조제8장리스트.test;

import java.util.Comparator;

class Node5<T> {
	private T data;
	private Node5<T> prev;
	private Node5<T> next;
	
	public Node5(T data) {
		this.data = data;
		//this.prev = null; 필드 초기화 안해줘도 null로 초기화 되니 괜찮은 건가?
		//this.next = null;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node5<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node5<T> prev) {
		this.prev = prev;
	}
	
	public Node5<T> getNext() {
		return next;
	}
	
	public void setNext(Node5<T> next) {
		this.next = next;
	}
	
}

public class LinkedList<T> {
	private final Node5<T> head; // final 한 번 결정하면 다시 안바뀜!!!!! > 생성 시점에 결정하면 못바꾸게!
	private int size;
	
	public LinkedList() {
		this.head = new Node5<>(null); // dummy 노드 : 링크드리스트는 자료구조 중 유일하게 맨 앞에 Null, 맨 뒤에 Null
		this.head.setPrev(head);
		this.head.setNext(head);
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head.getNext() == head;
	}
	
	// addFirst()
	public void addFirst(T obj) {
		Node5<T> newNode = new Node5<>(obj);
		Node5<T> first = head.getNext();
		
		newNode.setPrev(head);
		newNode.setNext(first);
		head.setNext(newNode);
		first.setPrev(newNode);
		
		size++;
	}
	
	// addLast() - 해보세요
//	public void addLast(T obj) { head가 final이 아닐 때 > 즉 head를 변경하지 않을 때
//		Node5<T> newNode = new Node5<>(obj);
//		//Node5<T> last = head.getPrev(); // 원형이 아니니까 다르게 해야 할 듯!!
//		if(head == null) {
//			head = newNode;
//		} else {
//			Node5<T> current = head;
//			
//			while(current.getNext() != null) {
//				current = current.getNext();
//			}
//			
//			current.setNext(newNode);
//			current.setPrev(current);
//		}
//	}
	
	public void addLast(T obj) {
		Node5<T> newNode = new Node5<>(obj);
		Node5<T> last = head.getPrev();
		
		newNode.setPrev(last);
		newNode.setNext(head);
		last.setNext(newNode);
		head.setPrev(newNode);
		size++;
	}
	
	// add할 때 순서 보장
	public void add(T obj, Comparator<? super T> c) {
		Node5<T> newNode = new Node5<>(obj);
		Node5<T> current = head.getNext();
		
		// 정렬된 위치를 찾아야 함
		while(current != head && c.compare(obj, current.getData()) >= 0) {
			current = current.getNext();
		}
		
		// current 기준으로 앞에 삽입
		newNode.setPrev(current.getPrev());
		newNode.setNext(current);
		current.getPrev().setNext(newNode);
		current.setPrev(newNode);
		size++;
	}
	
	// add할 때 순서 보장
	public void add(T obj) {
		@SuppressWarnings("unchecked")
		Comparable<T> comparableObj = (Comparable<T>) obj;
		add(obj, (a, b) -> comparableObj.compareTo(b));
	}
	
	// 삭제
	public void delete(T obj, Comparator<? super T> c) { // 제네릭타입을 사용하기 때문에 비교에 문제가 있음!! > 그렇기 때문에 Comparator를 인자로 받는다!
		//Node5<T> current 현재 노드
		//반복구문 사용해서 current 이동
		//만약에 obj와 Node<T>가 같으면 삭제
		//아니면 return 해야 함
		Node5<T> current = head.getNext();
		while(current != head) {
			if(c.compare(current.getData(), obj) == 0) {// 같아!
				current.getPrev().setNext(current.getNext()); // 메서드 체이닝
				current.getNext().setPrev(current.getPrev());
				size--;
				System.out.println("삭제 완료: " + obj);
				return;
			}
			current = current.getNext();
		}
		System.out.println("삭제할 데이터를 찾을 수 없습니다: " + obj);
	}
	
	// merge_newlist
	public LinkedList mergeNewList(LinkedList lst2, Comparator<? super T> cc) {
		// add를 사용하는 것으로 변경
		LinkedList<T> lst3 = new LinkedList<>();
		
		Node5<T> ai = head.getNext();
		Node5<T> bi = lst2.head.getNext();
		
		// 반복문
		while(ai != head && bi != lst2.head) {
			if(cc.compare(ai.getData(), bi.getData()) <= 0) { // ai.getData()가 더 작다
			// if(getData(), getData() <= 0 순서!!
			// 추가해야 됨 (add를 이용해서 추가) ai
			// else
			// 추가해야 됨 (add를 이용해서 추가) bi
				lst3.add(ai.getData()); // lst3의 사이즈가 메서드 내에서 
				ai = ai.getNext();
			} else {// bi.getData()가 더 작다
				lst3.add(bi.getData());
				bi = bi.getNext();
			}
			
		}
		// ai의 남은 리스트 순회해서 뒷부분에 추가
		while(ai != head) {
			lst3.add(ai.getData());
			ai = ai.getNext();
		}
		// bi의 남은 리스트를 순회해서 뒷부분에 추가
		while(bi != head) {
			lst3.add(bi.getData());
			bi = bi.getNext();
		}
		
		return lst3;
	}

}
