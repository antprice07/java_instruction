package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountATest {
	JUnitTesting jut = new JUnitTesting();

	@Test
	public void test() {
		String str = "A wonderful day in the neighborhood.";
		String fail="Failure. Haha.";
		
		assertEquals(2,jut.countA(str));
		assertEquals(1,jut.countA(fail));
	}

}
