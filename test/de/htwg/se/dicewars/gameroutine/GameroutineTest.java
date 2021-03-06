package de.htwg.se.dicewars.gameroutine;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.util.Dicehandler;
import de.htwg.se.dicewars.util.Playerhandler;


public class GameroutineTest {

	@Test
	public final void getAttackTest() {
		Attack attack = new Attack();
		Gameroutine gameroutine = new Gameroutine();
		gameroutine.setAttack(attack);
		assertEquals(attack, gameroutine.getAttack());
	}

	@Test
	public final void getPlayerTurnTest() {
		Gameroutine gameroutine = new Gameroutine();
		gameroutine.setPlayersTurn(0);
		assertEquals(0, gameroutine.getPlayersTurn());
	}

	@Test
	public final void getPlayerUpdateTest() {
		Playerhandler playerHandler = new Playerhandler();
		Gameroutine gameroutine = new Gameroutine();
		gameroutine.setPlayerUpdate(playerHandler);
		assertEquals(playerHandler, gameroutine.getPlayerUpdate());
	}

	@Test
	public final void getDiceUpdateTest() {
		Dicehandler dicehandler = new Dicehandler();
		Gameroutine gameroutine = new Gameroutine();
		gameroutine.setDiceUdate(dicehandler);
		assertEquals(dicehandler, gameroutine.getDiceUpdate());
	}

	@Test
	public final void test() {
		Boardsetup boardsetup = new Boardsetup();
		IBoard board = new Board();
		IField[][] field;
		IField[] tmpNeighbour;
		board = boardsetup.createField(9, 9);
		field = board.getField();
		Gameroutine gameroutine = new Gameroutine();

		IPlayer hans = new Player();
		IPlayer peter = new Player();

		hans.setPlayerNr(1);
		peter.setPlayerNr(2);

		hans.setName("hans");
		peter.setName("peter");

		/*--- Feld preparieren ---*/
		field[2][2] = null;
		tmpNeighbour = field[2][1].getNachbar();
		tmpNeighbour[0] = null;
		tmpNeighbour = field[1][2].getNachbar();
		tmpNeighbour[1] = null;
		tmpNeighbour = field[1][1].getNachbar();
		tmpNeighbour[5] = null;

		field[1][1].setOwner(hans);
		field[1][1].setNumberOfDices(1);
		field[1][2].setOwner(hans);
		field[1][2].setNumberOfDices(1);
		field[1][0].setOwner(peter);
		field[1][0].setNumberOfDices(8);

		gameroutine.routine(hans, field[1][0], field[1][0]);

		assertEquals(Status.INVALIDOWNER, gameroutine.getStatus());

		gameroutine.routine(hans, field[1][1], field[1][0]);

		
		assertEquals(Status.INVALIDATTACKDICES, gameroutine.getStatus());

		assertEquals(Status.INVALIDATTACKDICES, gameroutine.getAttack().getStatus());

		gameroutine.routine(peter, field[1][0], field[1][1]);
		
		assertEquals(Status.ATTACKSUCCESS, gameroutine.getStatus());
		assertEquals(peter, field[1][1].getOwner());
		assertEquals(7, field[1][1].getNumberOfDices());
		assertEquals(1, field[1][0].getNumberOfDices());

		field[1][1].setOwner(hans);
		field[1][1].setNumberOfDices(2);
		field[1][2].setOwner(hans);
		field[1][2].setNumberOfDices(1);
		field[1][0].setOwner(peter);
		field[1][0].setNumberOfDices(8);

		gameroutine.routine(hans, field[1][1], field[1][0]);

		assertEquals(Status.ATTACKFAILED, gameroutine.getStatus());

	}

	@Test
	public void checkEndOfTurnTest() {
		Gameroutine gameroutine = new Gameroutine();
		IController controller = new Controller();
		
		IPlayer hans = new Player();
		IPlayer peter = new Player();
		IPlayer[] list = new Player[2];

		hans.setPlayerNr(0);
		peter.setPlayerNr(1);

		hans.setName("hans");
		peter.setName("peter");

		hans.createField(3);
		peter.createField(3);

		list[0] = hans;
		list[1] = peter;

		controller.createBoard(9, 9);
		controller.setNumberOfFields(9);
		controller.connectPlayerToBoard(list);
		controller.setfieldSize(9);

		gameroutine.checkEndOfTurn(hans);

		assertEquals(Status.ENDTURN, gameroutine.getStatus());

		peter.setNumberOfDices(8);
		peter.initShuffle(null);;
		peter.update();
		
		
		gameroutine.checkEndOfTurn(peter);
		assertEquals(Status.VALID, gameroutine.getStatus());
		
		
	}

}
