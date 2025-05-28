package 자료구조제2장기본자료구조;

import java.util.Arrays;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class train_실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		String[] newData2 = insertString(data, "zzzzz");
		String[] newData3 = insertString(data, "aaaaa");
		showData("삽입후 크기가 증가된 정렬 배열 (중간)", newData);
		showData("삽입후 크기가 증가된 정렬 배열 (제일 뒤)", newData2);
		showData("삽입후 크기가 증가된 정렬 배열 (제일 앞)", newData3);
		
		// API 확인
		System.out.println("\n====== API로 정렬(기본) ======");
		Arrays.sort(data);
		showData("Arrays.sort(data) 기본 정렬: ", data);
		System.out.println("\n======= API로 정렬(Comparable) ======");
		Arrays.sort(data, (a,b) -> a.compareTo(b));
		showData("Arrays.sort(data, Comparable) 정렬: ", data);
	}
	static void showData(String msg, String[] data) {//확장된 for 문으로 출력
		int step = 0;
		System.out.print(msg + " : ");
		System.out.print("[");
		for(String d : data) {
			if(step != data.length - 1) {
				System.out.print(d + ", ");
				step++;
			} else {
				System.out.println(d + "]");
			}
		}
		
	}

	static void swap(String[] data, int idx1, int idx2) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		String val1 = data[idx1];
		String val2 = data[idx2];
		data[idx1] = val2;
		data[idx2] = val1;
	}
	
	static void sortData(String[] data) {//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 
		for(int i=0; i<data.length; i++) {
			for(int j=i+1; j<data.length; j++) {
				if(data[i].compareTo(data[j]) > 0)
					swap(data, i, j);
			}
		}
	}
	
	static String[] insertString(String[] data, String value){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String[] newData = new String[data.length+1];
		
		int j = 0;
		for(int i=0; i<data.length; i++) {
			if (data[i].compareTo(value) < 0) {
				newData[i] = data[i];
				j = i + 1;
			} else {
				newData[i+1] = data[i];
			}
		}
		newData[j] = value;
		
		return newData;
	}
}
