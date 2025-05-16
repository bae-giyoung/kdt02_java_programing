package com.ruby.java.ch07.inheritance.test;

//Discountable 인터페이스 정의 -시즌 할인율 적용
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;

	@Override
	public double getDiscountedPrice(double price) {
		return price - (discountRate * price);
	}
}

//Item 추상 클래스
abstract class Item3 {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

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

	public void reduceStock(int quantity) {

	}

	public void show() {
		System.out.println("제품명: " + name + ", 가격: " + price + ", 재고: " + stockQuantity);
	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	int madeYear;
	
	public Electronics3 (String name, int price, int stockQuantity, int madeYear) {
		super();
		setName(name);
		setPrice(price);
		setStockQuantity(stockQuantity);
		this.madeYear = madeYear;
	}
	
	@Override
	public void show() {
		System.out.println("제품명: " + getName() + ", 가격: " + getPrice() + ", 재고: " + getStockQuantity() + ", 제조년: " + madeYear);
	}
}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	int size;
	
	public Clothing3 (String name, int price, int stockQuantity, int size) {
		super();
		setName(name);
		setPrice(price);
		setStockQuantity(stockQuantity);
		this.size = size;
	}

	@Override
	public void show() {
		System.out.println("제품명: " + getName() + ", 가격: " + getPrice() + ", 재고: " + getStockQuantity() + ", 제조년: " + size);	
	}
}

//Order 클래스
class Order3 extends SeasonalDiscount {
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private int count = 0; // 왜 static을 썼을까? 일단은 static 지워봄
	
	public Order3(Customer3 customer) {
		super();
		this.customer = customer;
	}

	public void addItem(Item3 item, int quantity, String date) {
		// 기존의 배열 저장, 첫번째 addItem수행일 경우엔 상요하지 않음.
		Item3[] oldItems = items;
		int[] oldQuantities = quantities;
		String[] oldOrderDates = orderDates;
		
		
		// 새로운 길이의 배열, 길이는 1부터
		count++;
		items = new Item3[count];
		quantities = new int[count];
		orderDates = new String[count];
		
		if (count == 1) {
			items[0] = item;
			quantities[0] = quantity;
			orderDates[0] = date;
			
		} else {
			for (int i = 0; i < count; i++) {
				if (i < count -1) {
					items[i] = oldItems[i];
					quantities[i] = oldQuantities[i];
					orderDates[i] = oldOrderDates[i];
				} else {
					items[i] = item;
					quantities[i] = quantity;
					orderDates[i] = date;					
				}
			}
		}
		
	}

	public double calculateTotal() {
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return customer.applyDiscount(total);
	}

	public void printOrderSummary() {
		for (int i = 0; i < count; i++) {
			System.out.println("아이템: " + items[i].getName() + ", 가격: " + items[i].getPrice() + ", 주문수량: " + quantities[i] + ", 금액: " + (items[i].getPrice() * quantities[i]) + ", 주문일: " + orderDates[i]);
		}
		System.out.println("총금액: " + calculateTotal());
	}

	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		/*
		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액
		 */
		System.out.println("[시즌 할인 수식이 어디에 있을까?]");
	}
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer3(String name) {
		super();
		setName(name);
	}

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객은 추가 할인 없음
		return totalAmount - (totalAmount * REGULARDISCOUNT_RATE);
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	public PremiumCustomer3(String name) {
		super();
		setName(name);
	}

	@Override
	double applyDiscount(double totalAmount) {
		double seasonalDiscountRate = 0;
		
		return totalAmount - (PREMIUMDISCOUNT_RATE + seasonalDiscountRate) * totalAmount;
	}
}

public class 실습과제_7장_B3_인터페이스 {
	public static void main(String[] args) {
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails(); // 할인된 내역 출력

		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		System.out.println();
		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출력
	}
}
