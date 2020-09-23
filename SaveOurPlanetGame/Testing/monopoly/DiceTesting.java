package monopoly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Testing the dice class with JUNIT5
 * @author MIchael
 *
 */
class DiceTesting {

	// create data
		int value, range, valueInvalid, rangeInvalidLower, rangeInvalidUpper;

		@BeforeEach
		void setUp() throws Exception {
			// initialise the test data
			value = 0;
			valueInvalid = 2;
			range = 6;

			// Boundary value analysis
			rangeInvalidLower = 0;
			rangeInvalidUpper = 7;

		}

		/**
		 * Tests default constructor
		 */
		@Test
		void testDiceDefaultConstructor() {
			Dice dice1 = new Dice();
			assertNotNull(dice1);
		}

		/**
		 * Tests constructor with arguments and valid Values
		 */
		@Test
		void testDiceConstructorArgsValid() {
			Dice dice1 = new Dice(range);
			assertEquals(range, dice1.getRange());
		}

		/**
		 * Tests constructor with arguments and invalid Values
		 */
		@Test
		void testDiceConstructorArgsInvalid() {
			assertThrows(IllegalArgumentException.class, () -> {
				Dice dice1 = new Dice(rangeInvalidLower);
			});

		}

		/**
		 * Tests valid range values
		 */
		@Test
		void testValidRange() {
			Dice dice1 = new Dice();
			dice1.setRange(range);
			assertEquals(range, dice1.getRange());
		}

		/**
		 *  Tests invalid range values
		 */
		@Test
		void testInvalidRange() {
			Dice dice1 = new Dice();

			// invalid range test lower
			assertThrows(IllegalArgumentException.class, () -> {
				dice1.setRange(rangeInvalidLower);
			});

			// invalid range test upper
			assertThrows(IllegalArgumentException.class, () -> {
				dice1.setRange(rangeInvalidUpper);
			});
		}



		/**
		 * Tests the roll method
		 */
		@Test
		void testRoll() {
			//create a dice object
			Dice dice1 = new Dice(range);
			
			//method call
			dice1.roll();
			
			//check output is present
			System.out.println(dice1.getValue());
			//checks if value is present
			assertNotNull(dice1.getValue());
			
			//checks if value present after method call is above zero
			if(dice1.getValue() != 0) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}

	}




