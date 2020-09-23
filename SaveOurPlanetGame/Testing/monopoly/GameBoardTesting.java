package monopoly;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUNIT testing of gameboard class
 * 
 * @author Michael Mc Ferran
 *
 */
class GameBoardTesting {

	// create test data
	/**
	 * Arraylist of squares structure
	 */
	private ArrayList<Square> GameSquares;

	/**
	 * Arraylist of squares that'll be empty
	 */
	private ArrayList<Square> GameSquaresNONE;

	/**
	 * Some square objects
	 */
	Square s1, s2, s3;

	/*
	 * variable to check if method display square works
	 */
	private int index;

	@BeforeEach
	void setUpBeforeClass() throws Exception {

		// creating square objects - using default constructor as square class is
		// abstract
		s1 = new Square();
		s2 = new Square();
		s3 = new Square();

		// create arraylist of game squares
		GameSquares = new ArrayList<Square>();

		// create arraylist of EMPTY game squares
		GameSquaresNONE = new ArrayList<Square>();

		// add arrays to list
		GameSquares.add(s1);
		GameSquares.add(s2);
		GameSquares.add(s3);

		// giving index a value - size is used just to prove method works not as
		// intended in code
//		index = GameSquares.get(index)

	}

	/**
	 * testing the default constructor
	 */
	@Test
	void testGameBoardDefaultconstructor() {
		GameBoard GB = new GameBoard();
		assertNotNull(GB);

	}

	/**
	 * Testing constructor with arguments and valid values
	 */
	@Test
	void testGameBoardConstructorArgs() {
		GameBoard GB = new GameBoard(GameSquares);
		assertEquals(GameSquares, GB.getGameSquares());
	}

	/**
	 * Testing constructor with arguments and invalid values
	 */
	@Test
	void testGameBoardConstructorArgsInvalid() {

		// testing gameboard that has no squares
		assertThrows(IllegalArgumentException.class, () -> {
			GameBoard GB = new GameBoard(GameSquaresNONE);
		});
	}

	/**
	 * Testing game squares arraylist with valid array contents
	 */
	@Test
	void testValidGameSquares() {
		GameBoard GB = new GameBoard();
		GB.setGameSquares(GameSquares);
		assertEquals(GameSquares, GB.getGameSquares());

	}

	/**
	 * Testing game squares arraylist with invalid/ empty
	 */
	@Test
	void testInvalidGameSquares() {
		GameBoard GB = new GameBoard();

		assertThrows(IllegalArgumentException.class, () -> {
			GB.setGameSquares(GameSquaresNONE);
		});

	}

	/**
	 * Testing the display square method
	 */
	@Test
	void testDisplaySquare() {
		GameBoard GB = new GameBoard(GameSquares);
		GB.displaySquare(index);

		//checks array to see if index is present and hence dispaly square method can be called and works
		if (GB.getGameSquares().get(index) != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
