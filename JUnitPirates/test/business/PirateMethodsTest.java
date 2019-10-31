package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class PirateMethodsTest {

	@Test
	public void deadTest() {
		Pirate p = new Pirate("Pete");
		
		assertFalse(p.isDead());
	}

}
