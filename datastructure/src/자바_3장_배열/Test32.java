package 자바_3장_배열;

public class Test32 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] =11;
		arr[1] =22;
		arr[2] =33;
		arr[3] =19;
		arr[4] =29;
		//System.out.println(arr[3]);
		
		// for문을 사용해서 배열을 출력
		System.out.print('[');
		for(int i = 0; i < 5; i++) {
			if (i == 4) System.out.print(arr[i]);
			else System.out.print(arr[i] + ", ");
		}
		System.out.println(']');
		
		
		// 최대값 구하기
		int minNum = arr[0];
		int maxNum = arr[0];
		for(int j = 1; j < 5; j++) {
			if(minNum > arr[j])
				minNum = arr[j];
			
			if(maxNum < arr[j])
				maxNum = arr[j];
		}
		System.out.println("최소값: " + minNum);
		System.out.println("최대값: " + maxNum);
		
		
		// 등차수열을 배열로 만들기 3,5,7,9,.... 개수는 10개
		int[] arr2 = new int[10]; // 배열 생성
		System.out.print('[');
		for (int k = 0; k < 10; k++) {
			arr2[k] = 3 + (k*2);
			if (k == 9)
				System.out.print(arr2[k]);
			else
				System.out.print(arr2[k] + ", ");
		}
		System.out.println(']');

	}

}
