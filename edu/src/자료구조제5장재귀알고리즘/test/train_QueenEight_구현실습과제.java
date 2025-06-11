package 자료구조제5장재귀알고리즘.test;
//print로 변수 값 확인하는 디버깅 노동 피하자
//이클립스 디버깅 실습 필요 : variables tab, Expressions tab 사용하기
//92개 해 확인 필요
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
/*
 * 8-Queen 문제는 체스판 위에 8개의 퀸을 배치하되, 서로 공격할 수 없도록 배치하는 문제입니다. 
 * 이 문제를 해결하기 위한 비재귀적(스택 기반) 알고리즘을 구현하려면, 다음과 같은 방법을 사용할 수 있습니다.

개요
1. 스택을 사용하여 백트래킹을 구현합니다. 각 스택의 요소는 체스판의 각 열에 대한 퀸의 배치 상태를 나타냅니다.
2. 퀸을 한 줄씩 배치한 후, 유효한지 확인하고, 다음 줄로 이동합니다.
3. 유효하지 않으면 스택을 이용해 이전 상태로 돌아가서 다른 경로를 시도합니다.

알고리즘
1. 스택을 이용하여 백트래킹을 구현하기 때문에, 현재 상태를 스택에 저장합니다. 
   스택의 각 원소는 퀸의 배치를 나타냅니다.
2. 체스판의 각 열에 대해 가능한 위치를 하나씩 확인하면서 퀸을 배치하고, 
   충돌이 발생하지 않는다면 다음 열로 넘어갑니다.
3. 더 이상 유효한 위치가 없으면, 스택에서 이전 상태로 되돌아가서 새로운 경로를 탐색합니다.
4. 퀸을 8개 다 배치하면, 해를 찾은 것이므로 스택을 이용해 해결책을 저장합니다.
 */
class Point5 {
	private int ix;
	private int iy;

	public int getIx() {
		return ix;
	}
	
	public int getIy() {
		return iy;
	}

	public Point5(int x, int y) {
		ix = x;
		iy = y;
	}
}

public class train_QueenEight_구현실습과제 {

	public static void EightQueen(int[][] d) {
		
		// 1. (행렬의 각 성분)시작점 순회 반복
		// 2. 다음 무브가 유효한지 확인
		// 2-1. 유효한 칸이 있으면 옮기고 push
		// 2-2. 유효한 칸이 없으면 pop
		// 종료를 어떻게 할 것인가
		
		int numberOfSolutions = 0; // 정담 92개
		int count = 0;//퀸 배치 갯수
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack<Point5> st = new Stack<Point5>(); //100개를 저장할 수 있는 스택을 만들고
		Point5 p = new Point5(ix, iy);//현 위치를 객체로 만들고
		d[ix][iy] = 1;//현 위치에 queen을 넣었다는 표시를 하고
		count++;
		st.push(p);// 스택에 현 위치 객체를 push
		ix++;//ix는 행별로 퀸 배치되는 것을 말한다.
		iy = 0;//다음 행으로 이동하면 열은 0부터 시작
		while (true) {
			if (st.isEmpty() && ix == 8) //ix가 8이면 8개 배치 완료, stack이 empty가 아니면 다른 해를 구한다 
				break;
			
			Point5 current  = st.peek();
			
			if ((iy = nextMove(d, ix, iy))== -1) {//다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
				// 물리기: pop()
				
				st.pop();
				d[current.getIx()][current.getIy()] = 0; // 물린 자리는 초기화 해주고
				ix++; // 행 바꿔주고
				iy=0; // 열 0부터 초기화 해주고
				count--;
				continue;
			}
			
			// push()
			st.push(new Point5(ix, iy));
			d[ix][iy] = 1;
			ix++;
			iy=0;
			count++;
			
			if (count == 8) { //8개를 모두 배치하면
				// 퀸 새로 배치
				count = 0;
				ix = 0;
				System.out.println("해를 찾음 :"+ (++numberOfSolutions) +"번째 솔루션");
			}
			
			
		}
		System.out.println(numberOfSolutions);
		
	}

//}

public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
	for(int i=0; i<d[crow].length; i++)
		if(d[crow][i] != 0) return false;
	return true;
}

public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
	for(int i=0; i<d.length; i++)
		if(d[i][ccol] != 0) return false;
	return true;
}

//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
	for(int i=0; cx+i<d.length && cy-i>=0; i++) {
		if(d[cx+i][cy-i] != 0) return false;
	}
	for(int i=1; cx-i>=0 && cy+i<d.length; i++) {
		if(d[cx-i][cy+i] != 0) return false;
	}
	return true;
}

//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
	for(int i=0; cx+i<d.length && cy+i<d.length; i++) { // 1,2
		if(d[cx+i][cy+i] != 0) return false;
	}
	for(int i=1; cx-i>=0 && cy-i>=0; i++) {
		if(d[cx-i][cy-i] != 0) return false;
	}
	return true;
}

//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사 : 앞의 함수들을 호출하는 것
public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
	if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
		return true;
	return false;
}

//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴 : checkMove를 호출
public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
	for(int i=0; i<d[row].length; i++) {
		if(checkMove(d, row, i)) return i;
	}
	return -1;
}

static void showQueens(int[][] data) {// 배열 출력

}

public static void main(String[] args) {
	int row = 8, col = 8;
	int[][] data = new int[8][8];
	
	// 체스판 초기화
	for (int i = 0; i < data.length; i++)
		for (int j = 0; j < data[0].length; j++)
			data[i][j] = 0;

	EightQueen(data);

}
}