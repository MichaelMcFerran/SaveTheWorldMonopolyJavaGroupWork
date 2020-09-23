package monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import monopoly.GameBoard;
import monopoly.GoSquare;
import monopoly.PropertySquare;
import monopoly.Square;

/**
 * Main class that is used to run the game, all classes are called from this
 * main method
 * 
 * @author ALL
 *
 */
public class GameManager {

	public static void main(String[] args) {
	
		runGame();
	}

	/**
	 * author Michael
	 */
	public static void introSOP() {
		System.out.println(
				"**************************************************************************************************************");
		System.out.println("\n");
		System.out.println("\t \t \t \t \t Welcome To Save Our Planet®");
		System.out.println("\n");

		// print out symbol for game
		System.out.println("\t\t\t *****\t\t\t ****\t\t\t*****");
		System.out.println("\t\t\t**\t\t\t**  **\t\t\t**  **");
		System.out.println("\t\t\t**\t\t\t**  **\t\t\t**  **");
		System.out.println("\t\t\t *****\t\t\t**  **\t\t\t*****");
		System.out.println("\t\t\t     **\t\t\t**  **\t\t\t**");
		System.out.println("\t\t\t     **ave\t\t**  **ur\t\t**lanet");
		System.out.println("\t\t\t *****\t\t\t ****\t\t\t**");

		System.out.println();

		System.out.println();

		System.out.println("   Welcome to Save Our Planet, a digital boardgame in the theme of renewable energy!");
		System.out
				.println("   The purpose of this game is to help educate and create awareness for renewable energies");
		System.out.println(
				"   For Example, did you know that Windpower is the most significant generator of reneweable energy");
		System.out.println(
				"   in the UK, with onshore and offshore farms providing upto 18% of all electricity consumed.");
		System.out.println();

		System.out.println(
				"   Biodiesel has been proven to be extremely effective in the shoreline clean up of crude oil spills.");
		System.out.println(
				"   Biodiesel can remove up to 80% of oil from inflicted shorelines, and is highly degradable.");
		System.out.println(
				"   Biodiesel can heat our homes, and with its solvent properities, can make a furnace more efficient");
		System.out.println(
				"   Switching to Biodiesel,  could reduce CO2 emissions in UK households by 1.5 million tons per year.");
		System.out.println();

		System.out.println("   The game has four renewable energy sources as areas to invest in:");
		System.out.println("   Solar Power, Wind Power, BioFuel and Hydropower.");
		System.out.println(
				"   The aim is to buy a project, invest in it and watch it grow, while maintaining your financial resources.");
		System.out.println(
				"   Run out of money and you will be unable to continue investing in renewable energy schemes!");
		System.out.println("   Although our game is based on an eco-friendly stance,");
		System.out.println(
				"   we hope it can help influence and grow interest in a more renewable energy focused future!");

		System.out.println();

		System.out.println(
				"   We know you want to save the planet but also enjoy playing games, so this property game is for you!");
		System.out.println("\tFollow the console directions below and the game will take care of the rest. Enjoy :)");
		System.out.println("");
		System.out.println("\t\t\tVirtual board game created by Eoin, Michael, Matt, and Connor");

		System.out.println();
		System.out.println(
				"**************************************************************************************************************");

	}

	public static void runGame() {
		introSOP();
		// Game objects
		Scanner scanner = new Scanner(System.in);

		// max dice number is 6 as per dice class
		Dice diceOne = new Dice(6);
		Dice diceTwo = new Dice(6);

		GameBoard gameboard = new GameBoard();
		gameboard.generateGameBoard();

		// RegisterPlayers
		Player[] playerList = RegisterPlayers(scanner);

		for (int i = 0; i < playerList.length; i++) {
			TurnOptions(playerList, playerList[i], gameboard, scanner);
			PlayerRollsDice(playerList[i], gameboard, diceOne, diceTwo);
			PlayerMoves(playerList[i], gameboard, diceOne, diceTwo);
			CheckWhereLanded(playerList[i], gameboard, scanner);
			CheckedIfPassed(playerList[i], gameboard);
			CheckGameState(playerList, gameboard);

			// reset if last index
			if (i == playerList.length - 1) {
				i = -1;
			}
		}

	}

