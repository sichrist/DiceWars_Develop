package develop;

import java.util.Random;

public class BoardSetup {
	private BoardSetup(){
		
	}
	/*----------------------------------------------------------- Neuer Ansatz ----------------------------------*/
	/* reserve space for Field */
	public static Field initSingleField(Field[][] field, int x, int y) {

		int[] index = new int[2];
		index[0] = x;
		index[1] = y;
		Field node = new Field();
		node.setY(y);
		node.setX(x);;
		field[x][y] = node;
		mallocNodes(node);
		fieldInList(field, node);
		return node;

	}

	/* returns a random number in range of value */
	public static int randomNumber(int value) {
		Random r = new Random();
		return r.nextInt(value);
	}

	/* converts field in x/y size e.g. 49 = 7, 48 = 7, 37 = 6 */
	public static int converteFieldSize(int numberOfFields) {
		return (int) Math.ceil(Math.sqrt(numberOfFields));
	}

	/* mallocs neighbors array */
	public static Field mallocNodes(Field node) {
		Field[] tmp = new Field[8];
		node.setNachbar(tmp);
		setNeighborsNull(node);
		return node;
	}

	public static void setNeighborsNull(Field node) {
		Field[] tmp=new Field[8];

		for (int i = 0; i < node.getNachbar().length; i++) {
			tmp[i]=null;
		}
		node.setNachbar(tmp);
	}

	public static boolean checkx(Field node, int x, int fieldSize) {
		if (node.getX() + x > fieldSize - 1 || node.getX() + x < 0)
			return false;
		return true;
	}

	public static boolean checky(Field node, int y, int fieldSize) {
		if (node.getY() + y > fieldSize - 1 || node.getY() + y < 0)
			return false;
		return true;
	}

	public static boolean checkIndent(Field node, int x, int y) {
		if (node.getX() % 2 != 0) {
			if (x == y && x <= 0)
				return false;
			if (x + y == 0 && y == -1) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkNoIndent(Field node, int x, int y) {
		if (node.getX() % 2 == 0) {
			if (x == y && x >= 0)
				return false;
			if (x + y == 0 && x == -1) {
				return false;
			}

		}
		return true;
	}

	public static boolean checkNeighborIndex(Field node, int nextx, int nexty, int fieldSize) {

		if (!checkNoIndent(node, nextx, nexty))
			return false;
		if (!checkIndent(node, nextx, nexty))
			return false;
		if (!checkx(node, nextx, fieldSize))
			return false;
		if (!checky(node, nexty, fieldSize))
			return false;

		return true;
	}

	/* jede Index operation hat ihren festen platz im nachbarfeld */
	public static int xPlusyNegativeOne(int x) {
		if (x == -1)
			return 3;
		return 2;

	}

	public static int xPlusyZero(int x) {
		if (x == -1)
			return 4;
		return 6;

	}

	public static int xPlusyOne(int x) {
		if (x == 1)
			return 1;
		return 0;

	}

	public static int xPlusyLowerOne(int x, int y) {
		if (x + y == -1) {
			return xPlusyNegativeOne(x);
		} else if (x + y == 0) {
			return xPlusyZero(x);
		} else if (x + y == -2) {
			return 7;
		}

		return -1;

	}

	public static int xPlusyHigherZero(int x, int y) {
		if (x + y == 1) {
			return xPlusyOne(x);
		} else if (x + y == 2) {
			return 5;
		}
		return -1;
	}

	public static int getNeighborfromIndex(int x, int y) {
		if (x + y < 1)
			return xPlusyLowerOne(x, y);

		return xPlusyHigherZero(x, y);

	}

	public static Field connectNodes(Field[][] field, Field node, int numberOfFields, int fieldSize) {
		if (numberOfFields == 1)
			return node;
		int nextx;
		int nexty;
		int vorzeichenx;
		int vorzeicheny;
		int index;

		do {
			nextx = randomNumber(2);
			nexty = randomNumber(2);
			vorzeichenx = randomNumber(2);
			vorzeicheny = randomNumber(2);
			if (vorzeicheny == 1)
				nexty = nexty * (-1);
			if (vorzeichenx == 1)
				nextx = nextx * (-1);

		} while (!checkNeighborIndex(node, nextx, nexty, fieldSize));

		index = getNeighborfromIndex(nextx, nexty);

		if (field[node.getX() + nextx][node.getY() + nexty] != null) {
			node.getNachbar()[index] = field[node.getX() + nextx][node.getY() + nexty];
			return connectNodes(field, node.getNachbar()[index], numberOfFields, fieldSize);
		}

		node.getNachbar()[index] = initSingleField(field, node.getX() + nextx, node.getY() + nexty);
		return connectNodes(field, node.getNachbar()[index], numberOfFields - 1, fieldSize);

	}

	public static Field[][] createField(int fieldSize, int numberOfFields) {

		Field node;
		int matrixSize = converteFieldSize(fieldSize);
		Field[][] field = new Field[matrixSize][matrixSize];

		node = initSingleField(field, randomNumber(matrixSize), randomNumber(matrixSize));
		node = mallocNodes(node);

		connectNodes(field, node, numberOfFields, matrixSize);
		connectFields(field);

		return field;
	}

	public static Field setNeigbors(Field[][] fieldTmp, int a, int b) {
		int value;
		for (int j = -1; j <= 1; j++) {
			for (int i = -1; i <= 1; i++) {
				value = getNeighborfromIndex(j, i);

				if (!checkNeighborIndex(fieldTmp[a][b], j, i, fieldTmp.length)) {
					fieldTmp[a][b].getNachbar()[value] = null;
				} else {

					fieldTmp[a][b].getNachbar()[value] = fieldTmp[a + j][b + i];
				}
			}
		}
		return fieldTmp[a][b];
	}

	public static void setFieldNumber(Field[][] field, int x, int y) {
		if (field[x][y] != null)
			field[x][y].setFieldNumber((x * field.length) + y + 1);
	}

	public static Field[][] connectFields(Field[][] field) {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[j][i] == null)
					continue;
				field[j][i] = setNeigbors(field, j, i);
				setFieldNumber(field, j, i);
			}
		}
		return field;
	}

	public static Field[][] fieldInList(Field[][] field, Field p) {
		field[p.getX()][p.getY()] = p;
		return field;
	}
}