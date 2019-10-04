package ch08_Inheritance_Demo;

public class Dolphin extends Animal {
	private String blowHoleSize;

	public Dolphin(String name, int limbs, int age, String type,String blowHoleSize) {
		super(name, limbs, age, type);
		this.blowHoleSize=blowHoleSize;
	}

	public String getBlowHoleSize() {
		return blowHoleSize;
	}

	public void setBlowHoleSize(String blowHoleSize) {
		this.blowHoleSize = blowHoleSize;
	}
	
	public void swims() {
		System.out.println(name + " swims.");
	}

}
