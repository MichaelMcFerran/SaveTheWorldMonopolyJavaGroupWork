package mono;

import java.util.ArrayList;

public class GameBoard {
	
	//Instance vars
	private ArrayList<Square> GameSquares;
	
	//Constructor
	/**
	 * Default constructor
	 */
	public GameBoard() {
		
	}
	
	/**
	 * Constructor for two player game
	 * @param gameSquares
	 */
	public GameBoard(ArrayList<Square> gameSquares) {
		this.setGameSquares(gameSquares);
	}
	
	//Getters and setters
	/**
	 * @return the gameSquares
	 */
	public ArrayList<Square> getGameSquares() {
		return GameSquares;
	}
	/**
	 * @param gameSquares the gameSquares to set
	 */
	public void setGameSquares(ArrayList<Square> gameSquares) {
		this.GameSquares = gameSquares;
	}
	
	//Methods
	public void displaySquare(int index) {
		System.out.println(this.GameSquares.get(index).getName());
	}

	public void generateGameBoard(){
		GoSquare go = new GoSquare("Go", "Go", 200);
		PropertySquare a1 = new PropertySquare("A1", "Wind Farm", 300, 90, 150, 500);
		PropertySquare a2 = new PropertySquare("A2", "Wind Tunnel", 300, 90, 150, 500);
		PropertySquare a3 = new PropertySquare("A3", "Wind Farm", 300, 90, 150, 350);
		PropertySquare b1 = new PropertySquare("B1", "Urban Solar Farm", 100, 60, 100, 250);
		PropertySquare b2 = new PropertySquare("B2", "Agricultural Solar Farm", 100, 60, 100, 250);
		GoSquare pause = new GoSquare("Pause", "Earth Day", 0);
		PropertySquare c1 = new PropertySquare("C1", "Biofuel Farm", 150, 80, 150, 500);
		PropertySquare c2 = new PropertySquare("C2", "Agricultural BioDiesel", 150, 80, 150, 500);
		PropertySquare c3 = new PropertySquare("C3", "ElectroFuel", 150, 80, 150, 500);
		PropertySquare d1 = new PropertySquare("D1", "Hydrodam", 250, 90, 150, 250);
		PropertySquare d2 = new PropertySquare("D2", "Hydromill", 250, 90, 150, 250);
		
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
