package day1;

public class p1 {

	public static void main(String[] args) {
		// [학습 목표] 생각을 체계화해보는 연습 : 생각을 먼저 정리하고 코드를 짜보자!
		
		
		// [문제 풀기1 첫 번째 방법, 가장 간결하게 메소드 사용해보기] : 코드 먼저 짰다. 반성하자.
		String a = "masterpiece";
		a = a.replaceAll("m", "rn");
		
		/*
		 * 처음에 원하는 결과가 나오지 않는 것에 대해 분석해보기
		 * a는 참조변수.
		 * a의 참조값은 Heap 메모리에 저장된 "masterpiece" 문자열 객체 데이터를 가리킴
		 * 
		 * [관찰한 상황]
		 * a에 재할당하지 않고, a.replaceAll("m", "rn");만 호출했을 때
		 * 예상한 결과: "rnasterpiece"
		 * 실제 결과: "masterpiece" 출력됨
		 * 
		 * [기존의 생각, 틀린 가설]
		 * a.replaceAll("m", "rn");은 Heap에 저장된 "masterpiece" 데이터를 변경함.
		 * a는 재할당 하지 않았기 때문에 저장된 참조값은 변하지 않음.
		 * 따라서 기존의 문자열(참조형) 데이터가 "rnasterpiece" 문자열(참조) 데이터로 변경될 것으로 예상했었음.
		 * ======> 하지만, 결과는 a를 출력했을 때, "masterpiece"라는 변경되지 않은 데이터가 출력됨.
		 * 
		 * [문제의 원인에 대한 가설을 세워봄]
		 * 1. javascript처럼 java 또한 문자열이 immutable이다.
		 * 1-1. 따라서, "masterpiece" 문자열(참조) 데이터는 기존의 메모리 위치에 그대로 남아 있다.
		 * 1-2. 문자열 데이터가 immutable이므로 a.replaceAll("m", "rn");은 메모리에 새로운 문자열 데이터를 만들어서 반환했다. (다른 메모리 주소)
		 * 1-3. 따라서 a는 그대로 "masterpiece"를 가리키고 있다.
		 * 1-4. 문자열 데이터는 immutable이고, 그렇기 때문에 문자열 메소드(??)인 replaceAll()은 당연히 새로운 데이터를 생성해서 반환하도록 설계되었다.
		 * 2. 아니면 immutable이 아니고, .replaceAll() 메서드가 새로운 데이터를 생성하는 메소드일 뿐이다.
		 * 
		 * [gpt에게 들은 답변 정리]
		 * 1. 1번 가설이 맞다. java의 문자열 데이터는 "immutable 객체"이다. (javascript의 문자열 데이터는 immutable primitive data types)
		 * 2. 문자열이 immutable하기 때문에 당연히 메서드들이 새 객체를 생성하도록 설계되었다.
		 * 
		 */
		
		System.out.println(a); // rnasterpiece
		
		
		
		
		// [문제 풀기2 두 번째 방법, 배열처럼 순회할 수 있는 특성을 가진 객체인 것을 이용해보기] : 생각을 먼저 정리! 할 일을 순서대로 정리!
		/* 선 공부
		 * 문자열 데이터는 String 클래스의 인스턴스.
		 * java의 문자열은 배열처럼 인덱스로 순회할 수 있는 구조이며 내부적으로는 char[] 배열에 기반해 동작
		 * 공식적 iterable은 아니지만, 순회할 수 있는 특성을 가진 객체! (interface Iterable<T>을 구현한 객체는 아님)
		 * 사용할 문법 : 문자열객체.charAt(int index); 즉 문자열객체.charAt(0); 반환 타입은 char이 맞나?
		 */
		
		// 문제 : 문자열에 포함된 알파벳 m을 모두 rn으로 변경하기
		// 단계 정하기
		// 1. 바꿀 대상 문자열 생성 : String 타입 변수 oriStr 선언 및 초기화
		// 2. 바꾼 문자열을 넣을 변수 생성 : String 타입 변수 newStr 선언 및 빈 문자열로 초기화
		// 3. for문으로 문자열의 각 char을 순회하기
		// 4. 각 char을 순회할 때, char의 값 복사해서 newStr에 +=로 연산 후 재할당 하는데
		// 5. 해당 문자가 "m"일 경우 "rn"으로 .charAt(i)가 아닌 "rn"값으로 연산 후 재할당 하기
		// 6. newStr 출력
		
		
		String oriStr = "masterpiecemm";
		String newStr = "";
		
		for (int i = 0; i < oriStr.length(); i++) {
			char ch = oriStr.charAt(i);
			if (ch == 'm')
				newStr += "rn";
			else
				newStr += ch;
		}
		
		System.out.println(newStr); // rnsterpiecernrn
		
		
		// [다시 단계 쪼개기 연습]
		// 그림으로 그려서 위의 단계를 다시 쪼개보자. 함수 도식화처럼 그려봄.
		// 코드로 어떻게 할 지 생각하지 말고, 논리적인 단계를 생각해 보자!
		// input : "masterpiecemm"
		// output : "rnasterpiecernrn"
		// 단계1 : 문자열을 왼쪽에서 부터 차례대로 순회하기
		// 단계2 : 문자가 'm'일 경우, "rn"으로 변경, 
		//        아닐 경우 그대로.
		// 단계3 : 문자를 새로운 문자열에 누적
		// 단계4 : 출력
		

	}

}
