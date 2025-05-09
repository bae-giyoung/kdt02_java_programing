package 자바_3장_배열;

public class Test33 {

	public static void main(String[] args) {
//		int []arr = new int[4]; // 각 요소는 초기화값이 0이다! 컴퓨터가 배열을 만들면 각 요소를 0으로 초기화한다!
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
		
		int []arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; // 객체 배열을 만들고 초기화
		for (int i = 0; i < arr.length; i++) { // 변수 i의 범위 : scope는 for문 내로 국한된다.
			System.out.print(arr[i] + " ");
		}
		
		int[] score;
//		score = {90, 85, 78, 100, 90}; // Array constant can only be used in initializers. 에러
		score = new int[]{90, 85, 78, 100, 90}; // 이렇게 하면 에러 안나지만 이렇게는 거의 사용하지 않는다!

		// arr에 다른 배열의 시작주소를 재할당!
		arr = new int[]{10, 20, 30}; // 참조가 해제된 기존 배열은 가비지 컬렉터가 추후 메모리에서 해제함!
//		for (int i = 0; i < 5; i++) { // Index 3 out of bounds for length 3. // i가 3일 때 에러 발생!
		for (int i = 0; i < 3; i++) {
			System.out.print(arr[i]);
		}
	}

}
