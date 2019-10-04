package ch08_Inheritance_Demo;

public class InheritanceDemoApp {

	public static void main(String[] args) {

		System.out.println("Welcome!");
		
		Animal dolphin1 = new Dolphin("Flipper", 3, 25, "Mammal", "Tight");
		
		System.out.println(dolphin1.getName());
		System.out.println(dolphin1.getLimbs());
		System.out.println(dolphin1.getAge());
		System.out.println(dolphin1.getType());
		System.out.println(((Dolphin) dolphin1).getBlowHoleSize());
		dolphin1.eat();
		dolphin1.sleep();
		((Dolphin) dolphin1).swims();
		
		
		
	}

}
