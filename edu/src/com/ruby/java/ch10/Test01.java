package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		// ArrayList는 기본 default로 길이 10의 배열
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울"); list.add("북경"); list.add("상해");
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		
		for (int i = 0; i < list.size(); i++) { // 컬렉션 배열 전체의 사이즈가 아님!
			System.out.println(list.get(i));
		}
		
		// 중복값을 가지는지 확인
		if (list.get(0) == list.get(3)) System.out.println("=====> 0: 서울과 3: 서울은 같은 해시값을 가짐, 즉 배열의 요소는 같은 값(여기선 같은 해시값)을 중복해서 가질 수 있다.");
		
		
		// 첫번째 보기
		System.out.println("1: " + list.toString());
		
		
		// 두번째 보기
		list.add("서울"); list.add("북경"); list.add("상해");
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		System.out.println("2: " + list.toString());
		
		// 교재 p.471 실습
		// void add(int index, E element)
		list.add(1, "LA"); print(2, list);
		
		//int indexOf(Object o) / int lastIndexOf(Object o)
		System.out.println("3: " + list.indexOf("서울"));
		System.out.println("4: " + list.lastIndexOf("서울"));
		
		// boolean remove(Object 0)
		list.remove("LA"); print(5, list);
		
		// E remove(int index)
		list.remove(2); print(6, list);
		
		// boolean contains(Object o)
		System.out.println("7: " + list.contains("LA"));
		
		// Object[] toArray()
		Object obj[] = list.toArray();
		System.out.println("8: " + Arrays.toString(obj));
		
		// <T> T[] toArray(T[] a)
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9: " + Arrays.toString(cities));
		
		// void clear()
		list.clear(); print(10, list);
		
		// boolean isEmpty()
		System.out.println("11: " + list.isEmpty());
		
		list.add("파리");
		list.add("방콕");
		list.add("LA");
		
		// Arrays 클래스의 static <T> List<T> asList(T... a)
		List<String> list2 = Arrays.asList("서울","뉴욕","상해");
		print(12, list2);
		
		// boolean addAll(Collection<? extends E> c)
		list.addAll(list2); print(13,list);
		
		// boolean containsAll(Collection<?> c)
		System.out.println("14: " + list.containsAll(list2));
		
		// boolean retainAll(Collection<?> c)
		list.retainAll(list2); print(15, list);
		
		// boolean removeAll(Collection<?> c)
		list.removeAll(list2); print(16, list);
		
		
	}

	private static void print(int i, List<String> list2) {
		System.out.println(i + ": " + list2);
	}

}
