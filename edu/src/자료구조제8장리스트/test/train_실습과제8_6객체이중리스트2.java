// 제너럴 타입으로 변경 + 교수님 풀이 기반
package 자료구조제8장리스트.test;
/*
 * 정수 리스트 > 객체 리스트 >
 * * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject20 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	String no; // 회원번호
	String name; // 이름
	String expire;//  유효기간 필드를 추가

	public SimpleObject20(String sno, String sname, String expire) {
		this.no = sno;
		this.name = sname;
		this.expire = expire;
	}
	public SimpleObject20() {
		this.no = null;
		this.name = null;
	}
	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "(" + no + ") " + name;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}
	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject20> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject20> {
		@Override
		public int compare(SimpleObject20 d1, SimpleObject20 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject20> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject20> {
		@Override
		public int compare(SimpleObject20 d1, SimpleObject20 d2) {
			return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
		}
	}
}

class Node<T> { // 트리는 다양한 타입이 오기 때문에 <T>로 변경
	private T data; // 데이터
	private Node<T> prev; // 좌측포인터(앞쪽 노드에 대한 참조)
	private Node<T> next; // 우측포인터(뒤쪽 노드에 대한 참조)
	
	public Node(T obj) {
		this.data = obj;
		//this.prev = null; // 인스턴스 생성 시에 초기화 되니? 빼는 게 맞나?
		//this.next = null;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getPrev() {
		return prev;
	}
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}

class DoubledLinkedList<T> {
	private final Node<T> head; // 머리 포인터(참조하는 곳은 더미노드) dummy node!!!!!
	private int size;

	// --- 생성자(constructor) ---//
	public DoubledLinkedList() {
		head = new Node<T>(null); // dummy(first) 노드를 생성
		head.setPrev(head);
		head.setNext(head);
	}
	
	public int getSize() {
		return size;
	}
	
	public Node<T> getHead() {
		return head;
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return head.getNext() == head;
	}

	// --- 노드를 검색 ---//
	public boolean search(T obj, Comparator<? super T> c) {
		Node<T> current = head.getNext();
		
		while(current != head) {
			if(c.compare(obj, current.getData()) == 0) {
				System.out.println("데이터 존재: " + obj);
				return true;
			}
			current = current.getNext();
		}
		System.out.println("데이터가 존재하지 않습니다: " + obj);
		return false;
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node<T> current = head.getNext();
		
		if(current == head) {
			System.out.println("리스트가 비어있습니다.");
			return;
		}
		
		while(current != head) {
			System.out.println(current.getData()); // 제너럴 타입이지만 저장하는 객체의 클래스에 toString 오버로딩 되어 있다고 생각!
			current = current.getNext();
		}
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(T obj, Comparator<? super T> c) {
		Node<T> newNode = new Node<>(obj);
		Node<T> current = head.getNext();
		System.out.println("2");
		
		while(current != head) {
			if(c.compare(current.getData(), newNode.getData()) > 0) {// current의 data가 더 큰 지점까지 찾음
				current = current.getNext();
			}
		}
		// 더 큰 data를 가진 current를 기준으로 앞에 삽입 > current가 head인 경우 > 첫번째 삽입 문제 없음 > 마지막 위치의 삽입일 경우 current==head
		newNode.setPrev(current.getPrev()); // 항상 참조를 끊기 전에 새로운 저장소(삽입하는 것의 필드)에 먼저 저장하자!
		newNode.setNext(current);
		current.getPrev().setNext(newNode);
		current.setPrev(newNode);
		size++;
		System.out.println("3, "+ size+", "+newNode+", "+head.getNext());
	}
	
	// add 오버로딩
	public void add(T obj) {
		@SuppressWarnings("unchecked")
		Comparable<T> comparableObject = (Comparable<T>) obj; // Comparable과 Comparator에 대해서
		this.add(obj, (a, b) -> comparableObject.compareTo(b)); // comparableObject가 람다식의 a인자가 되는 것에 대해서
	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(T obj, Comparator<? super T> c) {
		Node<T> current = head.getNext();
		
		while(current != head) {
			if(c.compare(current.getData(), obj) == 0) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				System.out.println("삭제 성공: " + obj);
				return;
			}
			current = current.getNext();
		}
		System.out.println("삭제 실패: 해당 데이터가 존재하지 않습니다, " + obj);
	}
	
	public DoubledLinkedList<T> mergeNewList(DoubledLinkedList<T> lst2, Comparator<? super T> cc) {
		//l3 = l1.merge(l2); 실행하도록 리턴 값이 리스트임 
		//l.add(객체)를 사용하여 구현
		//기존 리스트의 노드를 변경하지 않고 새로운 리스트의 노드들을 생성하여 구현 
		DoubledLinkedList<T> lst3 = new DoubledLinkedList<T>();
		Node<T> ai = this.head.getNext(), bi = lst2.getHead().getNext();
		
		while(ai != this.head && bi != lst2.getHead()) {
			// ai가 작거나 같은 경우 > ai 삽입, ai 커서 옮기기
			if(cc.compare(ai.getData(), bi.getData()) <= 0) {
				lst3.add(ai.getData());
				ai = ai.getNext();
			}
			// bi가 작은 경우 > bi 삽입, bi 커서 옮기기
			else {
				lst3.add(bi.getData());
				bi = bi.getNext();
			}
		}
		
		// 남은것 이어 붙이기
		while(ai != this.head) {
			lst3.add(ai.getData());
			ai = ai.getNext();
		}
		while(bi != lst2.getHead()) {
			lst3.add(bi.getData());
			bi = bi.getNext();
		}
		
		// 마지막으로  원형 리스트 연결이 잘 되어있는지 확인하기! > add에서 잘 구현한 것 같은데
		
		// 원본 리스트들은 보존됨
		return lst3;
	}
	
	void mergeInPlace(DoubledLinkedList<T> b, Comparator<? super T> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		Node4 p = first.rlink, q = b.first.rlink;
		Node4 temp = null;
		

	}
}

public class train_실습과제8_6객체이중리스트2 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge_NewList("병합-새리스트"), Merge_InPlace("병합-제자리"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Scanner sc2 = new Scanner(System.in);
		DoubledLinkedList<SimpleObject20> lst1 = new DoubledLinkedList<>(),	lst2 = new DoubledLinkedList<>();
		DoubledLinkedList<SimpleObject20> lst3 = new DoubledLinkedList<>(), lst4 = new DoubledLinkedList<>();
		String sno1 = null, sname1 = null;
		SimpleObject20 so;
		boolean result = false;
		int count = 3;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 객체들의 올림차순으로 정렬되도록 구현
//				so =  new SimpleObject20();
//				so.scanData("입력", 3);
//				lst1.add(so, SimpleObject20.NO_ORDER);
				SimpleObject20 [] simpleobjects = new SimpleObject20[10];
				makeSimpleObjects(simpleobjects);
				for (int i = 0; i < simpleobjects.length;i++)
					lst1.add(simpleobjects[i], SimpleObject20.NO_ORDER );
				break;
			case Delete: // 임의 객체를 삭제
				so =  new SimpleObject20();
				so.scanData("삭제", SimpleObject20.NO);
				lst1.delete(so, SimpleObject20.NO_ORDER);
				break;
			case Show: // 리스트 전체를 출력
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				so =  new SimpleObject20();
				so.scanData("탐색", SimpleObject20.NO);
				result = lst1.search(so, SimpleObject20.NO_ORDER);
				if (!result)
					System.out.println("검색 값 = " + so + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
				break;
			case Merge_NewList://기존 2개의 리스트를 합병하여 새로운 리스트를 생성(새로운 노드를 생성하여 추가)
//				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
//					so = new SimpleObject20();
//					so.scanData("병합", 3);
//					lst2.add(so, SimpleObject20.NO_ORDER );				
//				}
				SimpleObject20 [] simpleobjects2 = new SimpleObject20[10];
				makeSimpleObjects2(simpleobjects2);
				for (int i = 0; i < simpleobjects2.length;i++)
					lst2.add(simpleobjects2[i], SimpleObject20.NO_ORDER );
				System.out.println("리스트 lst1::");
				lst1.show();
				System.out.println("리스트 lst2::");
				lst2.show();
				lst3= lst1.mergeNewList(lst2, SimpleObject20.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 lst3::");
				lst3.show();	
				break;
			case Merge_InPlace:
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					so = new SimpleObject20();
					so.scanData("병합", 3);
					lst2.add(so, SimpleObject20.NO_ORDER );				
				}
				SimpleObject20 [] simpleobjects3 = new SimpleObject20[10];
				makeSimpleObjects3(simpleobjects3);
				for (int i = 0; i < simpleobjects3.length;i++)
					lst4.add(simpleobjects3[i], SimpleObject20.NO_ORDER );
				System.out.println("리스트 lst2::");
				lst2.show();
				System.out.println("리스트 lst4::");
				lst4.show();
				lst4.mergeInPlace(lst2, SimpleObject20.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 lst4::");
				lst4.show();
			case Exit: // 
				break;
			}
		} while (menu != Menu.Exit);
	}
	static void makeSimpleObjects(SimpleObject20 []simpleobjects) {
        simpleobjects[0] = new SimpleObject20("s8", "hong", "240618");
        simpleobjects[1] = new SimpleObject20("s2", "kim", "240619");
        simpleobjects[2] = new SimpleObject20("s3", "lee", "240601");
        simpleobjects[3] = new SimpleObject20("s1", "park", "240621");
        simpleobjects[4] = new SimpleObject20("s4", "choi", "240622");
        simpleobjects[5] = new SimpleObject20("s6", "jung", "240611");
        simpleobjects[6] = new SimpleObject20("s7", "kang", "240624");
        simpleobjects[7] = new SimpleObject20("s5", "jo", "240615");
        simpleobjects[8] = new SimpleObject20("s19", "oh", "240606");
        simpleobjects[9] = new SimpleObject20("s10", "jang", "240607");
 
	}
	static void makeSimpleObjects2(SimpleObject20 []simpleobjects) {
        simpleobjects[0] = new SimpleObject20("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject20("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject20("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject20("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject20("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject20("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject20("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject20("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject20("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject20("s10", "you", "240617");
 
	}
	static void makeSimpleObjects3(SimpleObject20 []simpleobjects) {
        simpleobjects[0] = new SimpleObject20("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject20("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject20("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject20("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject20("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject20("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject20("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject20("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject20("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject20("s10", "you", "240617");
 
	}
}
