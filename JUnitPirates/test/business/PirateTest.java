package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class PirateTest {

	@Test
	public void pirateConstructorTest() {
		Pirate p = new Pirate("Sam");
		assertEquals("Sam",p.getName());
		assertEquals(4,p.getLimbsRemaining());
	}
	
	@Test
	public void octoPirateTest() {
		Pirate p = new Pirate("OctoPete",8);
		assertEquals("OctoPete",p.getName());
		assertEquals(8,p.getLimbsRemaining());
	}
	
	

}
