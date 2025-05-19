package com.ruby.java.ch08;

//2단계 - 문제 4: 동적바인딩
//Item 추상 클래스
abstract class Item {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량
	
	public Item (String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void reduceStock(int quantity) {
		stockQuantity -= quantity;
	}

	public void show() {
		System.out.print("제품평: " + name + ", 제품 가격: " + price + ", 재고량: " + stockQuantity);
	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics extends Item {
	int madeYear;
	
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}

	@Override
	public void show() {
		super.show();
		System.out.println(", 제조년: " + madeYear);
	}
}

//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;

	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println(", 사이즈: " + size);
	}
}

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;
	
	public double getDiscountRate() {
		return discountRate;
	}

	public SeasonalDiscount(double rate, Customer customer) {
		if (customer instanceof RegularCustomer)
			this.discountRate = RegularCustomer.REGULARDISCOUNT_RATE + rate;
		else
			this.discountRate = PremiumCustomer.PREMIUMDISCOUNT_RATE + rate;
	}
	
	public double getDiscountedPrice(double price) {
		return price * discountRate; // 할인 금액만 리턴!
	}

}

//Order 클래스
class Order extends SeasonalDiscount {
	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items = new Item[N]; // 주문 제품들
	private int[] quantities = new int[N]; // 주문 제품 수량들
	private String[] orderDates = new String[N]; // 주문일자들
	private int count = 0;

	public Order(Customer customer) {
		super(0.2, customer);
	}

	public void addItem(Item item, int quantity, String date) {
		
		// 최대 주문 품목수를 초과했을 때
		if (count >= N) {
			System.out.println("주문 품목은 20개를 초과할 수 없습니다.");
			return;
		}
		
		// 배열의 요소에 할당, count는 0부터 시작
		items[count] = item;
		quantities[count] = quantity;
		orderDates[count] = date;
		
		// 주문 완료 후 재고량 감소, 각 품목 인스턴스 별로
		items[count].reduceStock(quantity);
		
		// count 증가
		count++;
		
	}

	public double calculateTotal() {
		/*
		 * 할인없이 수량 단가로 비용 계산
		 */
		double total = 0;
		for (int i = 0; i < count; i++) {
			total += (items[i].getPrice() * quantities[i]);
		}
		return total;
	}

	public void printOrderSummary() {
		for (int i = 0; i < count; i++) {
			System.out.print("제품명: " + items[i].getName() + ", 가격: " + items[i].getPrice() + ", 주문 수량: " + quantities[i] + ", 정가 금액: " + (items[i].getPrice() * quantities[i]) + "\n");
		}
	}

	//할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		/*
		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액
		 */
		double total = calculateTotal();
		double discountTotal = super.getDiscountedPrice(total); // 할인된 가격
		
		System.out.println("** 정가 금액 합계: " + total + "원");
		System.out.println("** 할인된 가격: " + discountTotal + "원");
		System.out.println("** 할인 적용된 금액: " + (total - discountTotal) + "원");

	}
}

//Customer 추상 클래스 정의
abstract class Customer {
	private String name;
	
	public Customer (String name) {
		this.name = name;
	}
	
	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer(String name) {
		super(name);
	}

	double applyDiscount(double totalAmount) {
		return totalAmount - (totalAmount * REGULARDISCOUNT_RATE); 
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	public PremiumCustomer(String name) {
		super(name);
	}
	
	double applyDiscount(double totalAmount) {
		return totalAmount - (totalAmount * PREMIUMDISCOUNT_RATE);
	}
}

public class 실습과제_8장_B4_동적바인딩 {
	static void showItemsStock(Item[] items) {
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}

	public static void main(String[] args) {
		// Item 타입의 배열 생성
		Item[] items = new Item[4];

		// 배열에 전자제품과 의류패션 객체 추가
		items[0] = new Electronics("노트북", 1500, 100, 23);
		items[1] = new Clothing("티셔츠", 50, 100, 95);
		items[2] = new Electronics("휴대폰", 800, 100, 24);
		items[3] = new Clothing("청바지", 80, 100, 90);

		// 모든 아이템의 이름과 재고량, 가격 출력
		System.out.println("======== [모든 아이템의 이름과 재고량, 가격 출력] ========");
		showItemsStock(items);
		System.out.println();

		// 고객 생성
		Customer regularCustomer = new RegularCustomer("홍길동");
		Customer premiumCustomer = new PremiumCustomer("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order regularOrder = new Order(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		System.out.println("======== [주문 내역, 할인된 내역 출력] ========");
		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails(); // 할인된 내역 출력
		System.out.println();

		// 주문 생성 및 계산 (PremiumCustomer)
		Order premiumOrder = new Order(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");

		System.out.println("======== [주문 내역, 할인된 내역 출력] ========");
		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출력

		// 모든 아이템의 이름과 재고량, 가격 출력
		System.out.println();
		System.out.println("======== [모든 아이템의 이름과 재고량, 가격 출력] ========");
		showItemsStock(items);
		System.out.println();
	}
}
