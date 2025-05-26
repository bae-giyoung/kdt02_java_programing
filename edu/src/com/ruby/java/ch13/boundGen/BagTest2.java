package com.ruby.java.ch13.boundGen;

class Bag2<T extends Solid> { // 타입 제한
	private T thing;
	
	public Bag2(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}


public class BagTest2 {

	public static void main(String[] args) {
		
		Bag<Book> bag = new Bag<Book>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		//Bag<Water> bag4 = new Bag<>(new Water()); // 오류 발생
		//Bag<Coffee> bag5 = new Bag<>(new Coffee()); // 오류 발생
		
		

	}

}
