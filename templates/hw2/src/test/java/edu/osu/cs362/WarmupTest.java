package edu.osu.cs362;

import static org.junit.Assert.*;
<<<<<<< HEAD
=======
import org.junit.Test;

>>>>>>> 29ebcd5c56ea003eeab9d860a6815781da7e2055

public class WarmupTest  {
    @Test
    public void testFindIntegerExample() {

		int result = WarmUp.findInteger(new int[] { 1, 2, 3, 4, 5 }, 100);
		assertEquals(result, -1);

		for (int i = 1; i < 5; i++) {
			int result2 = WarmUp.findInteger(new int[] { 1, 2, 3, 4, 5 }, i + 1);
			assertEquals("findInteger(new int[]{1,2,3,4,5}," + i + ")", result2, i);
		}
	}
}
