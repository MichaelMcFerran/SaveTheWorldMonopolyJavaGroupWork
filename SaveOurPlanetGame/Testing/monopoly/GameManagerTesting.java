package monopoly;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameManagerTesting {

	// create test data

	// create dice object
	Dice dice1;
	Dice dice2;

	// Gameboard data
	GameBoard GB;

	// square arraylist to hold gameboard
	private ArrayList<Square> GameSquares;

	/**
	 * Some square objects
	 */
	Square s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;

	/*
	 * variable to check if method display square works
	 */
	private int index;
	
	// player1 test data
		Scanner player1;

		String name;
		int balance, currentPosition, lastPosition;
		int lastRoll, playerNumber;

		// amounts to add and subtract from
		int addAmount;
		int subAmount;

		// player2 test data
		Player player2;
		String name2;
		int balance2, currentPosition2, lastPosition2;
		int lastRoll2, playerNumber2;

		// amounts to add and subtract from player 2
		int addAmount2;
		int subAmount2;

		// game manager data

		Scanner playerList;

	@BeforeEach
	void setUp() throws Exception {
		

		
		// initialise test data

				// initialise dice
				dice1 = new Dice(6);
				dice2 = new Dice(6);

				// create arraylist of game squares
				GameSquares = new ArrayList<Square>();
				

				// creating square objects - using default constructor as square class is
				// abstract
				s1 = new Square();
				s2 = new Square();
				s3 = new Square();
				s4 = new Square();
				s5 = new Square();
				s6 = new Square();
				s7 = new Square();
				s8 = new Square();
				s9 = new Square();
				s10 = new Square();
				s11 = new Square();
				s12 = new Square();

				// add squares to arraylist
				GameSquares.add(s1);
				GameSquares.add(s2);
				GameSquares.add(s3);
				GameSquares.add(s4);
				GameSquares.add(s5);
				GameSquares.add(s6);
				GameSquares.add(s7);
				GameSquares.add(s8);
				GameSquares.add(s9);
				GameSquares.add(s10);
				GameSquares.add(s11);
				GameSquares.add(s12);
				

				// initialise player data

				name = "validname";
				name2 = "validname2";

				balance = 500;
				balance2 = 500;
				
				currentPosition = 1;
				currentPosition2 = 2;
				lastPosition = 0;
				lastPosition = 1;
				
				lastRoll = 1;
				lastRoll2 = 1;
				
				playerNumber = 1;
				playerNumber2 = 2;


	}

	/**
	 * testing if main class runs
	 */
	@Test
	void testMain() {
		GameManager GM = new GameManager();
		// Testing if GameManager class object can be made and defaulted
		assertNotNull(GM);

	}

	

	@Test
	Scanner testRegisterPlayers(Scanner scan) {
		
		GameManager.RegisterPlayers(player1);

		return player1;
		
//		if()) {
//			assertTrue(true);
//		} else {
//			assertTrue(false);
//		}
	} 

	@Test
	void testTurnOptions() {

	}

	@Test
	void testPlayerRollsDice() {

	}

	@Test
	void testPlayerMoves() {

	}
//
//	@Test
//	void testCheckedIfPassed() {
//		//GameManager.CheckedIfPassed(player, gameboard);
//	}

	@Test
	void testCheckWhereLanded() {

	}

//	@Test
//	void testCheckGameState() {
//
//	}

	@Test
	void testEndGame() {

	}

}
