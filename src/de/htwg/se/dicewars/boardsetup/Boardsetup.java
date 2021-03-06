package de.htwg.se.dicewars.boardsetup;

import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.util.Fieldhandler;

public class Boardsetup {
	public Boardsetup(){
		
	}
	
	public IBoard createField(int fieldSize, int numberOfFields) {

		IField node = new Field();
		int matrixSize = Convertmethods.converteFieldSize(fieldSize);
		IField[][] field = new Field[matrixSize][matrixSize];

		node = Fieldsetup.initSingleField(field, Convertmethods.randomNumber(matrixSize), Convertmethods.randomNumber(matrixSize));
		node = Fieldsetup.mallocNodes(node);

		Fieldsetup.connectNodes(field, node, numberOfFields, matrixSize);
		Fieldsetup.connectFields(field);
		Board board = new Board();
		board.setField(field);
		board.setLength(matrixSize);

		return board;
	}
	
	public IBoard playerToField(IBoard board, IPlayer[] listOfPlayer, int numberOfFields) {
		IField[][] field=board.getField();
		int[] listOfFields = new int[listOfPlayer.length];
		int index = 0;
		Fieldsetup.handOutFields(listOfFields, numberOfFields);

		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;
				index = Convertmethods.wuerfelnOhneZurueckLegen(listOfFields);
				field[x][y].setOwner(listOfPlayer[index]);
				Dicesetup.addDice(field[x][y], 1);
				Playersetup.addDicesToPlayer(listOfPlayer, index, 1);
				
				listOfPlayer[index].setFieldFromIndex(field[x][y]);
			}
		}
		board.setField(field);
		return board;
	}
	public void spreadDices(IPlayer[] listOfPlayer){
		IField[][] field;
		field=listOfPlayer[0].getField();
		int dicesToAdd=Fieldhandler.countFields(field);
		listOfPlayer[0].setNumberOfDices(dicesToAdd);
		for (int i = 1; i < listOfPlayer.length; i++) {
			field=listOfPlayer[i].getField();
			listOfPlayer[i].setNumberOfDices(dicesToAdd);
			listOfPlayer[i].initShuffle(null);
			
		}
	}
}
