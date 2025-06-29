
package 자료구조제8장리스트.test;
/*
 * 정수 리스트 > 객체 리스트 >
 * * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject2 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	String no; // 회원번호
	String name; // 이름
	String expire;//  유효기간 필드를 추가

	public SimpleObject2(String sno, String sname, String expire) {
		this.no = sno;
		this.name = sname;
		this.expire = expire;
	}
	public SimpleObject2() {
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
	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject2> {
		@Override
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject2> {
		@Override
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
		}
	}
}

class Node4 {
	SimpleObject2 data; // 데이터
	Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

}

class DoubledLinkedList2 {
	private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = new Node4(); // dummy(first) 노드를 생성
		first.rlink = first.llink = first;
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

	// --- 노드를 검색 ---//
	public boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 p = first.rlink;
		
		if(p == first) {
			System.out.println("리스트가 비어있습니다.");
			return false;
		}
		
		while(p != first) {
			if(c.compare(p.data, obj) == 0)
				return true;
			p = p.rlink;
		}
		
		return false;
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node4 p = first.rlink;
		
		if(p == first) {
			System.out.println("리스트가 비어있습니다.");
			return;
		}
		
		while(p != first) {
			System.out.println("("+ p.data.no + ") " + p.data.name);
			p = p.rlink;
		}
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 p = first.rlink;
		Node4 newNode = new Node4();
		newNode.data = obj;
		
		if(p == first) {
			first.rlink = first.llink = newNode;
			newNode.llink = newNode.rlink = first;
			return;
		}
		
		while(p != first) {
			System.out.println(p.data);
			if (c.compare(p.data, newNode.data) > 0) {
				newNode.llink = p.llink;
				p.llink.rlink = p.llink = newNode;
				newNode.rlink = p;
				return;
			} else if (c.compare(p.data, newNode.data) <= 0 && p.rlink == first) {
				p.rlink = first.llink = newNode;
				newNode.llink = p;
				newNode.rlink = first;
				return;
			}
			
			p = p.rlink;
		}

	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 p = first.rlink;
		
		if(p == first) {
			System.out.println("리스트가 비어있습니다.");
			return;
		}
		
		while(p != first) {
			if (c.compare(p.data, obj) == 0) {
				p.rlink.llink = p.llink;
				p.llink.rlink = p.rlink;
				System.out.println("삭제 성공: " + p.data.no);
				return;
			}
			
			p = p.rlink;
		}
		
		System.out.println("삭제 실패: 해당 데이터가 존재하지 않습니다.");
	}
	
	public DoubledLinkedList2 merge_NewList(DoubledLinkedList2 lst2, Comparator<SimpleObject2> cc) {
		//l3 = l1.merge(l2); 실행하도록 리턴 값이 리스트임 
		//l.add(객체)를 사용하여 구현
		//기존 리스트의 노드를 변경하지 않고 새로운 리스트의 노드들을 생성하여 구현 
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		Node4 ai = this.first.rlink, bi = lst2.first.rlink;
		Node4 p = lst3.first;
		
		while (ai != first && bi != lst2.first) {
			Node4 newNode = new Node4();
			SimpleObject2 data;
			
			if(cc.compare(ai.data, bi.data) <= 0) {
				data = ai.data;
				ai = ai.rlink;
			} else {
				data = bi.data;
				bi = bi.rlink;
			}
			newNode.data = data;
			
			newNode.llink = p;
			p.rlink = newNode;
			
			p = p.rlink;
		}
		
		while(ai != this.first) {
			Node4 newNode = new Node4();
			newNode.data = ai.data;
			
			newNode.llink = p;
			p.rlink = newNode;
			
			p = p.rlink;
			ai = ai.rlink;
		}
		
		while(bi != lst2.first) {
			Node4 newNode = new Node4();
			newNode.data = bi.data;
			
			newNode.llink = p;
			p.rlink = newNode;
			
			p = p.rlink;
			bi = bi.rlink;
		}

		p.rlink = lst3.first;
		lst3.first.llink = p;
		return lst3;
	}
	
	void merge_InPlace(DoubledLinkedList2 b, Comparator<SimpleObject2> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		Node4 p = first.rlink, q = b.first.rlink;
		Node4 temp = first;
		Node4 head = first;
		
		if(p == first) {
			first.rlink = q;
			first.llink = b.first.llink;
			q.llink = first;
			b.first.llink.rlink = first;
			b.first.llink = b.first.rlink = b.first; // 리스트 초기화
			return;
		}
		if(q == b.first) {
			return;
		}
		
		while (p != first && q != b.first) {
			if(cc.compare(p.data, q.data) <= 0) { // 각 리스트가 비어있지 않음
				temp.rlink = p;
				p.llink = temp;
				p = p.rlink;
			} else {
				temp.rlink = q;
				q.llink = temp;
				q = q.rlink;
			}
			temp = temp.rlink;
		}
		
		while (p != first) {// 남은 리스트 병합
			temp.rlink = p;
			p.llink = temp;
			p = p.rlink;
			temp = temp.rlink;
		}
		
		while (q != b.first) {
			temp.rlink = q;
			q.llink = temp;
			q = q.rlink;
			temp = temp.rlink;
		}
		
		temp.rlink = head;
		head.llink = temp;
		
		b.first.llink = b.first.rlink = b.first; // b 빈 리스트로

	}
}

public class train_실습과제8_6객체이중리스트 {
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
		DoubledLinkedList2 lst1 = new DoubledLinkedList2(),	lst2 = new DoubledLinkedList2();
		DoubledLinkedList2 lst3 = new DoubledLinkedList2(), lst4 = new DoubledLinkedList2();
		String sno1 = null, sname1 = null;
		SimpleObject2 so;
		boolean result = false;
		int count = 3;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 객체들의 올림차순으로 정렬되도록 구현
//				so =  new SimpleObject2();
//				so.scanData("입력", 3);
//				lst1.add(so, SimpleObject2.NO_ORDER);
				SimpleObject2 [] simpleobjects = new SimpleObject2[10];
				makeSimpleObjects(simpleobjects);
				for (int i = 0; i < simpleobjects.length;i++)
					lst1.add(simpleobjects[i], SimpleObject2.NO_ORDER );
				break;
			case Delete: // 임의 객체를 삭제
				so =  new SimpleObject2();
				so.scanData("삭제", SimpleObject2.NO);
				lst1.delete(so, SimpleObject2.NO_ORDER);
				break;
			case Show: // 리스트 전체를 출력
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				so =  new SimpleObject2();
				so.scanData("탐색", SimpleObject2.NO);
				result = lst1.search(so, SimpleObject2.NO_ORDER);
				if (!result)
					System.out.println("검색 값 = " + so + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
				break;
			case Merge_NewList://기존 2개의 리스트를 합병하여 새로운 리스트를 생성(새로운 노드를 생성하여 추가)
//				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
//					so = new SimpleObject2();
//					so.scanData("병합", 3);
//					lst2.add(so, SimpleObject2.NO_ORDER );				
//				}
				SimpleObject2 [] simpleobjects2 = new SimpleObject2[10];
				makeSimpleObjects2(simpleobjects2);
				for (int i = 0; i < simpleobjects2.length;i++)
					lst2.add(simpleobjects2[i], SimpleObject2.NO_ORDER );
				System.out.println("리스트 lst1::");
				lst1.show();
				System.out.println("리스트 lst2::");
				lst2.show();
				lst3= lst1.merge_NewList(lst2, SimpleObject2.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 lst3::");
				lst3.show();	
				break;
			case Merge_InPlace:
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					so = new SimpleObject2();
					so.scanData("병합", 3);
					lst2.add(so, SimpleObject2.NO_ORDER );				
				}
				SimpleObject2 [] simpleobjects3 = new SimpleObject2[10];
				makeSimpleObjects3(simpleobjects3);
				for (int i = 0; i < simpleobjects3.length;i++)
					lst4.add(simpleobjects3[i], SimpleObject2.NO_ORDER );
				System.out.println("리스트 lst2::");
				lst2.show();
				System.out.println("리스트 lst4::");
				lst4.show();
				lst4.merge_InPlace(lst2, SimpleObject2.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 lst4::");
				lst4.show();
			case Exit: // 
				break;
			}
		} while (menu != Menu.Exit);
	}
	static void makeSimpleObjects(SimpleObject2 []simpleobjects) {
        simpleobjects[0] = new SimpleObject2("s8", "hong", "240618");
        simpleobjects[1] = new SimpleObject2("s2", "kim", "240619");
        simpleobjects[2] = new SimpleObject2("s3", "lee", "240601");
        simpleobjects[3] = new SimpleObject2("s1", "park", "240621");
        simpleobjects[4] = new SimpleObject2("s4", "choi", "240622");
        simpleobjects[5] = new SimpleObject2("s6", "jung", "240611");
        simpleobjects[6] = new SimpleObject2("s7", "kang", "240624");
        simpleobjects[7] = new SimpleObject2("s5", "jo", "240615");
        simpleobjects[8] = new SimpleObject2("s19", "oh", "240606");
        simpleobjects[9] = new SimpleObject2("s10", "jang", "240607");
 
	}
	static void makeSimpleObjects2(SimpleObject2 []simpleobjects) {
        simpleobjects[0] = new SimpleObject2("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject2("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject2("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject2("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject2("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject2("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject2("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject2("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject2("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject2("s10", "you", "240617");
 
	}
	static void makeSimpleObjects3(SimpleObject2 []simpleobjects) {
        simpleobjects[0] = new SimpleObject2("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject2("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject2("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject2("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject2("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject2("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject2("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject2("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject2("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject2("s10", "you", "240617");
 
	}
}
