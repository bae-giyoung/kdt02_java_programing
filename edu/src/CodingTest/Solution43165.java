package CodingTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
문제 설명
n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2

입출력 예 #2

+4+1-2+1 = 4
+4-1+2-1 = 4
총 2가지 방법이 있으므로, 2를 return 합니다.
*/


// DFS 문제
// 재귀버전
//재귀 - 기저조건을 만나기 전까지 스택에 쌓는다.
//재귀 - 수렴되어야 스택에서 하나씩 pop.
//재귀 - 그렇기 때문에 무한 재귀 조심!
class RecurSolution {
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}
	
	public int dfs(int[] numbers, int target, int index, int currentSum) {
		if(index == numbers.length) {
			return currentSum == target ? 1 : 0;
		}
		
		int add = dfs(numbers, target, index+1, currentSum + numbers[index]);
		int subt = dfs(numbers, target, index+1, currentSum - numbers[index]);
		
		return add + subt;
	}
}

class StackSolution {
	private static class State {
		int index;
		int currentSum;
		
		public State(int index, int currentSum) {
			super();
			this.index = index;
			this.currentSum = currentSum;
		}
	}
	
	public int solution(int[] numbers, int target) {
		int count = 0;
		Stack<State> stack = new Stack<State>();
		
		stack.push(new State(0,0));
		while(!stack.isEmpty()) {
			State current = stack.pop();
			if(current.index == numbers.length) {
				if(current.currentSum == target) {
					count++;
				}
				continue;
			}
			stack.push(new State(current.index+1, current.currentSum + numbers[current.index]));
			stack.push(new State(current.index+1, current.currentSum - numbers[current.index]));
		}
		
		return count;
	}
}

class QueueSolution {
	private static class State {
		int index;
		int currentSum;
		
		public State(int index, int currentSum) {
			super();
			this.index = index;
			this.currentSum = currentSum;
		}
	}
	
	public int solution(int[] numbers, int target) {
		int count = 0;
		Queue<State> queue = new LinkedList<State>();
		
		queue.offer(new State(0,0));
		while(!queue.isEmpty()) {
			State current = queue.poll();
			if(current.index == numbers.length) {
				if(current.currentSum == target) {
					count++;
				}
				continue;
			}
			queue.offer(new State(current.index+1, current.currentSum + numbers[current.index]));
			queue.offer(new State(current.index+1, current.currentSum - numbers[current.index]));
		}
		
		return count;
	}
}

public class Solution43165 {
	
	public static void main(String[] args) {
		StackSolution stackSol = new StackSolution();
		//QueueSolution queueSol = new QueueSolution();
		//RecurSolution recurSol = new RecurSolution();
		
		int[][] testNumbers = {
				{1, 1, 1, 1, 1},
				{4, 1, 2, 1}
		};
		int[] testTarget = {3,4};
		int[] expectedResults = {5,2};
		for(int i=0; i< testNumbers.length; i++) {
			int[] numbers = testNumbers[i];
			int target = testTarget[i];
			int expectedResult = expectedResults[i];
			
			int stackResult = stackSol.solution(numbers, target);
			if(expectedResult == stackResult) System.out.println("정답");
		}

	}

}
