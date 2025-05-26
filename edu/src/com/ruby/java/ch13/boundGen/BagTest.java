package com.ruby.java.ch13.boundGen;

class Solid {}
class Liquid {}

class Book extends Solid {
	public String toString() {
		return "책";
	}
}
class PencilCase extends Solid {}
class Notebook extends Solid {}
class Water extends Liquid {}
class Coffee extends Liquid {}

class Bag<T extends Solid> { // 타입 제한
	private T thing;
	private String owner;
	
	public Bag(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	boolean isSameOwner(Bag<?> obj) {
		if (this.owner.equals(obj.getOwner()))
			return true;
		return false;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}


public class BagTest {

	public static void main(String[] args) {
		
		Bag<Book> bag = new Bag<Book>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		bag.setOwner("김푸름");
		bag2.setOwner("김푸름");
		
		boolean result = bag.isSameOwner(bag2);
		if(result) System.out.println("소유자가 동일합니다.");
		else System.out.println("소유자가 다릅니다.");

	}

}
