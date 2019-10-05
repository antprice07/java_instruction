package ch_09_prj01_animal_counter;

public class Dog extends Animal implements Countable {
	
	public Dog() {
		super();
	}
	
	@Override
	public String getCountString() {
		return count + "Dog";
	}

}
