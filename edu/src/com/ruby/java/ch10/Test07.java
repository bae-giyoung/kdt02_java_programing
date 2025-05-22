package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test07 {

	public static void main(String[] args) {
		
		// set과 map계열은 순서를 보장하지 않는다! 밑의 출력도 다른 컴퓨터에선 다른 순서로 출력될 수 있음.
		HashMap<String, String> dic = new HashMap<String,String>();
		
		dic.put("고진감래", "고생 끝에 즐거움이 옴");
		dic.put("분골쇄신", "몸이 부서질 정도로 ");
		dic.put("권토중래", "실패를 발판 삼아");
		dic.put("교학상자", "가르치고 배우면서 서로 성장함");
		dic.put(null, null); //
		
		// 방법1
		Iterator<String> keys = dic.keySet().iterator(); // 밑에 두 개를 한 줄로 체인 코딩 한 것
		//Set<String> set = dic.keySet();
		//Iterator<String> keys = set.iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s: %s", key, dic.get(key)));
//			System.out.printf(String.format("%15s: %50s\n", key, dic.get(key)));
//			System.out.printf(String.format("%15s: -%50s\n", key, dic.get(key)));
		}
		
		// 방법2
		for(Map.Entry<String, String> elem : dic.entrySet()) {
			System.out.println(String.format("%s: %s", elem.getKey(), elem.getValue()));
		}
		
		// 방법3
		for(String key : dic.keySet()) {
			System.out.println(String.format("%s: %s", key, dic.get(key)));
		}

	}

}
