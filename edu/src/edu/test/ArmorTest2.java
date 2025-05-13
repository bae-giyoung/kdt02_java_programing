package edu.test;

public class ArmorTest2 {

	public static void main(String[] args) {
		Armor suit = new Armor();
		
		// nullPoingerException 에러
		//suit = null;
		
		suit.setName("mark6");
		suit.setHeight(180);
		
		System.out.println(suit.getName() + " : " + suit.getHeight());

	}

}
