package 자료구조제4장스택큐;
/*
문제 설명:
괄호로 이루어진 문자열이 주어졌을 때, 각 괄호가 제대로 짝을 이루고 있는지 확인하는 프로그램
괄호에는 <>, (), {}, []가 포함 
여는 괄호가 있을 때, 반드시 짝이 맞는 닫는 괄호가 나와야 하고, 
괄호는 올바르게 중첩되어야 한다.

조건:
  1. 여는 괄호는 반드시 닫는 괄호와 짝을 이뤄야 한다.
  2. 괄호들은 올바르게 중첩되어야 한다.
  3. 괄호 외의 문자는 무시한다.

입력 형식:
  한 줄에 괄호 문자열이 주어지고, 문자열은 괄호 외에도 다른 문자를 포함.

출력 형식:
  괄호가 유효하면 "Valid"를, 유효하지 않으면 "Invalid"를 출력.


*/
import java.util.*;

/*
 * TODO
 * 닫는 태그 먼저 생각해야 하는 이유? -> 아직 모르겠음
 */
public class train_실습4_4_스택응용_괄호매칭검사 {

	// [코드 수정] 다시 작성함! -> Stack<> 사용 및 논리 오류 수정
    public static boolean isValid(String s) {
        //Map<Character, Character> pairs = *** // 사용 추천 "[ ]"을 map 쌍으로 정의
    	HashMap<Character, Character> pairs = new HashMap<Character, Character>();
    	Stack<Character> stk = new Stack<Character>();
    	int opCnt = 0;
    	int clCnt = 0;
    	Character[] opens = {'(','{','[','<'};
    	Character[] closes = {')','}',']','>'};
    	
    	for(int i=0; i<opens.length; i++)
    		pairs.put(opens[i], closes[i]);
    	
    	// 문자열에서 여는 괄호를 추출하여 순서대로 스택에 push하고, (순서 대로 제일 안쪽의 괄호부터)닫히는 괄호가 있으면 stk.peek()와 쌍이 되는 닫는 괄호인지 비교 후 쌍이 맞으면 pop 해줬음. 
    	for(int i=0; i<s.length(); i++) {
    		Character ch = s.charAt(i);
    		
    		if(pairs.containsKey(ch)) {    			
    			stk.push(ch);
    			opCnt++;
    		}
    		
    		if(pairs.containsValue(ch)) {
    			clCnt++;
    			if(stk.size() > 0 && pairs.get(stk.peek()) == ch)
    				stk.pop();
    		}
    	}
    	
    	if(opCnt != clCnt) // 유효하지 않은데, 위의 stk.isEmpty()가 true인 예외 상황: 닫는 태그가 더 많은 경우 }}}}[({})()].....
    		return false;
    	
    	return stk.isEmpty(); // (순서대로) 제일 안쪽의 괄호에서 부터 제거한 결과. 즉 전부 쌍이 맞으면 비어 있음. <({}){}()>...
    }

    public static void main(String[] args) {
 
        String[] cases1 = {
            "(12{as[33<1q2w3e>90]kkk}4r)fg", 
            "<111{ddd[4r(1q2w3e)44]77}jj>kk" ,
            "zz{w(a+b)*[c/d]-<q-e>1+2}w*t", 
            "dd[a+b+c(y*u[abstract]go{234}2w3e)444]ttt" , 
            "a+b<c-d<e%r{123{waste[go[stop(a+b+c(?)$)@]!]*}12}33>c-d>drop",
            "{([])(()[])}"
        };


        String[] cases2 = {
            "a-b-c{1234[3.14(hello)kkk]1>d-w",  
            "a*b*c(121<good[days)gostop>q-w]t-1",  
            "123{hello[a-w-e(w/e/r]\n)\t}qq", 
            "q*t&w{12-34[a+b]*(c/d]-e}123", 
            "12<a/b/c/d{q-t-t[a=c(78::]23;)'8}sss>x+y+w",
            "}}}}}()()",
            "}{}}}{{(){"
        };

        System.out.println("예제1:");
        for (String test : cases1) {
            System.out.println(test + " → " + (isValid(test) ? "Valid" : "Invalid"));
        }

        System.out.println("\n예제2:");
        for (String test : cases2) {
            System.out.println(test + " → " + (isValid(test) ? "Valid" : "Invalid"));
        }
    }
}
