package com.ruby.java.ch07.inheritance.test;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;
	
	public Item2(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public void show() {
		System.out.println("제품이름: " + name + ", 가격: " + price + ", 재고: " + stockQuantity);
	}
	
	@Override
	public String toString() {
		return "제품이름: " + name + ", 가격: " + price + ", 재고: " + stockQuantity;
	}

	public void reduceStock(int quantity) {
		
	}

	public void increaseStock(int quantity) {

	}

}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간

	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}

	@Override
	public void show() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return super.toString() + ", 보증기간: " + warranty;
	}
}

//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;
	
	public Clothing (String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size = size;
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return super.toString() + ", 사이즈: " + size + ", 컬러: " + color;
	}
}

//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;
	
	public String getCname() {
		return cname;
	}
	
	public void setCname (String cname) {
		this.cname = cname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void show() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "고객성명: " + cname + ", 도시: " + city + ", 연령: " + age;
	}

	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String name, String city, int age) {
		super.setCname(name);
		super.setCity(city);
		super.setAge(age);
	}

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객 할인 적용
		return totalAmount - (totalAmount * REGULARDISCOUNT_RATE);
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer(String name, String city, int age) {
		super.setCname(name);
		super.setCity(city);
		super.setAge(age);
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount - (totalAmount * PREMIUMDISCOUNT_RATE);
	}
}

//Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount;
	private int step = 0;
	
	public Order2 (Customer2 customer, int itemCount) {
		this.customer = customer;
		this.itemCount = itemCount;
		this.items = new Item2[itemCount];
		this.quantities = new int[itemCount];
	}


	public void addItem(Item2 item, int quantity) {
		items[step] = item;
		quantities[step] = quantity;
		step++;
	}

	public double calculateTotal() {
		int total = 0;
		for (int i = 0; i < itemCount; i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return total;
	}

	public double calculateDiscountedTotal() {
		int discountTotal = 0;
		for (int i = 0; i < itemCount; i++) {
			discountTotal += customer.applyDiscount(items[i].getPrice() * quantities[i]);
		}
		return discountTotal;
	}

	public void printOrderSummary() {
		/*
		 * 할인된 가격의 합계 출력 할인 금액 합계 출력
		 */
		for (int i = 0; i < itemCount; i++) {
			System.out.println("아이템: " + items[i].getName() + ", 단가: " + items[i].getPrice() + ", 주문 수량: " + quantities[i] + ", 금액: " + items[i].getPrice() * quantities[i] + "원" );
		} 
		System.out.println("할인된 가격: " + (this.calculateTotal() - this.calculateDiscountedTotal()) + "원");
		System.out.println("할인된 가격 합계: " + this.calculateDiscountedTotal() + "원");
		

	}
}

public class 실습과제_7장_B2_클래스상속 {

	public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 2); // 4 -> 2여야 하는 것이 아닌가?
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 2); // 4 -> 2여야 하는 것이 아닌가?
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("[Premium Customer Order]");
		order1.printOrderSummary();
		
		System.out.println();
		System.out.println("==================================");
		System.out.println();

		System.out.println("[Regular Customer Order]");
		order2.printOrderSummary();
	}
}
