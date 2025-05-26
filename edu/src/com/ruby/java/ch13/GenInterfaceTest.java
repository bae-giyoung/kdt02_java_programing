package com.ruby.java.ch13;

interface Maxinum<T extends Comparable<T>> {
	T max();
}

class NumUtil<T extends Comparable<T>> implements Maxinum<T> {
	T[] value;
	
	NumUtil(T[] value) {
		this.value = value;
	}
	
	public T max() {
		T v = value[0];
		
		for(int i = 0; i < value.length; i++) {
			if(value[i].compareTo(v) > 0) v = value[i];
		}
		return v;
	}
}

public class GenInterfaceTest {

	public static void main(String[] args) {
		Integer[] inum = {1,2,3,4,5};
		Double[] dnum = {1.0,2.0,3.0,4.0,5.0};
		String[] snum = {"1","2","3","4","5"};
		
		NumUtil<Integer> iutil = new NumUtil<Integer>(inum);
		NumUtil<Double> dutil = new NumUtil<Double>(dnum);
		NumUtil<String> sutil = new NumUtil<String>(snum);

		System.out.println("inum의 최대값 : " + iutil.max());
		System.out.println("dnum의 최대값 : " + dutil.max());
		System.out.println("snum의 최대값 : " + sutil.max());
	}

}
