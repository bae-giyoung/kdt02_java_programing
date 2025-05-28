package day1;

import java.util.Scanner;

public class P3 {

	public static void main(String[] args) {
		// 입력받은 문자열의 대소문자 변경하기
		
		// 방법1: String은 불변객체이기 때문에 밑의 코드는 새로운 객체를 계속 생성한다. 안 좋은 코드로 생각. 그렇기 때문에 방법2로 풀어봄
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        for (int i = 0; i < a.length(); i++) {
        	String s = String.valueOf(a.charAt(i));
        	
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z')
                answer += s.toUpperCase();
            else if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z')
                answer += s.toLowerCase();
            else
            	answer += s;
        }
        
        System.out.println("[방법1 출력]\n" + answer + "\n");
        
        
        // 방법2
        System.out.println("[방법2 출력]");
        
        for (int i = 0; i < a.length(); i++) {
        	char c = a.charAt(i);
            if (Character.isLowerCase(c))
                System.out.print((char)(c-32));
            else if (Character.isUpperCase(c))
            	System.out.print((char)(c+32));
            else
            	System.out.print(c);
        }
        

	}

}
