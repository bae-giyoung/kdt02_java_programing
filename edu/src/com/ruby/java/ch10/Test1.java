package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.HashMap;

class Item {
	String name;
	Integer pid;
	
	public Item (String name, Integer pid) {
		this.name = name;
		this.pid = pid;
	}
	
	@Override
	public String toString() {
		return name + " : " + pid;
	}
}

class ItemA extends Item {
	String size;
	
	public ItemA (String name, Integer pid, String size) {
		super(name, pid);
		this.size = size;
	}
	
	@Override
	public String toString() {
		return name + " : " + pid + " : " + size;
	}
}

class ItemB extends Item {
	String color;
	
	public ItemB (String name, Integer pid, String color) {
		super(name, pid);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return name + " : " + pid + " : " + color;
	}
}

public class Test1 {

	public static void main(String[] args) {
		ItemA a = new ItemA("Name", 100, "XXL");
		ItemB b = new ItemB("Name", 100, "RED");
		
		// ArrayList<> 연습
		ArrayList<Item> list = new ArrayList<>();
		list.add(new ItemA("Name", 100, "XXL"));
		list.add(new ItemB("Name", 100, "XXL"));
		
		for(Item item : list) {
			System.out.println(item);
		}
		
		// HashMap<> 연습
		System.out.println("-".repeat(10));
		HashMap<String, Item> map = new HashMap<>();
		map.put("ItemA", new ItemA("Name", 100, "XXL"));
		map.put("ItemB", new ItemB("Name", 100, "RED"));
		
		System.out.println(map.get("ItemA"));
		
		
		System.out.println("-".repeat(10));
		HashMap<Integer, Item> map2 = new HashMap<>();
		map2.put(1, new ItemA("Name", 100, "XXL"));
		map2.put(2, new ItemB("Name", 100, "RED"));
		
		System.out.println(map2.get(1));
	}

}
