package 자료구조제3장검색알고리즘;

/*
 * 3장 3번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparable 구현
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 * 
 * Comparable Interface
 * 
 * public interface Comparable<T> {
 *     int compareTo(T o);
 * }
 */

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 * 
 * binarySearch(T[], T key)는 API에서 직접 지원하지 않음.
 * 하지만 binarySearch(Comparable<T>[] a, T key)를 사용할 수 있음.
 * 배열이 Comparable<T>을 구현하는 객체라면 정상적으로 동작함.
 * 만약 비교 기준을 다르게 설정하고 싶다면 binarySearch(T[], T key, Comparator<? super T> c)를 사용해야 함
 * 
 * Arrays.sort(Object[])가 존재하는 이유 > 
 * 배열의 원소가 Comparable을 구현하면, Object[] 배열에서도 정렬 가능
 * String[], Integer[], Double[] 등 Comparable을 구현한 기본 래퍼 클래스의 배열을 정렬하는 데 유용
 * 
 *  Object[] numbers = {5, 2, 9, 1, 3}; // Integer 배열 (Integer는 Comparable<Integer> 구현)
 *  Arrays.sort(numbers); // 정상 작동
 *  
 *  Arrays.sort(T[]) (제네릭 버전)
 *  제네릭 배열 T[]을 정렬할 때 더 적합한 방식.
 *  T가 Comparable<T>를 구현했을 경우, 자동으로 compareTo()가 호출됨.
 *  T[] 배열의 원소가 Comparable<T>를 구현하면 Arrays.sort(T[])를 사용할 수 있음.
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		return "[" + name + ", " + height + ", " + vision + "]";
	}
	
	@Override
	public int compareTo(PhyscData2 p) {
		// name 비교, height 비교, vision 비교
		int comp = name.compareTo(p.name);
		
		if (comp == 0) {
			if (height - p.height == 0)
				return (int)((vision - p.vision)*10); // 사실은 double의 최대 표현가능 자리수까지 해야겠지?
			else
				return height - p.height;
		}
		else return comp;
	}
}

public class train_실습3_6_1객체배열탐색_Comparable {
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		showData("정렬전", data);
		sortData(data);//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다 - compareTo() 구현을 변경하여 실행결과를 확인
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
		int resultIndex = linearSearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);
		
		key = new PhyscData2("박동", 167, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		key = new PhyscData2("나동", 164, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//compareTo()를 사용되는지를 확인-이해할 수 있어야 한다 
		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
		resultIndex = binarySearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\n내가 작성한 vision까지 다 비교 binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}

	private static int binarySearch(PhyscData2[] data, PhyscData2 key) {
		int size = data.length;
		int pl = 0;
		int pr = size - 1;
		int pc = (pl + pr) / 2;
		do {
			if(key.compareTo(data[pc]) == 0) {
				return pc;
			} else if(key.compareTo(data[pc]) > 0) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
			pc = (pl + pr) / 2;
		} while(pl <= pc);
		return -1;
	}

	private static int linearSearch(PhyscData2[] data, PhyscData2 key) {
		for(int i=0; i<data.length; i++) {
			if(key.compareTo(data[i]) == 0 && key.height == data[i].height && key.vision == data[i].vision)
				return i;
		}
		return -1;
	}

	private static void reverse(PhyscData2[] data) {
		PhyscData2[] newData = data.clone();
		for(int i=0; i<data.length; i++) {
			data[i] = newData[data.length - 1 - i];
		}
	}
	
	static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 v1 = data[i];
		data[i] = data[j];
		data[j] = v1;
	}
	
	private static void sortData(PhyscData2[] data) {
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data.length; j++) {
				if(data[i].compareTo(data[j]) < 0) {
					swap(data, i, j);
				}
			}
		}
	}

	private static void showData(String string, PhyscData2[] data) {
		System.out.print(string + " : ");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i].toString());			
		}
		System.out.println("\n");
	}
	
	

}
