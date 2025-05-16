package com.ruby.java.ch07.inheritance.test;

class Item { // 제품
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량
    
    public Item (String name, double price) {
    	this.name = name;
    	this.price = price;
    }
    
    public Item (String name, double price, int stockQuantity) {
    	this.name = name;
    	this.price = price;
    	this.stockQuantity = stockQuantity;
    }
    
    // 재고 감소 메소드
    public void reduceStock(int quantity) {
    	
    }

    // 재고 증가 메소드
    public void increaseStock(int quantity) {

    }

    // 정보 출력 메소드
    public void show() {
    	System.out.println("name: " + name + ", price: " + price + ", stockQuantity: " + stockQuantity);        
    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", stockQuantity: " + stockQuantity;
    }

    // 접근자 메소드
    public String getName() {
    	return this.name;
    }

    public double getPrice() {
    	return this.price;
    }
}

class Customer {
    private String cname;
    private String city;
    private int age;
    
    public Customer(String cname, String city, int age) {
    	this.cname = cname;
    	this.city = city;
    	this.age = age;
    }

    // 정보 출력 메소드
    public void show() {
        System.out.println("cname: " + cname + ", city: " + city + ", age: " + age);
    }

    @Override
    public String toString() {
       return "cname: " + cname + ", city: " + city + ", age: " + age; 
    }
}

class Order {
    private Customer customer; // 고객
    private Item[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private String []orderDates;
    private int count; // 아이템 개수
    private int step = 0;
    
    public Order(Customer customer, int count) {
    	this.customer = customer;
    	this.count = count;
    	this.items = new Item[count];
    	this.quantities = new int[count];
    }
    
    // 아이템 추가 메소드
    public void addItem(Item item, int orderQuantity) {    	
    	this.items[step] = new Item(item.getName(), item.getPrice());
    	this.quantities[step] = orderQuantity; // index	
    	step++;
    }

    // 총액 계산 메소드
    public double calculateTotal() {
    	int acc = 0;
    	for (int i = 0; i < count; i++) {
    		acc += items[i].getPrice() * quantities[i];
    	}
    	return acc;
    }

    // 주문 요약 출력 메소드
    public void printOrderSummary() {
    	for (int i = 0; i < count; i++) {
    			System.out.println("아이템: " + items[i].getName() + ", 단가: " + items[i].getPrice() + ", 주문 수량: " + quantities[i] + ", 금액: " + items[i].getPrice() * quantities[i] + "원" + ", 주문일: ");
    	}
    	System.out.println("총액: " + this.calculateTotal());
    }
}
public class 실습과제_7장_B1_객체생성 {
    public static void main(String[] args) {
        // 아이템 생성
        Item laptop = new Item("노트북", 1200.00, 10);
        Item tshirt = new Item("티셔츠", 20.00, 50);
        Item phone = new Item("휴대폰", 800.00, 30);
        Item headphones = new Item("헤드폰", 150.00, 20);
        Item mouse = new Item("마우스", 30.00, 15);

        // 고객 생성
        Customer boy = new Customer("홍길동", "부산", 21);
        Customer girl = new Customer("계백", "양산", 22);

        // 주문 생성
        Order order1 = new Order(boy, 5); // 최대 5개 아이템
        order1.addItem(laptop, 1);
        order1.addItem(tshirt, 2);
        order1.addItem(phone, 1);
        order1.addItem(headphones, 1);
        order1.addItem(mouse, 1);

        Order order2 = new Order(girl, 5); // 최대 5개 아이템
        order2.addItem(laptop, 1);
        order2.addItem(tshirt, 1);
        order2.addItem(phone, 1);
        order2.addItem(headphones, 1);
        order2.addItem(mouse, 1);

        // 주문 요약 출력
        boy.show();
        order1.printOrderSummary();
        
        System.out.println();
        System.out.println("==========================================================");
        System.out.println();
        
        girl.show();
        order2.printOrderSummary();
        
    }
}
