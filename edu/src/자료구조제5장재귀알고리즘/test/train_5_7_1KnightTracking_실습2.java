package 자료구조제5장재귀알고리즘.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/*
 * Knight's Tour 문제는 체스판에서 나이트(Knight) 말이 모든 체스판의 칸을 한 번씩만 방문하면서
 * 체스판의 모든 방을 방문하면 종료. 
 * 나이트는 체스에서 "L" 모양으로 움직이는데, 두 칸 직진하고 한 칸 옆으로 이동하는 방식입니다.
 * 임의 위치에서 시작

문제 설명
체스판은 보통 8x8 크기이지만, 이 문제는 임의의 N x N 체스판에서 해결할 수 있습니다.
목표는 나이트가 시작점에서 출발하여 모든 칸을 한 번씩만 방문하면서 끝나는 경로를 찾는 것입니다.
종료조건: 모든 칸이 방문하였을 때 종료 > 방문한 순서를 출력

구현조건:
(x,y)를 저장하는 point 객체를 사용하여 스택으로 non-recursive backtracking 알고리즘으로 구현
 */

public class train_5_7_1KnightTracking_실습2 {
	private static final int SIZE = 8;
	private static final int[][] board = new int[SIZE][SIZE];
	private static final int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
	private static final int[] yMoves = {1,2,2,1,-1,-2,-2,-1};
	private record Point(int x, int y) {}

    public static void main(String[] args) {
    	initBoard();

        // 나이트가 (0, 0)에서 시작
        if (solve(0, 0)) {
            System.out.println("기사의 여행 성공");
            printBoard();
        } else {
        	System.out.println("기사의 여행 실패");
        }
        
    }

	private static void printBoard() {
		for(int[] row : board) {
			for(int num : row) {
//				System.out.println("%3d", num);
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
	}

	private static boolean solve(int startX, int startY) {
		// 1. 현재 위치 가져오기
		Point current = new Point(startX, startY);
		
		// 2. 보드에 추가
		board[current.y()][current.x()] = 1;
		
		// 3. 가능한 경우의 수를 다 순회
		for (int moveCount=2;moveCount<= SIZE*SIZE;moveCount++) {
			final Point finalCurrent = current;
			
			Optional<Point> nextMove = getPossibleMoves(finalCurrent)
					.min(Comparator.comparingInt(p -> (int) getPossibleMoves(p).count()));
			
			// 이동을 합시다!
			// isValid(nextMove)
			
			if(nextMove.isEmpty()) {
				return false;
			}
			
			current = nextMove.get();
			board[current.y()][current.x()] = moveCount;
		}
		
		return false;
	}
	
	private static Stream<Point> getPossibleMoves(Point p) {
		return Stream.iterate(0, i->i+1)
				.parallel()
				.limit(xMoves.length)
				.map(i->new Point(p.x()+xMoves[i], p.y()+yMoves[i]))
				.filter(train_5_7_1KnightTracking_실습2::isValid);
	}
	
	private static boolean isValid(Point p) {
		return p.x()>=0 && p.x() < SIZE &&
				p.y()>=0 && p.y() < SIZE &&
				board[p.y()][p.x()] == 0;
	}

	private static void initBoard() {
		for(int i=0; i<SIZE; i++) {
				Arrays.fill(board[i], 0);
		}
	}
}
