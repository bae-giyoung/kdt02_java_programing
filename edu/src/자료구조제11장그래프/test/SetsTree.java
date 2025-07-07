package 자료구조제11장그래프.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetsTree {
// 서로소 집합
	// private Map<Integer, Integer> parent;
	// private Map<Integer, Integer> rank;
    private int[] parent;
    private int n;

    public SetsTree(int sz) {
        n = sz;
        parent = new int[sz + 1]; // Don't want to use parent[0] // parent는 배열!
        Arrays.fill(parent, -1);  // Initialize with -1
    }
    
    //connected - 두 정점이 연결되어 있는지 확인
    public boolean connected(int i, int j) {
    	return find(i) == find(j);
    }
    
    void displaySets() {
    	//{1,2,3} 등으로 set을 표시하기
    	Map<Integer, List<Integer>> sets = new HashMap<>();
    	for (int i = 1; i <= n; i++) {
    		int root = find(i);
    		sets.computeIfAbsent(root, k -> new ArrayList<>()).add(i);// 이 메서드 사용하면 키 있고 없고 중복 확인하는 코드를 줄일 수 있음
    	}    	    	
    	System.out.println("현재 집합 상태");
    	sets.forEach((root, element) -> { // 인덱스 기반이 아니라 객체 기반으로 반복문을 도는 메소드
    		System.out.println("{" + element.stream().sorted()
    				.map(String::valueOf).collect(java.util.stream.Collectors.joining(", "))
    				+ "}");
    	});
    	System.out.println("현재 집합 상태");
    }
    
    public void display() {
        System.out.print("display:index=  ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("display:value= ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", parent[i]);
        }
        System.out.println();
    }
    
    public void delete(int n) {//root를 삭제할 때 문제 있다
    	if (n <= 0 || n > this.n) {
    		System.out.println("잘못된 매개변수 입니다.");
    		return;
    	}
    	
    	//n이 root이거나 non-leaf 일 문제 해결 필요
    	//root를 삭제할 때 문제 있다 -> 독립 집합 분리
    	//int root = find(n);
    	
    	parent[n] = -1; // root일 때, root가 아닐 때
    }
    
    // delete를 정말로 진지하게 고민? => L.L
    
    
    // 경로 압축
    public int find(int i) {
    	if (parent[i] < 0) {// i가 root 인가요?
    		return i;
    	}
    	return parent[i] = find(parent[i]); // 경로 압축: 부모를 루트에 연결
    }

    public void simpleUnion(int i, int j) { // 5, 7
        // Replace the disjoint sets with roots i and j, i != j with their union
        i = simpleFind(i); // i가 속한 집합의 루트 // 5 => 4 안에 아무것도 없으면 인덱스값을 가져옴!
        j = simpleFind(j); // j가 속한 집합의 루트 // 7 => 6
        if (i == j) return; // 이미 같은 집합이라는 뜻!
        parent[j] = i; // j가 root i가 값 // 6 => 4
    }

    public int simpleFind(int i) { // i = 3
        // Find the root of the tree containing element i
    	// the root: 최상단
    	// root(parent): 자기의 parent
    	
    	// i번째 원소를 찾아줘 => 찾았으면 원소의 값을 반환해줘
    	// 못찾았으면 "i"번째 원소를 전달
    	
    	// 못찾았음
    	while(parent[i] >= 0) { // 5
    		i = parent[i];
    	}
    	return i;
    	
    	// 찾았음
    }

    public void weightedUnion(int i, int j) {
        // Union sets with roots i and j, using the weighting rule.
    	// count가 작은 놈이 큰데 붙는다!
        i = find(i); // 경로 압축 메서드
        j = find(j);
        if (i == j) return;
        
        
        // 더 작은 집합을 더 큰 집합 아래에 둔다.
        if (parent[i] < parent[j]) {
        	parent[i] += parent[j]; // 병합
        	parent[j] = i; // j를 i의 자식으로 만듬
        } else {
        	parent[j] += parent[i]; // 병합
        	parent[i] = j; // i를 j의 자식으로 만듬
        }
        
        // 기존 코드
//        i = simpleFind(i);
//        j = simpleFind(j);
//        if (i == j) return;
//        
//        if(parent[i] > parent[j]) { // j의 집합 개수가 작다.
//        	parent[i] = j;
//        	parent[j]--;// count 개수 음으로 증가 -1부터 시작
//        }else {
//        	parent[j] = i;
//        	parent[i]--;
//        }

    }
}
