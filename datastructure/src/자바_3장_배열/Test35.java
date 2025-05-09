package 자바_3장_배열;

public class Test35 {

	public static void main(String[] args) {
		double[] arr = {1.11, 2.2, 3.3333, 4, 5.555};
		for (double x: arr)
			System.out.print(x + " ");
		
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > 3.3)
				System.out.print(arr[i] + " ");
		}

	}

}
