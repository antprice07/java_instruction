package ch_09_prj01_animal_counter;

public class Cat extends Animal implements Cloneable {

	private String name;
	
	public Cat(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getCountString() {
		return count + " "+name;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Cat)super.clone();
	
	}
}
