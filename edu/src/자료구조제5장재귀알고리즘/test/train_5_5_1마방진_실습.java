package 자료구조제5장재귀알고리즘.test;

/*
 * 마방진: 마법 magic + 정방형 배열 + 배치 진열의 진 > 숫자를 특이하게 배열하여 모든 방향의 합이 일정
 * **매직 스퀘어(Magic Square)**는 n×n 크기의 정사각형 배열에 숫자를 배치하되, 
 * 모든 행, 열, 대각선의 숫자 합이 동일하게 되는 배열을 말합니다. 
 * 이때 이 동일한 합을 **매직 상수(Magic Constant)**라고 합니다.
 * n은 3,5,7 등 홀수일 때
 */
public class train_5_5_1마방진_실습 {

    public static void main(String[] args) {
        int n = 3; // 마방진의 크기
        int[][] magicSquare = new int[n][n];
/*
 * 루벤스의 방법 단계:
1. 첫 번째 숫자를 첫 번째 행의 가운데 열에 배치합니다.
2. 다음 숫자는 항상 대각선 위 오른쪽(북동쪽)으로 이동하여 배치합니다.
    2.1 만약 배열의 경계를 벗어나면 반대편으로 이동합니다.
        예를 들어, 열이 배열의 오른쪽 끝을 벗어나면 맨 왼쪽 열로 이동하고, 
        행이 배열의 맨 위를 벗어나면 맨 아래로 이동합니다.
3. 이미 숫자가 있는 칸에 도달한 경우, 현재 위치 바로 아래의 행으로 이동하여 다음 숫자를 배치합니다.
 */
        // 마방진 생성 알고리즘 (루벤스의 방법)
        int row = 0, col = n / 2; // 시작 위치
        for (int num = 1; num <= n * n; num++) {
        	// 기저조건? 없음. 1~n까지의 숫자 배치후 종료
        	
        	// 처음 시작
        	if(num == 1) {
        		magicSquare[row][col] = num;// 현재 위치에 숫자 배치
        		continue;
        	}
        	
        	// 두번째 부터
    		// 첫 이동 : (row-1, col+1)
    		int nrow = row > 0 ? row-1 : n-1;
    		int ncol = col < n-1 ? col+1 : 0;
    		
    		if(magicSquare[nrow][ncol] == 0) {
    			// 비어있으면 숫자 배치
    			magicSquare[nrow][ncol] = num;
    		}
    		else { 
    			// 비어있지 않은 경우 -> 두번째 이동 : 행만 이동해서 숫자 배치
    			nrow = row < n-1 ? row+1 : 0;
    			ncol = col;
    			magicSquare[nrow][ncol] = num;
    		}
    		
    		row = nrow;
    		col = ncol;
        	
        }

        // 마방진 출력
        showSquare(magicSquare);

        // 마방진의 합 확인
        int magicSum = n * (n * n + 1) / 2;
        System.out.println("가로, 세로, 대각선의 합 =  " + magicSum );
        System.out.println("마방진 검사 = " + checkSquare(magicSquare, magicSum));
    }

    // 마방진 출력 메서드
    static void showSquare(int[][] magicSquare) {
    	System.out.println("======= 마방진 출력 ========");
    	for(int i=0; i<magicSquare.length; i++) {
    		for(int j=0; j<magicSquare[i].length; j++) {
    			System.out.print(magicSquare[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("=========================\n");
    }

    // 마방진 유효성 검증 메서드
    static boolean checkSquare(int[][] magicSquare, int magicSum) {
    	// 각 행과 열의 합, 대각선의 합 전부 같은지 확인. -> 아니면 리턴 false
    	// magicSum과 같은지 확인. -> 아니면 리턴 false
    	
    	int rsum = 0;
    	int csum = 0;
    	int dsum1 = 0;
    	int dsum2 = 0;
    	
    	for(int i=0; i<magicSquare.length; i++) {
    		int nrSum = 0;
    		int ncSum = 0;
    		
    		for(int j=0; j<magicSquare[i].length; j++) {
    			nrSum += magicSquare[i][j]; // 행의 합
    			ncSum += magicSquare[j][i]; // 열의 합 : n*n 행렬이기 때문에 같이 계산
    			if(i == j) dsum1 += magicSquare[i][j]; // 대각선1의 합
    		}
    		if(nrSum != ncSum) return false;
    		
    		// 대각선2의 합
    		dsum2 += magicSquare[i][magicSquare.length - 1 - i]; // n으로 바꾸는게 좋음
    		
    		rsum = nrSum;
    		csum = ncSum;
    	}
    	
    	if(rsum != magicSum || csum != magicSum) return false;
    	if(dsum1 != magicSum || dsum2 != magicSum) return false;
    	
    	return true;
    }
}
