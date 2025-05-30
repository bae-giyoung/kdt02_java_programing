package 자료구조제3장검색알고리즘;

/*
 * 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색 
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class train_실습3_6_0스트링배열정렬이진탐색 {

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("정렬후", data);

		String key = "포도";
		System.out.println("포도.compareTo(가)로 반환되는 값 알기 위한 출력 : " + key.compareTo("가"));
		System.out.println("포도.compareTo(포도)로 반환되는 값 알기 위한 출력 : " + key.compareTo("포도"));
		System.out.println("포도.compareTo(하)로 반환되는 값 알기 위한 출력 : " + key.compareTo("하"));
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "배";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 * public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
		 *     @Override
		 *     public int compareTo(String anotherString) {
		 *             return this.compareTo(anotherString);
		 *     }
		 *	}
		 *
		 *  binarySearch(String[], String key)를 호출하면, 
		 *  내부적으로 String 배열이 자동으로 Comparable<String>[]로 해석.
		 */
		resultIndex = Arrays.binarySearch(data, key);//교재 120 페이지 API 참조
		//교재 116 표 3-3: static int binarySearch(Object[] a, Object key)가 사용됨 - 단 배열 a는 Comparable을 구현한 객체들로 정렬되어 있어야 함
		
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}

	private static void sortData(String[] data) {
		// 버블 정렬이었나? => 인덱스, 인덱스+1 끼리 비교 후 정렬하기!
		for(int i=0; i<data.length; i++) {
			for(int j=i+1; j<data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					String v1 = data[i];
					String v2 = data[j];
					data[i] = v2;
					data[j] = v1;
				}
			}
		}
	}

	private static int binarySearch(String[] data, String key) {
		int size = data.length;
		int pl = 0;
		int pr = size - 1;
		int pc = size / 2;
		
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

	private static int linearSearch(String[] data, String key) {
		for(int i=0; i<data.length; i++) {
			if(key == data[i])
				return i;
		}
		return -1;
	}

	private static void showData(String string, String[] data) {
		System.out.print(string + ": [");
		for(int i=0; i<data.length; i++) {
			if (i != data.length - 1)
				System.out.print(data[i] + ", ");
			else
				System.out.println(data[i] + "]");
		}
	}
}
