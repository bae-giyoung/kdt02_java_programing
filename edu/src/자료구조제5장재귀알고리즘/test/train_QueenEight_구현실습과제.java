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
		
		int numberOfSolutions = 0;
		int count = 0;//퀸 배치 갯수
		int ix = 0, iy = 0;
		Stack<Point5> st = new Stack<Point5>();
		
		Point5 p = new Point5(ix, iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);
		ix++;
		iy = 0;
		
		int[] rowState = new int[d.length]; // 백트래킹시 참고할 각 행별 iy의 값
		rowState[0] = iy;
		
		while (true) {
			if (st.isEmpty() && iy == d[0].length) {
				break;
			}
			
			
			// 퀸 물리기
			if ((iy = nextMove(d, ix, iy))== -1) {//다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
				
				Point5 current  = st.peek();
				d[current.getIx()][current.getIy()] = 0;
				st.pop();
				
				ix--;
				iy = rowState[ix]+1;
				//iy = current.getIy()+1;
				count--;
				continue;
			}
			
			// 퀸 배치
			st.push(new Point5(ix, iy));
			d[ix][iy] = 1;
			rowState[ix] = iy;
			ix++;
			iy=0;
			count++;
			
			if (count == d.length) { //N개를 모두 배치하면
				System.out.println("\n["+ (++numberOfSolutions) +"번째 솔루션]");
				showQueens(d);
				// 퀸 새로 배치
				Point5 prev = st.peek();
				//iy = prev.getIy()+1;
				d[prev.getIx()][prev.getIy()] = 0;
				st.pop();
				ix--;
				iy = rowState[ix]+1;
				count--;
			}
			
			
		}
		System.out.println("답: " + numberOfSolutions);
		
	}
	
	
	public static boolean checkRow(int[][] d, int crow) {
		for(int i=0; i<d[crow].length; i++)
			if(d[crow][i] != 0) return false;
		return true;
	}
	
	public static boolean checkCol(int[][] d, int ccol) {
		for(int i=0; i<d.length; i++)
			if(d[i][ccol] != 0) return false;
		return true;
	}
	
	//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
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
		for(int i=0; cx+i<d.length && cy+i<d.length; i++) {
			if(d[cx+i][cy+i] != 0) return false;
		}
		for(int i=1; cx-i>=0 && cy-i>=0; i++) {
			if(d[cx-i][cy-i] != 0) return false;
		}
		return true;
	}
	
	//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사 : 앞의 함수들을 호출하는 것
	public static boolean checkMove(int[][] d, int x, int y) {
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		return false;
	}
	
	//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴 : checkMove를 호출
	public static int nextMove(int[][] d, int row, int col) {
		for(int i=col; i<d[row].length; i++) {
			if(checkMove(d, row, i)) return i;
		}
		return -1;
	}
	
	static void showQueens(int[][] data) {
		System.out.println("-------------------");
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		int N = 8;
		int[][] data = new int[N][N]; // 요소는 전부 0으로 초기화 되어 있음.
	
		EightQueen(data);
	
	}
}