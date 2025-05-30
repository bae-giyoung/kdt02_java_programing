package 자료구조제3장검색알고리즘;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class train_실습3_4정수배열이진탐색 {

	public static void main(String[] args) {
		Random rnd = new Random();
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = rnd.nextInt(100);
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = rnd.nextInt(100);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);
		
		key = rnd.nextInt(100);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key) > 0 ? true : false;
		System.out.println("\nArrays.binarySearch(10): key = " + key + ", result = " + resultIndex);

	}

	// 바이너리 서치는 반드시 정렬 후 처리해야 한다!
	private static boolean binarySearch(int[] data, int key) {
		int size = data.length;
		int pl = 0;
		int pr = size - 1;
		int pc = size / 2;
		
		do {
			if(key == data[pc]) {
				return true;
			} else if (key > data[pc]) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
			pc = (pl + pr) / 2;
		} while (pl <= pc);
		
		return false;
	}

	private static boolean linearSearch(int[] data, int key) {
		// 시간복잡도 O(n)
		for(int i=0; i<data.length; i++) {
			if (key == data[i])
				return true;
		}
		return false;
	}

	private static void showList(String string, int[] data) {
		System.out.print("[");
		for (int i=0; i<data.length; i++) {
			if (i != data.length - 1)
				System.out.print(data[i] + ", ");
			else
				System.out.print(data[i] + "]\n");
		}
	}

	private static void inputData(int[] data) {
		Random rnd = new Random();
		for(int i=0; i<data.length; i++) {
			data[i] = rnd.nextInt(100);
		}
	}
}
