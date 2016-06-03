package de.htwg.se.dicewars.BoardSetup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Fieldsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public class FieldSetupTest {

	@Test
	public final void testCheckx() {
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setX(0);

		node[1].setX(1);

		node[2].setX(2);

		assertFalse(Fieldsetup.checkx(node[0], -1, 3));
		assertTrue(Fieldsetup.checkx(node[0], 0, 3));
		assertTrue(Fieldsetup.checkx(node[0], 1, 3));

		assertTrue(Fieldsetup.checkx(node[1], -1, 3));
		assertTrue(Fieldsetup.checkx(node[1], 0, 3));
		assertTrue(Fieldsetup.checkx(node[1], 1, 3));

		assertTrue(Fieldsetup.checkx(node[2], -1, 3));
		assertTrue(Fieldsetup.checkx(node[2], 0, 3));
		assertFalse(Fieldsetup.checkx(node[2], 1, 3));
	}

	@Test
	public final void testChecky() {
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setY(0);

		node[1].setY(1);

		node[2].setY(2);

		assertFalse(Fieldsetup.checky(node[0], -1, 3));
		assertTrue(Fieldsetup.checky(node[0], 0, 3));
		assertTrue(Fieldsetup.checky(node[0], 1, 3));

		assertTrue(Fieldsetup.checky(node[1], -1, 3));
		assertTrue(Fieldsetup.checky(node[1], 0, 3));
		assertTrue(Fieldsetup.checky(node[1], 1, 3));

		assertTrue(Fieldsetup.checky(node[2], -1, 3));
		assertTrue(Fieldsetup.checky(node[2], 0, 3));
		assertFalse(Fieldsetup.checky(node[2], 1, 3));
	}

	@Test
	public final void testCheckNeighborIndex() {
		Board field = new Board();
		Field node[] = new Field[9];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();
		node[3] = new Field();
		node[4] = new Field();
		node[5] = new Field();
		node[6] = new Field();
		node[7] = new Field();
		node[8] = new Field();

		node[0].setY(0);
		node[0].setX(0);
		node[1].setY(1);
		node[1].setX(0);
		node[2].setY(2);
		node[2].setX(0);
		node[3].setY(0);
		node[3].setX(1);
		node[4].setY(1);
		node[4].setX(1);
		node[5].setY(2);
		node[5].setX(1);
		node[6].setY(0);
		node[6].setX(2);
		node[7].setY(1);
		node[7].setX(2);
		node[8].setY(2);
		node[8].setX(2);

		assertFalse(Fieldsetup.checkNeighborIndex(node[0], -1, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[0], -1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[0], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[0], 0, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[0], 0, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[0], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[0], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[0], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[0], 1, -1, 3));

		assertFalse(Fieldsetup.checkNeighborIndex(node[1], -1, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[1], -1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[1], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[1], 0, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[1], 0, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[1], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[1], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[1], -1, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[1], 1, -1, 3));

		assertFalse(Fieldsetup.checkNeighborIndex(node[2], -1, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[2], -1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[2], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[2], 0, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[2], 0, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[2], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[2], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[2], -1, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[2], 1, -1, 3));

		assertFalse(Fieldsetup.checkNeighborIndex(node[3], -1, -1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[3], -1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[3], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[3], 0, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[3], 0, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[3], 1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[3], 1, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[3], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[3], 1, -1, 3));

		assertFalse(Fieldsetup.checkNeighborIndex(node[4], -1, -1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[4], -1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[4], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[4], 0, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[4], 0, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[4], 1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[4], 1, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[4], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[4], 1, -1, 3));

		assertFalse(Fieldsetup.checkNeighborIndex(node[5], -1, -1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[5], -1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[5], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[5], 0, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[5], 0, 1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[5], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[5], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[5], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[5], 1, -1, 3));

		assertFalse(Fieldsetup.checkNeighborIndex(node[6], -1, -1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[6], -1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[6], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[6], 0, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[6], 0, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[6], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[6], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[6], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[6], 1, -1, 3));

		assertTrue(Fieldsetup.checkNeighborIndex(node[7], -1, -1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[7], -1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[7], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[7], 0, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[7], 0, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[7], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[7], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[7], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[7], 1, -1, 3));

		assertTrue(Fieldsetup.checkNeighborIndex(node[8], -1, -1, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[8], -1, 0, 3));
		assertTrue(Fieldsetup.checkNeighborIndex(node[8], 0, -1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[8], 0, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[8], 0, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[8], 1, 0, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[8], 1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[8], -1, 1, 3));
		assertFalse(Fieldsetup.checkNeighborIndex(node[8], 1, -1, 3));
	}

	@Test
	public final void testGetNeighborfromIndex() {
		Board testField = new Board();
		assertEquals(7, Fieldsetup.getNeighborfromIndex(-1, -1));
		assertEquals(3, Fieldsetup.getNeighborfromIndex(-1, 0));
		assertEquals(2, Fieldsetup.getNeighborfromIndex(0, -1));
		assertEquals(1, Fieldsetup.getNeighborfromIndex(1, 0));
		assertEquals(0, Fieldsetup.getNeighborfromIndex(0, 1));
		assertEquals(6, Fieldsetup.getNeighborfromIndex(1, -1));
		assertEquals(4, Fieldsetup.getNeighborfromIndex(-1, 1));
		assertEquals(6, Fieldsetup.getNeighborfromIndex(0, 0));
		assertEquals(5, Fieldsetup.getNeighborfromIndex(1, 1));
		assertEquals(-1, Fieldsetup.getNeighborfromIndex(-3, -1));
		assertEquals(-1, Fieldsetup.getNeighborfromIndex(3, 1));
	}

	@Test
	public final void testSetNeigbors() {
		Board board = new Board();
		Field[][] field = new Field[3][3];

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				field[j][i] = new Field();
				field[j][i] = Fieldsetup.mallocNodes(field[j][i]);
				field[j][i].setX(j);
				field[j][i].setY(i);

			}
		}

		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[0], field[0][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[1], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[2], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[3], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[0], field[0][2]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[1], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[2], field[0][0]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[3], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[6], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[0], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[1], field[1][2]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[2], field[0][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[3], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[6], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[0], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[1], field[2][0]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[2], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[3], field[0][0]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[4], field[0][1]);// FALSCH
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[5], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[0], field[1][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[1], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[2], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[3], field[0][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[4], field[0][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[5], field[2][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[0], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[1], field[2][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[2], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[3], field[0][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[0], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[1], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[2], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[3], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[0], field[2][2]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[1], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[2], field[2][0]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[3], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[7], field[1][0]);

		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[0], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[1], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[2], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[3], field[1][2]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[7], field[1][1]);
	}

	@Test
	public final void testSetFieldNumber() {
		int ctr = 1;
		Board board = Boardsetup.createField(16, 9);
		Field[][] field = board.getField();
		for (int j = 0; j < board.getLength(); j++) {
			for (int i = 0; i < board.getLength(); i++) {
				Fieldsetup.setFieldNumber(field, j, i);
				if (field[j][i] == null) {
				}

				else {
					assertEquals(ctr, field[j][i].getFieldNumber());
				}
				ctr = ctr + 1;
			}
		}

	}

	@Test
	public final void testhandOutFields() {
		int numberOfFields = 49;
		int[] list = new int[6];
		int tmp = 0;
		Fieldsetup.handOutFields(list, numberOfFields);
		for (int i = 0; i < list.length; i++) {
			tmp += list[i];
		}
		assertEquals(numberOfFields, tmp);
	}

	@Test
	public final void testhandleRest() {
		int[] list = new int[5];
		int rest = 5;
		int tmp = 0;
		for (int i = 0; i < list.length; i++) {
			list[i] = 0;
		}
		Fieldsetup.handleRest(list, rest);
		for (int i = 0; i < list.length; i++) {
			tmp += list[i];
		}
		assertEquals(rest, tmp);
	}

}
