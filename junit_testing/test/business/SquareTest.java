package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

	@Test
	public void jUSquareTest() {
		JUnitTesting jut = new JUnitTesting();
		assertEquals(25,jut.square(5));
		assertEquals(35,jut.square(6));
	}

}
