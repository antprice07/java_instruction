package ch08_Inheritance_Demo;

public abstract class Animal {
	
	protected String name;
	protected int limbs;
	protected int age;
	protected String type;
	
	public Animal(String name, int limbs, int age, String type) {
		this.name=name;
		this.limbs=limbs;
		this.age=age;
		this.type=type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLimbs() {
		return limbs;
	}

	public void setLimbs(int limbs) {
		this.limbs = limbs;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void eat() {
		System.out.println(name + " eats.");
		
	}
	
	public void sleep() {
		System.out.println(name + " sleeps.");
	}

}
