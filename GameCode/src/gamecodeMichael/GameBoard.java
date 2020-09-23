/**
 * 
 */
package gamecodeMichael;

import java.util.ArrayList;

import gamecode.GoSquare;
import gamecode.PropertySquare;
import gamecode.Square;

/**
 * @author edited by MIchael
 *
 */
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

		/**
		 * Boardgame method that has added all 12 squares of the game to an arraylist, which can be cycled through when player rolls on their go.
		 * @return
		 * @auth Matt McBride
		 */
		public ArrayList<Square> generateGameBoard(){
			GoSquare go = new GoSquare("Go", "Go", 500);
			PropertySquare a1 = new PropertySquare("A1", "A1 Street", 100, 50, 100, 100);
			PropertySquare a2 = new PropertySquare("A2", "A2 Street", 100, 50, 100, 100);
			PropertySquare a3 = new PropertySquare("A3", "A3 Street", 100, 50, 100, 100);
			PropertySquare b1 = new PropertySquare("B1", "B1 Street", 100, 50, 100, 100);
			PropertySquare b2 = new PropertySquare("B2", "B2 Street", 100, 50, 100, 100);
			GoSquare pause = new GoSquare("Pause", "Pause", 0);
			PropertySquare c1 = new PropertySquare("C1", "C1 Street", 100, 50, 100, 100);
			PropertySquare c2 = new PropertySquare("C2", "C2 Street", 100, 50, 100, 100);
			PropertySquare c3 = new PropertySquare("C3", "C3 Street", 100, 50, 100, 100);
			PropertySquare d1 = new PropertySquare("D1", "D1 Street", 100, 50, 100, 100);
			PropertySquare d2 = new PropertySquare("D2", "D2 Street", 100, 50, 100, 100);
			
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
			
			return gameboard;
			
		}
		
	}
