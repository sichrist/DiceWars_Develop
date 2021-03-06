package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.util.Fieldhandler;

public class FieldHandlerTest {

	@Test
	public final void countConnectedFields() {
		Boardsetup boardsetup = new Boardsetup();
		IBoard board = new Board();
		board = boardsetup.createField(9, 7);
		IField field[][] = board.getField();
		IField dummyfield = new Field();
		int flds = 0;
		IPlayer player = new Player();

		player.setName("simon");

		for (int i = 0; i < board.getLength(); i++) {
			for (int j = 0; j < board.getLength(); j++) {
				if (field[i][j] == null) {
					dummyfield.setFieldNumber((i * field.length) + j + 1);
					dummyfield.setX(i);
					dummyfield.setY(j);
					field[i][j] = dummyfield;
				}
			}
		}

		flds = Fieldhandler.countConnectedFields(board.getField(), null);

		assertEquals(7, flds);

		board = boardsetup.createField(9, 9);
		field = board.getField();

		field[0][0].setOwner(player);
		field[0][1].setOwner(player);
		field[0][2].setOwner(player);
		field[2][2].setOwner(player);

		player.setField(field);

		flds = Fieldhandler.countConnectedFields(field, player);

		assertEquals(3, flds);

		field[1][2].setOwner(player);

		flds = Fieldhandler.countConnectedFields(field, player);

		assertEquals(5, flds);
	}

	@Test
	public final void testCheckx() {
		IField node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setX(0);

		node[1].setX(1);

		node[2].setX(2);

		assertFalse(Fieldhandler.checkx(node[0], -1, 3));
		assertTrue(Fieldhandler.checkx(node[0], 0, 3));
		assertTrue(Fieldhandler.checkx(node[0], 1, 3));

		assertTrue(Fieldhandler.checkx(node[1], -1, 3));
		assertTrue(Fieldhandler.checkx(node[1], 0, 3));
		assertTrue(Fieldhandler.checkx(node[1], 1, 3));

		assertTrue(Fieldhandler.checkx(node[2], -1, 3));
		assertTrue(Fieldhandler.checkx(node[2], 0, 3));
		assertFalse(Fieldhandler.checkx(node[2], 1, 3));
	}

	@Test
	public final void testChecky() {
		IField node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setY(0);

		node[1].setY(1);

		node[2].setY(2);

		assertFalse(Fieldhandler.checky(node[0], -1, 3));
		assertTrue(Fieldhandler.checky(node[0], 0, 3));
		assertTrue(Fieldhandler.checky(node[0], 1, 3));

		assertTrue(Fieldhandler.checky(node[1], -1, 3));
		assertTrue(Fieldhandler.checky(node[1], 0, 3));
		assertTrue(Fieldhandler.checky(node[1], 1, 3));

		assertTrue(Fieldhandler.checky(node[2], -1, 3));
		assertTrue(Fieldhandler.checky(node[2], 0, 3));
		assertFalse(Fieldhandler.checky(node[2], 1, 3));
	}

	@Test
	public final void testCheckNeighborIndex() {
		IField node[] = new Field[9];
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

		assertFalse(Fieldhandler.checkNeighborIndex(node[0], -1, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[0], -1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[0], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[0], 0, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[0], 0, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[0], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[0], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[0], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[0], 1, -1, 3));

		assertFalse(Fieldhandler.checkNeighborIndex(node[1], -1, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[1], -1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[1], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[1], 0, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[1], 0, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[1], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[1], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[1], -1, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[1], 1, -1, 3));

		assertFalse(Fieldhandler.checkNeighborIndex(node[2], -1, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[2], -1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[2], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[2], 0, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[2], 0, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[2], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[2], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[2], -1, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[2], 1, -1, 3));

		assertFalse(Fieldhandler.checkNeighborIndex(node[3], -1, -1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[3], -1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[3], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[3], 0, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[3], 0, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[3], 1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[3], 1, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[3], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[3], 1, -1, 3));

		assertFalse(Fieldhandler.checkNeighborIndex(node[4], -1, -1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[4], -1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[4], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[4], 0, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[4], 0, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[4], 1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[4], 1, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[4], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[4], 1, -1, 3));

		assertFalse(Fieldhandler.checkNeighborIndex(node[5], -1, -1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[5], -1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[5], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[5], 0, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[5], 0, 1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[5], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[5], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[5], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[5], 1, -1, 3));

		assertFalse(Fieldhandler.checkNeighborIndex(node[6], -1, -1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[6], -1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[6], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[6], 0, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[6], 0, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[6], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[6], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[6], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[6], 1, -1, 3));

		assertTrue(Fieldhandler.checkNeighborIndex(node[7], -1, -1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[7], -1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[7], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[7], 0, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[7], 0, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[7], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[7], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[7], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[7], 1, -1, 3));

		assertTrue(Fieldhandler.checkNeighborIndex(node[8], -1, -1, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[8], -1, 0, 3));
		assertTrue(Fieldhandler.checkNeighborIndex(node[8], 0, -1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[8], 0, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[8], 0, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[8], 1, 0, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[8], 1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[8], -1, 1, 3));
		assertFalse(Fieldhandler.checkNeighborIndex(node[8], 1, -1, 3));
	}

	@Test
	public final void testGetNeighborfromIndex() {

		assertEquals(7, Fieldhandler.getNeighborfromIndex(-1, -1));
		assertEquals(3, Fieldhandler.getNeighborfromIndex(-1, 0));
		assertEquals(2, Fieldhandler.getNeighborfromIndex(0, -1));
		assertEquals(1, Fieldhandler.getNeighborfromIndex(1, 0));
		assertEquals(0, Fieldhandler.getNeighborfromIndex(0, 1));
		assertEquals(6, Fieldhandler.getNeighborfromIndex(1, -1));
		assertEquals(4, Fieldhandler.getNeighborfromIndex(-1, 1));
		assertEquals(6, Fieldhandler.getNeighborfromIndex(0, 0));
		assertEquals(5, Fieldhandler.getNeighborfromIndex(1, 1));
		assertEquals(-1, Fieldhandler.getNeighborfromIndex(-3, -1));
		assertEquals(-1, Fieldhandler.getNeighborfromIndex(3, 1));
	}

}
