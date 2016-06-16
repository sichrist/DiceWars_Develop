package de.htwg.se.dicewars.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.controller.impl.Dicehandler;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.view.tui.TUI;

public class PlayerTest {

	@Test
	public final void testPlayer() {
		Player testPlayer = new Player();
		assertEquals(null, testPlayer.getName());
		assertEquals(0, testPlayer.getNumberOfDices());
		assertEquals(0, testPlayer.getNumberOfFields());
		assertEquals(0, testPlayer.getPlayerNr());
	}

	@Test
	public final void testSetName() {
		Player testPlayer = new Player();
		testPlayer.setName("Test");
		assertEquals("Test", testPlayer.getName());
	}

	@Test
	public final void testSetNumberOfFields() {
		Player testPlayer = new Player();
		testPlayer.setNumberOfFields(1);
		assertEquals(1, testPlayer.getNumberOfFields());
	}

	@Test
	public final void testSetPlayerNr() {
		Player testPlayer = new Player();
		testPlayer.setPlayerNr(1);
		assertEquals(1, testPlayer.getPlayerNr());
	}

	@Test
	public final void testSetNumberOfDices() {
		Player testPlayer = new Player();
		testPlayer.setNumberOfDices(1);
		assertEquals(1, testPlayer.getNumberOfDices());
	}
	
	
	@Test
	public final void testUpdate() {
		TUI tui= new TUI();
		Dicehandler dicehandler = new Dicehandler();
		Board testboard=new Board();
		int dices=0;
		
		Player player1 = new Player();
		Player player2 = new Player();
		Player[] list = new Player[2];
		Controller controller =  new Controller();
		
		list[0]=player1;
		list[1]=player2;
		
		player1.setName("simon");
		player1.setPlayerNr(0);
		player1.createField(Convertmethods.converteFieldSize(9));
		player2.setName("Olga");
		player2.createField(Convertmethods.converteFieldSize(9));
		player2.setPlayerNr(1);
		
		controller.createBoard(9, 8);
		controller.setNumberOfFields(8);
		controller.connectPlayerToBoard(list);
		controller.setfieldSize(9);		
		controller.spreadDicesToField(controller.getBoard(), list);
		testboard.setField(player1.getField());
		
		player1.initShuffle(null);
		player2.initShuffle(null);
		tui.tui(3, testboard);
		System.out.println(tui.getConsole());
		dicehandler.updateDices(player1);
		tui.tui(3, testboard);
		System.out.println(tui.getConsole());
		
		dices = Dicehandler.countDices(player1.getField(),player1);
		System.out.println(dices);
		assertEquals(8, dices);
		
		
		
		
		
		
		
		
	}
	

}