	/**
	 * Method to prompt the user how many players they wish to include in there game
	 * then prompt for each players name ensuring they are unique and returning an
	 * array
	 * 
	 * @param scanner
	 * @return Player Array named players
	 */
	public static Player[] RegisterPlayers(Scanner scanner) {
		// Data used
		boolean validInput = false;
		String response, player1Name, player2Name, player3Name, player4Name;
		int option = 0;
		Player p1, p2, p3, p4;
		Player[] players = new Player[0];

		// User is prompt for number of players to be included, loop until the user has
		// entered a valid number of players
		do {
			System.out.println("\t\t\tPlease enter a valid number of players to begin the game (2 - 4)");
			response = scanner.next();

			switch (response) {
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
				System.out.println("You've entered an invalid response!");
				System.out.println("Make sure you enter a value in the given range");
			}

		} while (validInput == false);
		validInput = false;

		// Construct Players relating to the option the user has entered
		switch (option) {
		case 2: // Two player option
			players = new Player[2];

			// Prompt for Player One's name
			System.out.println("\t\t\tPlease enter the display name for Player One");
			player1Name = scanner.next();

			// Construct player one and add to array
			p1 = new Player(player1Name, 500, 0);
			players[0] = p1;

			// Prompt for player two's name and check that it is unique from player one's
			do {
				System.out.println("\t\t\tPlease enter the display name for Player Two");
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
		// scanner.close();
		return players;
	}

	/**
	 * Method that will ask the user if they would like to take their turn or quit
	 * the game
	 * 
	 * @return boolean
	 */
	public static void TurnOptions(Player[] players, Player player, GameBoard gameboard, Scanner scanner) {
		// data used
		boolean validInput = false;
		String response;

		System.out.println();
		System.out.println("It's " + player.getName() + "'s go!");
		System.out.println("It's your turn to help save the world, what would you like to do?");
		do {
			System.out.println("\t\t\t[1] Take Turn");
			System.out.println("\t\t\t[2] Display Balance");
			System.out.println("\t\t\t[3] Show Game Board Position");
			System.out.println("\t\t\t[4] Upgrade Squares you own");
			System.out.println("\t\t\t[5] Quit the game");
			response = scanner.next();

			switch (response) {
			case "1":
				validInput = true;
				break;
			case "2":
				System.out.println(player.getName() + "'s balance is £" + player.getBalance());
				;
				break;
			case "3":
				System.out.println(player.getName() + ", You are on "
						+ gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
				System.out.println();
				break;
			case "4":
				upgradePropertyFromMenu(player, null, null, scanner); // null as arraylists are passed in method
				
				break;
			case "5":
				endGame(players);
				

				break;
			default:
				System.out.println("You've entered an invalid response!");
				System.out.println("Make sure you enter a value in the given range");
			}

		} while (validInput == false);
		// s.close();
		System.out.println();
	}

	/**
	 * Method to roll two dice object for a player and prompt them what they have
	 * rolled
	 */
	public static void PlayerRollsDice(Player player, GameBoard gameboard, Dice diceOne, Dice diceTwo) {

		// Get player to roll dice
		diceOne.roll();
		diceTwo.roll();
		System.out.println(
				player.getName() + ", you have rolled a " + diceOne.getValue() + " and a " + diceTwo.getValue());
		System.out.println();
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
		// update newPosition
		int newPosition = player.getCurrentPosition() + diceOne.getValue() + diceTwo.getValue();

		// check if this new position is in range if not take away the overlap
		while (newPosition > (gameboard.getGameSquares().size() - 1)) {
			newPosition -= gameboard.getGameSquares().size();
		}

		// Set lastRoll player var
		player.setLastRoll(diceOne.getValue() + diceTwo.getValue());

		// Set new player position
		player.setCurrentPosition(newPosition);

		// Display where they have landed
		System.out.println(player.getName() + ", you were on "
				+ gameboard.getGameSquares().get(player.getLastPosition()).getName() + ", and have now landed on "
				+ gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
	}

	/**
	 * Method to check if a player has passed the go square
	 * 
	 * @param player
	 * @param gameboard
	 * @param diceOne
	 * @param diceTwo
	 */
	public static void CheckedIfPassed(Player player, GameBoard gameboard) {
		// data used
		int lastPosition = player.getLastPosition(); // 0
		int LastRoll = player.getLastRoll(); // 8

		// 1. Check all squares that the player passed during PlayerMoves
		for (int i = 1; i <= LastRoll; i++) {
			// reset if the player has done a loop of the board
			if (lastPosition > (gameboard.getGameSquares().size() - 1)) {
				lastPosition -= gameboard.getGameSquares().size();
			}

			// 2. if the square is a GoSquare
			if (gameboard.getGameSquares().get(lastPosition).getClass().getTypeName() == "monopoly.GoSquare") {
				// 3. State to the player they have passed the go square and update their
				// balance
				GoSquare holder = (GoSquare) gameboard.getGameSquares().get(lastPosition);
				System.out.println("During this move you have passed " + holder.getName() + " and get a collection of £"
						+ holder.getCollection());
				player.updateBalanceAdd(holder.getCollection());
			}

			// increment index
			lastPosition++;
		}
	}

	/**
	 * Method to check the status of the square that the player has landed on,
	 * possible outcomes are; 1. Square is free and available to buy 2. Square is
	 * owned by another player (owe money) 3. Square is owned by the current player
	 * (Upgrade) 4. Square is owned and fully upgraded
	 * 
	 * @param player
	 * @param gameboard
	 */
	public static void CheckWhereLanded(Player player, GameBoard gameboard, Scanner scanner) {
		// Data used
		String userResponse;
		boolean validInput = false;

		// Either the Player has landed on a GoSquare or a PropertySquare
		// If GoSquare ... nothing should happen
		// If PropertySquare
		if (gameboard.getGameSquares().get(player.getCurrentPosition()).getClass()
				.getTypeName() == "monopoly.PropertySquare") {
			PropertySquare currentSquare = (PropertySquare) gameboard.getGameSquares().get(player.getCurrentPosition());

			// Possible outcomes are
			// 1. Square is free and available to buy
			if (currentSquare.isOwned() == false) {
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
				System.out.print(" is avaliable to purchase for £" + currentSquare.getCost());

				// Ask user if they would like to purchase property
				do {
					System.out.println(" Would you like to purchase this property? (Y/N)");
					userResponse = scanner.next();

					// If the user answered yes then purchase
					if (userResponse.equalsIgnoreCase("y")) {
						validInput = true;

						// added current square parameter in method call (Michael)
						currentSquare.buyProperty(player, currentSquare);

					} else if (userResponse.equalsIgnoreCase("N")) {
						System.out.println(player.getName() + " did not purchase " + currentSquare.getName());

						validInput = true;

					} else if (userResponse.equalsIgnoreCase("y") && player.getBalance() < currentSquare.getCost()) {
						System.out.println("Sorry you can not afford this!");
						validInput = true;

					} else if (userResponse.equalsIgnoreCase("N")) {
						System.out.println(player.getName() + " did not purchase " + currentSquare.getName());

						validInput = true;
					} else {
						System.out.println("Please enter a valid response");
					}
				} while (validInput == false);
			}

			// 2. Square is owned by another player (owe money)
			// add end game if tax is more than players balance, added by michael
			else if (currentSquare.isOwned() == true && currentSquare.getOwner() != player) {
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName());
				System.out.print(" is owned by " + currentSquare.getOwner().getName() + " \n");

				currentSquare.payTax(player);

			}

			// 3. Square is owned by the current player (Upgrade)
			else if (currentSquare.isOwned() == true && currentSquare.getOwner() == player
					&& currentSquare.isFullyUpgraded() == false) {
				System.out.print(player.getName() + ", you already own ");
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName());

				// Ask user if they would like to upgrade property
				do {

					
					System.out.println(" Would you like to upgrade this property for £" + currentSquare.getNextDevCost()
							+ "? (Y/N)");
					userResponse = scanner.next();

//					System.out.println(" Would you like to upgrade this property for £" + currentSquare.getMinDevCost()
//							+ "? (Y/N)");
//					userResponse = scanner.next();

					// If the user answered yes then upgrade
					if (userResponse.equalsIgnoreCase("y")) {
						validInput = true;

						currentSquare.upgradeProperty();

					} else if (userResponse.equalsIgnoreCase("N")) {
						System.out.println(player.getName() + " did not upgrade " + currentSquare.getName());
						validInput = true; // added by michael to end turn/looping

					} else {
						System.out.println("Please enter a valid response");
					}
				} while (validInput == false);

			}

			// 4. Square is owned and fully upgraded
			else if (currentSquare.isOwned() == true && currentSquare.getOwner() == player
					&& currentSquare.isFullyUpgraded() == true) {
				System.out.print(player.getName() + ", you already own ");
				System.out.print(gameboard.getGameSquares().get(player.getCurrentPosition()).getName()
						+ " and have developed it fully, thank you for investing in a cleaner enviornment!");
			}

		}

	}

	/**
	 * Method that will search through the current list of players and check if they
	 * are still allowed to continue in the game Need to edit so that if tax
	 * deduction puts balance below then end game
	 */
	public static void CheckGameState(Player[] playerList, GameBoard gameboard) {
		// data used
		boolean end = false;

		// search through player list and check their balance
		for (int i = 0; i < playerList.length; i++) {
			if (playerList[i].getBalance() <= 0) {
				System.out.println(playerList[i].getName() + ", you have ran out of credit ....");
				System.out.println(
						"Your efforts to create a more sustainible enviornment were valiant, but you do not have the requirements to continue investing in any projects!");
				end = true;
				endGame(playerList);
				System.exit(0);
			}
		}

		// If end is true then the game should end
	}

	/**
	 * Author Michael Allows player to upgrade property even when not on that
	 * specific square
	 */
	public static void upgradePropertyFromMenu(Player player, PropertySquare currentSquare,
			PropertySquare BoughtProperty, Scanner scanner) {
		// added by Michael adding arraylist to store owned properties by a player
		ArrayList<PropertySquare> ownedPropertiesList = player.getOwnedProperties();

		// method reverts back to menu if player tries to upgrade when they own no
		// properties
		// do {

		if (ownedPropertiesList.isEmpty() == false) {
			System.out.println(player.getName() + " you own " + ownedPropertiesList.size() + " Properties");

			// enhanced for loop to show all properties player owns
			for (PropertySquare ownedProperties : ownedPropertiesList) {

				System.out.println(
						player.getName() + " you own " + ownedProperties.getName() + " " + ownedProperties.getID());

			}

			// data for switch cases

			boolean validInput = false; // may not need
			String responseUpgrade;

			do {
				System.out.println();
				System.out.println(player.getName() + " please enter the ID of the square you'd like to upgrade ");

				responseUpgrade = scanner.next();

				switch (responseUpgrade) {
				case ("A1"):

					// For loop to compare ID with user passed in response and upgrade this square
					// as a result
					for (PropertySquare ownedPropertyA1 : ownedPropertiesList) {
						if (ownedPropertyA1.getID() == "A1") {
							System.out.println("Going to upgrade " + ownedPropertyA1.getName());
							ownedPropertyA1.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");

						}
					}

					break;

				case "A2":
					for (PropertySquare ownedPropertyA2 : ownedPropertiesList) {
						if (ownedPropertyA2.getID() == "A2") {
							System.out.println("Going to upgrade " + ownedPropertyA2.getName());
							ownedPropertyA2.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "A3":
					for (PropertySquare ownedPropertyA3 : ownedPropertiesList) {
						if (ownedPropertyA3.getID() == "A3") {
							System.out.println("Going to upgrade " + ownedPropertyA3.getName());
							ownedPropertyA3.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "B1":
					for (PropertySquare ownedPropertyB1 : ownedPropertiesList) {
						if (ownedPropertyB1.getID() == "B1") {
							System.out.println("Going to upgrade " + ownedPropertyB1.getName());
							ownedPropertyB1.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "B2":
					for (PropertySquare ownedPropertyB2 : ownedPropertiesList) {
						if (ownedPropertyB2.getID() == "B2") {
							System.out.println("Going to upgrade " + ownedPropertyB2.getName());
							ownedPropertyB2.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "C1":
					for (PropertySquare ownedPropertyC1 : ownedPropertiesList) {
						if (ownedPropertyC1.getID() == "C1") {
							System.out.println("Going to upgrade " + ownedPropertyC1.getName());
							ownedPropertyC1.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "C2":
					for (PropertySquare ownedPropertyC2 : ownedPropertiesList) {
						if (ownedPropertyC2.getID()  == "C2") {
							System.out.println("Going to upgrade " + ownedPropertyC2.getName());
							ownedPropertyC2.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "C3":
					for (PropertySquare ownedPropertyC3 : ownedPropertiesList) {
						if (ownedPropertyC3.getID() == "C3") {
							System.out.println("Going to upgrade " + ownedPropertyC3.getName());
							ownedPropertyC3.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "D1":
					for (PropertySquare ownedPropertyD1 : ownedPropertiesList) {
						if (ownedPropertyD1.getID() == "D1") {
							System.out.println("Going to upgrade " + ownedPropertyD1.getName());
							ownedPropertyD1.upgradeProperty();
							validInput = true;
						} else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				case "D2":
					for (PropertySquare ownedPropertyD2 : ownedPropertiesList) {
						if (ownedPropertyD2.getID() == "D2") {
							System.out.println("Going to upgrade " + ownedPropertyD2.getName());
							ownedPropertyD2.upgradeProperty();
							validInput = true;
						}

						else {
							System.out.println("Can't find ID of owned Square");
						}
					}

					break;

				default:
					System.out.println("You've entered an invalid response or don't own this property");
					System.out.println("Make sure you enter a value in uppercase e.g B1");
				}

			} while (validInput == false);

			System.out.println();

		}

		else {
			System.out.println("Going back to menu as " + player.getName() + " you own " + ownedPropertiesList.size()
					+ " Properties");
		}

		// } while (ownedPropertiesList.isEmpty() == false);
		// above ends the uggrade path when the player says no
		System.out.println();
		// || scanner.next() == "no" ||scanner.next() == "NO" ||scanner.next() == "No"
	}

	/**
	 * Author Matt endgame method, that at the choice of a player ending the game,
	 * will display the end game scores in descending order (from highest currency
	 * to lowest)
	 * 
	 * @param players
	 */
	public static void endGame(Player[] players) {
		int ranking = 1;

		ArrayList<Player> playerRank = new ArrayList<Player>(Arrays.asList(players));

		for (Player player : playerRank) {
			player.getBalance();
		}
		playerRank.sort(Comparator.comparing(Player::getBalance).reversed());

		System.out.println("Well done " + playerRank.get(0).getName() + ", you are the winner of Save the World!");
		System.out.println("Your balance is: " + playerRank.get(0).getBalance());
		System.out.println(
				"You have contributed the most to a more eco friendly enviornment and in your successful investments, made the world a cleaner place for all!");
		System.out.println();

		// loop that will cycle through the players who were active in the game - using
		// enhanced for loop
		System.out.println("Player Rankings!");
		System.out.println("-----------------");
		for (Player playerPos : playerRank) {
			System.out.println(ranking + ": " + playerPos.getName() + ", Balance: " + playerPos.getBalance());
			ranking++;
		}
		System.out.println("Thank you for playing our board game, We hope you had a lot of fun!");
		System.exit(0);
	}

	
	/**
	 * method made simply to simulate the tax and property buy methods - for presentation
	 */
	public static void runGameExampleForTax() {
		introSOP();
		// Game objects
		Scanner scanner = new Scanner(System.in);

		// max dice number is 6 as per dice class
		Dice diceOne = new Dice(6);
		Dice diceTwo = new Dice(6);

		
		PropertySquare a1 = new PropertySquare("A1", "Urban Wind Farm", 100, 75, 250, 500);
		PropertySquare a2 = new PropertySquare("A2", "Wind Tunnel", 100, 75, 250, 500);
		PropertySquare a3 = new PropertySquare("A3", "Offshore Wind Farm", 150, 100, 250, 500);
		
		ArrayList<Square> gameSquares = new ArrayList<Square>();
		gameSquares.add(a1);
		gameSquares.add(a2);
		gameSquares.add(a3);
		
		GameBoard gameboard = new GameBoard(gameSquares);

		// RegisterPlayers
		Player[] playerList = RegisterPlayers(scanner);

		for (int i = 0; i < playerList.length; i++) {
			TurnOptions(playerList, playerList[i], gameboard, scanner);
			PlayerRollsDice(playerList[i], gameboard, diceOne, diceTwo);
			PlayerMoves(playerList[i], gameboard, diceOne, diceTwo);
			CheckWhereLanded(playerList[i], gameboard, scanner);
			CheckedIfPassed(playerList[i], gameboard);
			CheckGameState(playerList, gameboard);

			// reset if last index
			if (i == playerList.length - 1) {
				i = -1;
			}
		}

	}
	
	
	
	
	
	
	
}
