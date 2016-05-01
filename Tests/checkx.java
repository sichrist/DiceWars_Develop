package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Develop.Field;

public class checkx {

	@Test
	public void testcheckx() {
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].x = 0;

		node[1].x = 1;

		node[2].x = 2;


			assertFalse(Field.checkx(node[0], -1, 3));
			assertTrue(Field.checkx(node[0], 0, 3));
			assertTrue(Field.checkx(node[0], 1, 3));
			
			assertTrue(Field.checkx(node[1], -1, 3));
			assertTrue(Field.checkx(node[1], 0, 3));
			assertTrue(Field.checkx(node[1], 1, 3));
			
			assertTrue(Field.checkx(node[2], -1, 3));
			assertTrue(Field.checkx(node[2], 0, 3));
			assertFalse(Field.checkx(node[2], 1, 3));

	}

}