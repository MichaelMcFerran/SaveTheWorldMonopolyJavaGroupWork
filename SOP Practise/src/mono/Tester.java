package mono;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		runGame();
	}
	
	public static void runGame() {
		//Game objects
		Scanner scanner = new Scanner(System.in);
		
		Dice diceOne = new Dice(6);
		Dice diceTwo = new Dice(6);

		GoSquare go = new GoSquare("go", "Go Square", 200);
		PropertySquare a1 = new PropertySquare("A1", "A1 Street", 100, 20, 20, 20);
		PropertySquare a2 = new PropertySquare("A1", "A1 Street", 100, 20, 20, 20);
		PropertySquare a3 = new PropertySquare("A1", "A1 Street", 100, 20, 20, 20);
		
		ArrayList<Square> gameSquares = new ArrayList<Square>();
		gameSquares.add(go);
		gameSquares.add(a1);
		gameSquares.add(a2);
		gameSquares.add(a3);
		
		GameBoard gameboard = new GameBoard(gameSquares);
		
		//RegisiterPlayers
		Player[] playerList = RegisterPlayers(scanner);
		
		for(int i = 0; i < playerList.length; i++) {
			TurnOptions(playerList[i], scanner);
			PlayerRollsDice(playerList[i], gameboard, diceOne, diceTwo);
			PlayerMoves(playerList[i], gameboard, diceOne, diceTwo);
			CheckWhereLanded(playerList[i], gameboard, scanner);
			CheckedIfPassed(playerList[i], gameboard);
			CheckGameState(playerList);
			
			//reset if last index
			if (i == playerList.length-1) {
				i = -1;
			}
		}
		
	}

	/**
	 * Method to prompt the user how many players they wish to include in there game
	 * then prompt for each players name ensuring they are unique and returning an
	 * array
	 * 
	 * NOTE: Player constructor uses a fixed value for the player balance, this will
	 * need changed
	 * 
	 * @param scanner
	 * @return Player Array named players
	 */
	public static Player[] RegisterPlayers(Scanner scanner) {
		// Data used
		boolean validInput = false;
		String responce, player1Name, player2Name, player3Name, player4Name;
		int option = 0;
		Player p1, p2, p3, p4;
		Player[] players = new Player[0];

		// User is prompt for number of players to be included, loop until the user has
		// entered a valid number of players
		do {
			System.out.println("Please enter a vaild number of players to begin the game (2 - 4)");
			responce = scanner.next();

			switch (responce) {
			case "2":
				validInput = true;
				option = 2;
				break;
			case "3":
				validInput = true;
				option = 3;
				break;
			case "4":
				validInput = true;
				option = 4;
				break;
			default:
				System.out.println("You've entered an invalid responce!");
				System.out.println("Make sure you enter a value in the given range");
			}

		} while (validInput == false);
		validInput = false;

		// Construct Players relating to the option the user has entered
		switch (option) {
		case 2: // Two player option
			players = new Player[2];

			// Prompt for Player One's name
			System.out.println("Please enter the display name for Player One");
			player1Name = scanner.next();

			// Construct player one and add to array
			p1 = new Player(player1Name, 500, 0);
			players[0] = p1;

			// Prompt for player two's name and check that it is unique from player one's
			do {
				System.out.println("Please enter the display name for Player Two");
				player2Name = scanner.next();

				if (player1Name.equals(player2Name)) {
					System.out.println("Player Two's name must be different from Player One's");
				} else {
					p2 = new Player(player2Name, 500, 0);
					players[1] = p2;
					validInput = true;
				}
			} while (validInput == false);
			validInput = false;
			break;

		case 3: // Three player option
			players = new Player[3];

			// Prompt for Player One's name
			System.out.println("Please enter the display name for Player One");
			player1Name = scanner.next();

			// Construct player one and add to array
			p1 = new Player(player1Name, 500, 0);
			players[0] = p1;

			// Prompt for player two's name and check that it is unique from player one's
			do {
				System.out.println("Please enter the display name for Player Two");
				player2Name = scanner.next();

				if (player1Name.equals(player2Name)) {
					System.out.println("Player Two's name must be different from Player One's");
				} else {
					p2 = new Player(player2Name, 500, 0);
					players[1] = p2;
					validInput = true;
				}
			} while (validInput == false);
			validInput = false;

			// Prompt for player three's name and check that it is unique from other players
			do {
				System.out.println("Please enter the display name for Player Three");
				player3Name = scanner.next();

				if (player1Name.equals(player3Name) || player2Name.equals(player3Name)) {
					System.out.println("Player Three's name must be different from Player One's and Player Two's");
				} else {
					p3 = new Player(player3Name, 500, 0);
					players[2] = p3;
					validInput = true;
				}
			} while (validInput == false);
			validInput = false;
			break;
		case 4: // Four player option
			players = new Player[4];

			// Prompt for Player One's name
			System.out.println("Please enter the display name for Player One");
			player1Name = scanner.next();

			// Construct player one and add to array
			p1 = new Player(player1Name, 500, 0);
			players[0] = p1;

			// Prompt for player two's name and check that it is unique from player one's
			do {
				System.out.println("Please enter the display name for Player Two");
				player2Name = scanner.next();

				if (player1Name.equals(player2Name)) {
					System.out.println("Player Two's name must be different from Player One's");
				} else {
					p2 = new Player(player2Name, 500, 0);
					players[1] = p2;
					validInput = true;
				}
			} while (validInput == false);
			validInput = false;

			// Prompt for player three's name and check that it is unique from other players
			do {
				System.out.println("Please enter the display name for Player Three");
				player3Name = scanner.next();

				if (player1Name.equals(player3Name) || player2Name.equals(player3Name)) {
					System.out.println("Player Three's name must be different from Player One's and Player Two's");
				} else {
					p3 = new Player(player3Name, 500, 0);
					players[2] = p3;
					validInput = true;
				}
			} while (validInput == false);
			validInput = false;

			// Prompt for player four's name and check that it is unique from other players
			do {
				System.out.println("Please enter the display name for Player Four");
				player4Name = scanner.next();

				if (player1Name.equals(player4Name) || player2Name.equals(player4Name)
						|| player3Name.equals(player4Name)) {
					System.out.println("Player Four's name must be different from the other players");
				} else {
					p4 = new Player(player4Name, 500, 0);
					players[3] = p4;
					validInput = true;
				}

			} while (validInput == false);
			validInput = false;
			break;
		}

		// Return array of players
		//scanner.close();
		return players;
	}

	/**
	 * Method that will ask the user if they would like to take their turn or 
	 * quit the game
	 * @return boolean
	 */
	public static void TurnOptions(Player player, Scanner scanner) {
		//data used
		boolean validInput = false;
		String responce;
		
		do {
			System.out.println("[1] Take Turn");
			System.out.println("[2] Display Balance");
			System.out.println("[3] Show Game Board");
			System.out.println("[4] Quit the game");
			responce = scanner.next();

			switch (responce) {
			case "1": validInput = true; break;
			case "2": System.out.println(player.getName() +"'s balance is £" +player.getBalance());; break;
			case "3": System.out.println("METHOD FOR PRINTING THE GAME BOARD"); break;
			case "4": EndGame(); break;
			default: System.out.println("You've entered an invalid responce!");
					System.out.println("Make sure you enter a value in the given range");
			}
			
		} while (validInput == false);
		//s.close();
	}
	
	/**
	 * Method to roll two dice object for a player and prompt them what they have rolled
	 */
	public static void PlayerRollsDice(Player player, GameBoard gameboard, Dice diceOne, Dice diceTwo) {
		// Data used
		int roll1, roll2;

		// Get player to roll dice
		diceOne.roll();
		diceTwo.roll();
		System.out.println(player.getName() + ", you have rolled a " + diceOne.getValue() + " and a " +diceTwo.getValue());
	}

	/**
	 * Method to move a player on a gameBoard and display its position
	 * 
	 * @param player
	 * 
	 *               NOTE : A method of counting how many times the player passes
	 *               the go square is needed as they will need to collect credit
	 */
	public static void PlayerMoves(Player player, GameBoard gameboard, Dice diceOne, Dice diceTwo) {
		//update newPosition
		int newPosition = player.getCurrentPosition() + diceOne.getValue() + diceTwo.getValue();

		// check if this new position is in range if not take away the overlap
		while (newPosition > (gameboard.getGameSquares().size() - 1)) {
			newPosition -= gameboard.getGameSquares().size();
		}
		
		//Set lastRoll player var
		player.setLastRoll(diceOne.getValue() + diceTwo.getValue());
		
		// Set new player position
		player.setCurrentPosition(newPosition);

		// Display where they have landed
		System.out.println(player.getName() +", you were on " +gameboard.getGameSquares().get(player.getLastPosition()).getName() +", and have now landed on "
				+ gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
	}
	
	/**
	 * Method to check if a player has passed the go square
	 * @param player
	 * @param gameboard
	 * @param diceOne
	 * @param diceTwo
	 */
	public static void CheckedIfPassed(Player player, GameBoard gameboard) {
		//data used
		int lastPosition = player.getLastPosition(); //0
		int LastRoll = player.getLastRoll(); //8
		
		//1. Check all squares that the player passed during PlayerMoves
		for (int i = 1; i <= LastRoll; i++) {
			//reset if the player has done a loop of the board
			if (lastPosition > (gameboard.getGameSquares().size() -1)) {
				lastPosition -= gameboard.getGameSquares().size();
			}
			
			//2. if the square is a GoSquare
			if (gameboard.getGameSquares().get(lastPosition).getClass().getTypeName() == "mono.GoSquare") {
				//3. State to the player they have passed the go square and update their balance
				GoSquare holder = (GoSquare) gameboard.getGameSquares().get(lastPosition);
				System.out.println("During this move you have passed " +holder.getName() +" and get a collection of £" +holder.getCollection());
				player.updateBalanceAdd(holder.getCollection());
			}

			//increment index
			lastPosition++;
		}
	}
	
	/**
	 * Method to check the status of the square that the player has landed on, possible outcomes are;
	 * 	1. Square is free and available to buy
	 * 	2. Square is owned by another player (owe money)
	 * 	3. Square is owned by the current player (Upgrade)
	 * 	4. Square is owned and fully upgraded
	 * @param player
	 * @param gameboard
	 */
	public static void CheckWhereLanded(Player player, GameBoard gameboard, Scanner scanner) {
		//Data used
		String userResponce;
		boolean validInput = false;
		
		//Either the Player has landed on a GoSquare or a PropertySquare
		//If GoSquare ... nothing should happen
		//If PropertySquare
		if (gameboard.getGameSquares().get(player.getCurrentPosition()).getClass().getTypeName() == "mono.PropertySquare") {
			PropertySquare holder = (PropertySquare) gameboard.getGameSquares().get(player.getCurrentPosition());
			
		//Possible outcomes are
			//1. Square is free and available to buy
			if (holder.isOwned() == false) {
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
				System.out.print(" is avaliable to purchase for £" +holder.getCost());
				
				//Ask user if they would like to purchase property
				do {
					System.out.println("Would you like to purchase this property? (Y/N)");
					userResponce = scanner.next();
					
					//If the user answered yes then purchase
					if (userResponce.equalsIgnoreCase("y")) {
						validInput = true;
						holder.buyProperty(player);
					} else if (userResponce.equalsIgnoreCase("N")) {
						System.out.println(player.getName() +" did not purchase " +holder.getName());
						validInput = true;
					} else {
						System.out.println("Please enter a valid responce");
					}
				} while (validInput == false);
			}
			
			//2. Square is owned by another player (owe money)
			else if (holder.isOwned() == true && holder.getOwner() != player) {
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
				System.out.print(" is owned by " +holder.getOwner().getName() +" \n");
				holder.payTax(player);
			}
			
			//3. Square is owned by the current player (Upgrade)
			else if (holder.isOwned() == true && holder.getOwner() == player && holder.isFullyUpgraded() == false) {
				System.out.print(player.getName() +", you already own ");
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
				
				//Ask user if they would like to upgrade property
				do {
					System.out.println("Would you like to upgrade this property for £" +holder.getNextDevCost() +"? (Y/N)");
					userResponce = scanner.next();
					
					//If the user answered yes then upgrade
					if (userResponce.equalsIgnoreCase("y")) {
						validInput = true;
						holder.upgradeProperty();
					} else if (userResponce.equalsIgnoreCase("N")) {
						System.out.println(player.getName() +" did not upgrade " +holder.getName());
						validInput = true;
					} else {
						System.out.println("Please enter a valid responce");
					}
				} while (validInput == false);
				
			}
			
			//4. Square is owned and fully upgraded
			else if (holder.isOwned() == true && holder.getOwner() == player && holder.isFullyUpgraded() == true) {
				System.out.print(player.getName() +", you already own ");
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName() +" and have developed it fully");
			}
		}
		
		//scanner.close();
	}
	
	/**
	 * Method that will search through the current list of players and check if they are
	 * still allowed to continue in the game
	 */
	public static void CheckGameState(Player[] playerList) {
		//data used
		boolean end = false;
		
		//search through player list and check their balance
		for (int i = 0; i < playerList.length; i++) {
			if (playerList[i].getBalance() < 0) {
				System.out.println(playerList[i].getName() +", you have ran out of credit ....");
				end = true;
			}
		}
		
		//If end is true then the game should end
	}
	
	public static void EndGame() {
		System.out.println("GAME OVER");
		System.exit(0);
	}

}
