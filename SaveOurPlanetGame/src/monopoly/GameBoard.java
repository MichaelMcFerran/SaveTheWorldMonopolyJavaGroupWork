package monopoly;

import java.util.ArrayList;

import monopoly.GoSquare;
import monopoly.PropertySquare;
import monopoly.Square;

public class GameBoard {

	// Instance vars
	private ArrayList<Square> GameSquares;

	/**
	 * Business rules maximum game squares as per board layout, can be altered
	 */
	public final int maxSquares = 15;

	// Constructor
	/**
	 * Default constructor
	 */
	public GameBoard() {

	}

	/**
	 * Constructor for two player game
	 * 
	 * @param gameSquares
	 */
	public GameBoard(ArrayList<Square> gameSquares) {
		this.setGameSquares(gameSquares);
	}

	// Getters and setters
	/**
	 * @return the gameSquares
	 */
	public ArrayList<Square> getGameSquares() {
		return GameSquares;
	}

	/**
	 * @param gameSquares the gameSquares to set
	 */
	public void setGameSquares(ArrayList<Square> gameSquares) throws IllegalArgumentException {
		if ((gameSquares.size() != 0) && (gameSquares.size() <= maxSquares)) {
			this.GameSquares = gameSquares;
		} else {
			throw new IllegalArgumentException(" the amount of game squares is out of the range");
		}

	}

	// Methods
	/**
	 * Simple method that will generate the gameboard, with rent pricing, min and
	 * maj dev costs
	 * 
	 * @param index
	 */
	public void displaySquare(int index) {
		System.out.println(this.GameSquares.get(index).getName());
	}

	public void generateGameBoard() {

		GoSquare go = new GoSquare("Go", "Go", 100);

		// A & D Most expensive squares, as per requirements
		PropertySquare a1 = new PropertySquare("A1", "Urban Wind Farm", 200, 75, 250, 500);
		PropertySquare a2 = new PropertySquare("A2", "Wind Tunnel", 220, 75, 250, 500);
		PropertySquare a3 = new PropertySquare("A3", "Offshore Wind Farm", 250, 100, 250, 500);

		PropertySquare b1 = new PropertySquare("B1", "Urban Solar Farm", 70, 60, 150, 250);
		PropertySquare b2 = new PropertySquare("B2", "Agricultural Solar Farm", 70, 60, 150, 250);

		// GoSquare pause = new GoSquare("Pause", "Earth Day", 0);
		// Michael changing dead square to just a square
		Square pause = new Square("pause", "Earth Day");

		PropertySquare c1 = new PropertySquare("C1", "Biofuel Farm", 100, 70, 175, 300);
		PropertySquare c2 = new PropertySquare("C2", "Agricultural BioDiesel", 100, 70, 175, 300);
		PropertySquare c3 = new PropertySquare("C3", "ElectroFuel", 150, 90, 200, 300);

		PropertySquare d1 = new PropertySquare("D1", "Hydrodam", 200, 100, 250, 500);
		PropertySquare d2 = new PropertySquare("D2", "Hydromill", 250, 100, 250, 500);

		// second arraylist to store gameboard attributes
		ArrayList<Square> gameboard = new ArrayList<Square>();
		gameboard.add(go);
		gameboard.add(a1);
		gameboard.add(a2);
		gameboard.add(a3);
		gameboard.add(b1);
		gameboard.add(b2);
		gameboard.add(pause);
		gameboard.add(c1);
		gameboard.add(c2);
		gameboard.add(c3);
		gameboard.add(d1);
		gameboard.add(d2);

		this.setGameSquares(gameboard);

	}

}