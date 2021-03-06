package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.observer.Observable;
import de.htwg.se.dicewars.state.Status;

public class Controller extends Observable implements IController {

	private IBoard board;
	private IPlayer[] playerlist;
	private int numberOfFields;
	private int fieldSize;
	private Gameroutine gameroutine;
	private Status status;
	private int attack;
	private int defend;
	private Boardsetup boardsetup;

	public Controller() {
		board = null;
		playerlist = null;
		numberOfFields = 0;
		fieldSize = 0;
		status = Status.NEW;
		gameroutine = new Gameroutine();
		attack = -1;
		defend = -1;
		boardsetup  = new Boardsetup();
	}

	@Override
	public void reset(){
		this.board = null;
		this.playerlist = null;
		this.numberOfFields = 0;
		this.fieldSize = 0;
		this.status = Status.NEW;
		this.attack = -1;
		this.defend = -1;
	}
	@Override
	public int getAttack() {
		return this.attack;
	}

	@Override
	public int getDefend() {
		return this.defend;
	}

	@Override
	public void setGameroutine(Gameroutine gameroutine) {
		this.gameroutine = gameroutine;
	}

	@Override
	public Gameroutine getGameroutine() {
		return this.gameroutine;
	}

	@Override
	public boolean checkRange(int index) {
		if (index > 0 && index < playerlist.length)
			return true;
		return false;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void setDefend(int defend) {
		this.defend = defend;
	}

	@Override
	public Status getStatus() {
		return this.status;
	}

	@Override
	public void setfieldSize(int tmpFieldSize) {
		this.fieldSize = tmpFieldSize;
	}

	@Override
	public void setBoard(IBoard tmpBoard) {
		this.board = tmpBoard;
	}

	@Override
	public void setPlayerlist(IPlayer[] tmpPlayerList) {
		this.playerlist = tmpPlayerList;
	}

	@Override
	public void setSinglePlayer(IPlayer player, int index) {
		if (player != null && checkRange(index)) {
			this.playerlist[index] = player;

		}
	}

	@Override
	public void setNumberOfFields(int tmpNumberOfFields) {
		this.numberOfFields = tmpNumberOfFields;
	}

	@Override
	public IBoard getBoard() {
		return this.board;
	}

	@Override
	public IPlayer[] getPlayerlist() {
		return this.playerlist;
	}

	@Override
	public IPlayer getSinglePlayer(int index) {
		if (checkRange(index))
			return this.playerlist[index];
		return null;
	}

	@Override
	public int getFieldSize() {
		return this.fieldSize;
	}

	@Override
	public int getNumberOfFields() {
		return this.numberOfFields;
	}

	@Override
	public void createBoard(int fieldSize, int numberOfFields) {
		
		int tmpfieldSize = fieldSize;
		int tmpnumberOfFields = numberOfFields;
		if (tmpfieldSize < tmpnumberOfFields) {
			tmpfieldSize = tmpnumberOfFields;
		}
		IBoard tmpBoard = new Board();
		tmpBoard = boardsetup.createField(tmpfieldSize, tmpnumberOfFields);
		setfieldSize(tmpfieldSize);
		setNumberOfFields(tmpnumberOfFields);
		setBoard(tmpBoard);
	}

	@Override
	public void connectPlayerToBoard(IPlayer[] listOfPlayer) {
		if (this.board != null && this.numberOfFields >= 0 && listOfPlayer != null)
			boardsetup.playerToField(this.board, listOfPlayer, numberOfFields);
	}

	@Override
	public void spreadDicesToField(IBoard board2, IPlayer[] listOfPlayer) {
		boardsetup.spreadDices(listOfPlayer);

	}

	@Override
	public void create() {
		createBoard(fieldSize, numberOfFields);
		connectPlayerToBoard(playerlist);

		spreadDicesToField(board, playerlist);
		
		init();
	}

	@Override
	public void init() {
		int dices = numberOfFields / playerlist.length;
		for (int i = 0; i < playerlist.length; i++) {
			playerlist[i].initShuffle(null);
			playerlist[i].setNumberOfDices(dices);
			playerlist[i].update();

		}
		notifyObservers();

	}

	@Override
	public void startGame() {

		if (status == Status.NEW) {
			gameroutine.setPlayersTurn(0);
			fieldSize = board.getLength();
		}

		if (attack < 0 || defend < 0) {
			status = Status.CHOOSEAKTION;
			return;
		}
		int playersTurn = gameroutine.getPlayersTurn();
		IField[][] field = board.getField();

		int[] index = Convertmethods.fieldNumberToIndex(fieldSize, attack);
		IField attackfield = field[index[0]][index[1]];
		index = Convertmethods.fieldNumberToIndex(fieldSize, defend);
		IField defendfield = field[index[0]][index[1]];

		gameroutine.routine(playerlist[playersTurn], attackfield, defendfield);
		attack = -1;
		defend = -1;
		if (gameroutine.getStatus() != Status.SUCCESS) {
			status = gameroutine.getStatus();

		}
		gameroutine.checkEndOfTurn(playerlist[playersTurn]);
		if (gameroutine.getStatus() == Status.ENDTURN) {
			gameroutine.endOFTurn(playerlist[playersTurn]);
			if (gameroutine.getPlayersTurn() == playerlist.length) {
				gameroutine.setPlayersTurn(0);
			}
		}
		notifyObservers();

	}

	



}
