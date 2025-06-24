package CodingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BFSQueueSolution {
	private static class State {
		String word;
		int depth;
		Set<String> visited;
		
		public State(String word, int depth, Set<String> visited) {
			super();
			this.word = word;
			this.depth = depth;
			this.visited = visited;
		}
	}
	
    public int solution(String begin, String target, String[] words) {
    	// 1. 제일 신나는 케이스: 답 없는 경우
    	if(!Arrays.asList(words).contains(target)) {
    		return 0;
    	}
    	
    	// 2. 제일 신나지 않는 케이스:
    	// words, depth, visited
    	Queue<State> queue = new LinkedList<>();
    	Set<String> visited = new HashSet<>();
    	queue.offer(new State(begin, 0, visited));
    	visited.add(begin);
    	
    	while(!queue.isEmpty()) {
    		State current = queue.poll();
    		
    		if(current.word.equals(target)) {
    			return current.depth;
    		}
    		
    		// hit->hot->dot
    		// current.word->word
    		for(String word : words) {
    			if(!visited.contains(word) && canTransform(current.word, word)) {// 안가본곳이지? && 한글자만 변경했지?
    				visited.add(word);
    				queue.offer(new State(word, current.depth+1, new HashSet<>()));//new HashSet<>()는 의미 없는 빈 객체임!
    			}
    		}
    	}
    	
        return 0;
    }
    
    private boolean canTransform(String word1, String word2) {
    	int diffCount = 0;
    	for(int i=0; i<word1.length(); i++) {
    		if(word1.charAt(i) != word2.charAt(i)) {
    			diffCount++;
    			if(diffCount > 1) {
    				return false;
    			}
    		}
    	}
    	return diffCount == 1;
    }
}

public class Solution43163 {
	
	public static void main(String[] args) {
		
		BFSQueueSolution queueSol = new BFSQueueSolution();
		
		String[][] testWords = {
				{"hot", "dot", "dog", "lot", "log", "cog"},
				{"hot", "dot", "dog", "lot", "log"}
		};
		String[] testBegin = {"hit","hit"};
		String[] testTarget = {"cog","cog"};
		int[] expectedResults = {4,0};
		for(int i=0; i< testWords.length; i++) {
			String[] words = testWords[i];
			String begin = testBegin[i];
			String target = testTarget[i];
			int expectedResult = expectedResults[i];
			
			int result = queueSol.solution(begin, target, words);
			if(expectedResult == result) System.out.println("정답");
		}

	}

}
