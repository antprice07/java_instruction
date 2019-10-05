package ch_09_prj01_animal_counter;

public class AnimalCounterApp {

	
	public static void main(String[] args) {
		
		System.out.println("Welcome!");
		System.out.println();
		
		System.out.println("Counting dogs...");
		Dog a = new Dog();
		Dog b = new Dog();
		Dog c = new Dog();
		count(c,3);
		Cat d = new Cat("Bub");
		try {
		Cat e = (Cat)d.clone();
		System.out.println(e.getName());
		}catch (CloneNotSupportedException ed) {
			ed.printStackTrace();
		}
		count(d,3);
	}
	public static void count(Countable c, int maxCount) {
		c.resetCount();
		for(int i = 0;i<maxCount;i++) {
			c.incrementCount();
			System.out.println(c.getCountString());
		}
	}

}
