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

	
}
