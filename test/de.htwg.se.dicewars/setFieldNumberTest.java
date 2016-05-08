package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Board;
import de.htwg.se.dicewars.Field;

public class setFieldNumberTest {

	@Test
	public void Test() {
		int ctr = 1;
		Field[][] field = Board.createField(64,49);
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				Board.setFieldNumber(field,j, i);
				if (field[j][i] == null) {
					;
				}

				else {
					assertEquals(ctr, field[j][i].getFieldNumber());
				}
				ctr = ctr + 1;
			}
		}
	}

}
