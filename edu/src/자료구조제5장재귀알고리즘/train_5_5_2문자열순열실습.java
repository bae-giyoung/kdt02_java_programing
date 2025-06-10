package 자료구조제5장재귀알고리즘;

/*
/* void permutate(char []arr, int k)
 * {
 *//*generate all the permuations of arr[0],..., arr[m] where m은 사이즈
    if (k ==m) {//permutation 출력
/*    	for (char c : arr)
    		sysout
    }
    else {
    	for (int i = k; i <= m; i++) {
    		swap(arr, k,i);
    		permutate(arr, k+1);
    		swap(arr, k,i);
    	}
    }
*/
public class train_5_5_2문자열순열실습 {

    // 주어진 문자 배열의 순열을 생성하는 함수
    public static void permutate(char[] arr, int index) {
        
    }

    // 두 요소를 교환하는 함수
    public static void swap(char[] arr, int i, int j) {

    }

    public static void main(String[] args) {
        // 문자열을 문자 배열로 변환
        String l = "abcde";
        char[] arr = l.toCharArray();

        // 순열 생성 및 출력
        permutate(arr, 0);
    }
}
