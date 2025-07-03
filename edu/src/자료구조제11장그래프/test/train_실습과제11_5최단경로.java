package 자료구조제11장그래프.test;
//최단거리 (heap 사용)
//- 1. Node 객체를 생성(vertex, distance)
//- 최소 거리 비교를 위해서 coparator 등을 활용
//- 2. PriorityQueue<Node>
//public void shortestPath(int startNode) {
// Arrays.fill(s, false);
// Arrays.fill(dist, MAX_WEIGHT);
// PriorityQueue<Node> pq = new PriorityQueue<>();
// s[startNode] = true;
// pq.offer(new Node(startNode, 0);
//
// while(!pq.isEmpty()) {
//	// 1. 거리가 가장 짧은 노드 선택
//	// 2. 이미 선택된 노드이면 제외
//	// 3. 선택되지 않은 노드이면 방문 처리
//	// 4. 인접한 모든 노드에 대해서 거리 갱신
//	// 4-1. 더 짧은 거리를 발견하면 heap에 추가
// }
// printDistantces(startNode);
//}
import java.util.Arrays;
import java.util.Scanner;

class Graph5 {
    private static final int NMAX = 10;
    private static final int MAX_WEIGHT = 999999;

    private int[][] length = new int[NMAX][NMAX];
    private int[] dist = new int[NMAX]; // 각 노드
    private boolean[] s = new boolean[NMAX]; // 방문했는지 저장하는 배열
    private final int n;
    
    public Graph5(int nodeSize) {
    	this.n = nodeSize;
    	for(int i=0; i<n; i++) {
    		Arrays.fill(length[i], MAX_WEIGHT); // 행렬의 모든 원소를 max_weight로 초기화
    		length[i][i] = 0; // 자기 자신과의 연결, 주대각선은 0으로 초기화 
    	}
    }

    public void insertEdge(int start, int end, int weight) { // 거리 비용을 값으로 가지는 간선!
    	length[start][end] = weight; // A(행)-C(열), 인접행렬의 우상삼각, 방향 그래프
    	//length[end][start] = weight; // C-A
    }

    public void displayConnectionMatrix() {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(length[i][j] == MAX_WEIGHT)
    				System.out.print("∞ ");
    			else
    				System.out.print(length[i][j] + " ");
    		}
    		System.out.println();
    	}
    }

    public boolean isNonNegativeEdgeCost() {
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(length[i][j] < 0)
    				return false;
    		}
    	}
    	return true;
    }

    public void shortestPath(int startNode) {
    	// 초기화
        Arrays.fill(s, false); // 함수 여러번 호출할 때 초기화를 위함
        for (int i = 0; i < n; i++) {
            dist[i] = length[startNode][i]; // 인접행렬에서 startNode의 행만 떼어 옴
        }
        s[startNode] = true; // 자기 자신과의 거리, 방문 여부 설정
        dist[startNode] = 0;

        // startNode에서 각 노드까지의 최단거리 계산
        for (int i = 0; i < n - 1; i++) { // i는 의미 없고, 횟수만 의미 있음, 자기 자신을 제외한 각 노드의 개수만큼 순회
        	// 방문한 적 없는 가장 작은 값을 가져오고, 방문 기록 남기기, 가장 작은 값이니 여기서는 값 업데이트 필요 없음
        	int u = choose();
        	s[u] = true;
        	// 최단거리를 합산해서 기록, 업데이트
        	for(int j=0; j < n; j++) { // 여기서 j는 의미가 있음. 인덱스값으로 사용
        		if(!s[j] && length[u][j] + dist[u] < dist[j]) {// u=1, j=2, 
        			dist[j] = length[u][j] + dist[u];
        		}
        	}
        }
        printDistances(startNode);
    }

    private int choose() {
        int minDist = MAX_WEIGHT;
        int minPos = -1;
        
        // 가중치 가장 작은 것 구하기
        for(int i=0; i<n; i++) {
        	if(!s[i] && dist[i] < minDist) {
        		minDist = dist[i];
        		minPos = i;
        	}
        }
        return minPos;
    }

    private void printDistances(int startNode) {
        System.out.print("출발노드 " + startNode + ": ");
        for (int i = 0; i < n; i++) {
        	System.out.print("->("+i+")");
            System.out.print((dist[i] == MAX_WEIGHT ? "∞" : dist[i]) + " ");
        }
        System.out.println();
    }
}

public class train_실습과제11_5최단경로 {
	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
    public static int[][] makeGraph1() {
        return new int[][]{
            {0, 6, 5, 7, 0, 0, 0},
            {6, 0, -2, 0, -1, 0, 0},
            {5, -2, 0, -2, 1, 0, 0},
            {7, 0, -2, 0, 0, -1, 0},
            {0, -1, 1, 0, 0, 0, 3},
            {0, 0, 0, -1, 0, 0, 8},
            {0, 0, 0, 0, 3, 8, 0}
        };
    }

    public static int[][] makeGraph2() {
        return new int[][]{
            {0, 300, 1000, 0, 0, 0, 0, 1700},
            {300, 0, 800, 0, 0, 0, 0, 0},
            {1000, 800, 0, 1200, 0, 0, 0, 0},
            {0, 0, 0, 1200, 1500, 1000, 0, 0},
            {0, 0, 0, 1500, 0, 250, 0, 0},
            {0, 0, 0, 1000, 250, 0, 900, 1400},
            {0, 0, 0, 0, 0, 900, 0, 1000},
            {1700, 0, 0, 0, 0, 1400, 1000, 0}
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph5 g = null;

        System.out.println("1: 그래프(가중치 마이너스), 2: 그래프(도시간 거리)");
        int select = scanner.nextInt();
        if (select == 1) {
            int[][] matrix = makeGraph1();
            showMatrix(matrix);
            g = new Graph5(7);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else if (select == 2) {
            int[][] matrix = makeGraph2();
            showMatrix(matrix);
            g = new Graph5(8);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.print("\nCommands: 1: Display Matrix, 2: Dijkstra (non-negative), 3: Quit => ");
            select = scanner.nextInt();
            if (select == 3) break;

            switch (select) {
                case 1:
                    g.displayConnectionMatrix();
                    break;
                case 2:
                    if (g.isNonNegativeEdgeCost()) {
                        System.out.print("Start node: ");
                        int startNode = scanner.nextInt();
                        g.shortestPath(startNode);
                    } else {
                        System.out.println("Negative edge가 존재하므로 Bellman-Ford 알고리즘 사용해야 한다.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
}
