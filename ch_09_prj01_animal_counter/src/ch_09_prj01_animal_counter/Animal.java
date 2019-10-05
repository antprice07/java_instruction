package ch_09_prj01_animal_counter;

public abstract class Animal implements Countable {
	protected int count;
	
	public Animal() {
	count = 0;
	}

	@Override
	public void incrementCount() {
		count++;
	}

	@Override
	public void resetCount() {
		count = 0;
	}

	@Override
	public int getCount() {
		
		return count;
	}

	@Override
	public String getCountString() {
		
		return null;
	}

}
