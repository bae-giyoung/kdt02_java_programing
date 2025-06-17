package 자료구조제5장재귀알고리즘.test;
/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

import java.util.Stack;

enum Directions {N, NE, E, SE, S, SW, W, NW}
class Items {
	private int x;
	private int y;
	private int dir;
	
	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDir() {
		return dir;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
}

class Offsets {
	private int a;
	private int b;
	
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}

public class train_실습_미로찾기실습과제 {

	static Offsets[] moves = new Offsets[8];
	int[][] maze = new int[14][17];
	int[][] mark = new int[14][17];

	static void path(int[][] maze, int[][] mark, int m, int p) {//m = 출구행위치, p = 출구열위치
		
		// 출발점
		Stack<Items> stk = new Stack<Items>();
		stk.push(new Items(1, 1, 2)); // 다음 위치를 dir부터 탐색 시작
		maze[1][1] = 2;
		mark[1][1] = 1;
		
		while(!stk.isEmpty()) {
			Items current = stk.peek();
			int ix = current.getX();
			int iy = current.getY();
			int dir = current.getDir();
			
			while(dir < moves.length) { // 남은 방향에 대해 dir부터 ~ 7까지 순회 (0~7범위)
				
				// 다음 무브
				int g = ix + moves[dir].getA();
				int h = iy + moves[dir].getB();
				
				if(g == m && h == p) {
					// 미로 찾기 성공하면 마킹 후 종료
					maze[g][h] = 2;
					mark[g][h] = 1;
					return;
				}
				
				if(maze[g][h] == 0 && mark[g][h] == 0) { // 이동할 수 있는 경로 0이고, 방문한 적도 없을 때 0
					stk.push(new Items(g,h,0));
					maze[g][h] = 2;
					mark[g][h] = 1;
					break;
				} else {
					dir++; // 남은 방향 탐색
				}
				
			}
			
			if(dir >= moves.length) {// 경로를 찾지 못함 -> 물리기
				stk.pop();
				Items prev = stk.peek();
				prev.setDir(prev.getDir()+1);
				maze[ix][iy] = 0;
				mark[ix][iy] = 0;
			}
			
		}
		
		if(stk.isEmpty())
			System.out.println("미로 찾기 실패: 출구가 존재하지 않습니다.");
	}
	
	private static void show(String string, int[][] mat) {
		System.out.println(string);
		
		System.out.println("--".repeat(mat[0].length));
		
		for(int i=0; i<mat.length; i++) {			
			for(int j=0; j<mat[i].length; j++) {
				if(j==0) 
					System.out.print("|" + mat[i][j] + " ");
				else if(j==mat[i].length-1) 
					System.out.print(mat[i][j] + " |\n");
				else 
					System.out.print(mat[i][j] + " ");
			}
		}
		
		System.out.println("--".repeat(mat[mat.length-1].length));
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		
		for (int ia = 0; ia < moves.length; ia++)
			moves[ia] = new Offsets(0, 0);
		
		moves[0].setA(-1);		moves[0].setB(0); // N
		moves[1].setA(-1);		moves[1].setB(1); // NE
		moves[2].setA(0);		moves[2].setB(1); // E
		moves[3].setA(1);		moves[3].setB(1); // SE
		moves[4].setA(1);		moves[4].setB(0); // S
		moves[5].setA(1);		moves[5].setB(-1); // SW
		moves[6].setA(0);		moves[6].setB(-1); // W
		moves[7].setA(-1);		moves[7].setB(-1); // NW
		
		// 확장된 미로 만들기: input[][]을 maze[][]로 복사
		for (int i=0; i < maze.length; i++) {
			for (int j=0; j < maze[i].length; j++) {
				if(i==0 || i==maze.length-1 || j==0 || j==maze[i].length-1) // 바깥 울타리
					maze[i][j] = 1;
				else // 안쪽 미로
					maze[i][j] = input[i-1][j-1];
			}
		}
		
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

	}
}
