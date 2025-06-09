package 자료구조제2장기본자료구조;
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
	public int compareTo(PhyscData2 o) {
		if (this.name.compareTo(o.name) > 0)
			return 1;
		if (this.name.compareTo(o.name) < 0)
			return -1;
		return 0;
	}

}
public class train_실습2_14_1객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);

		Arrays.sort(data);//comparator가 필요하다 
		showData("Arrays.sort() 실행후", data);
		
		int resultIndex = binarySearch(data, "이길동");System.out.println(resultIndex);
		//if (resultIndex >= 0)
		///	System.out.println("사이다가 존재하면 인덱스 = "+resultIndex);
		//else
		//	System.out.println("사이다가 존재하지 않는다");
		
		//PhyscData2[] newData= insertObject(data, new PhyscData2("소주다", 179, 1.5));
		//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		//showData("삽입후", newData);
	}

	static void showData(String msg, PhyscData2[]arr) {
		System.out.println(msg);
		for (PhyscData2 pd: arr) {
			System.out.printf("%-8s%3d%5.1f\n", pd.name, pd.height, pd.vision);
		}
		System.out.println();
	}
	
	static void sortData(PhyscData2[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if(data[i].compareTo(data[j]) > 0) {
					PhyscData2 v1 = data[i];
					PhyscData2 v2 = data[j];
					data[i] = v2;
					data[j] = v1;
				}
			}
		}
	}

	// 정렬이 된 배열을 인자로 받는다는 가정 하에 작성함
	static int binarySearch(PhyscData2[] data, String string) {
		
	}
	
}
