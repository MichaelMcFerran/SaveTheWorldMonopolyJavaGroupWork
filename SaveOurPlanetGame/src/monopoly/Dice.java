package monopoly;


import java.util.Random;

/**
 * @author MIchael
 * Updated dice to include business rules and improve readability
 */
public class Dice {

	// Instance variables
		private int range;
		
		/**
		 * dice is 6 sided, and only 6 sided. can be changed
		 */
		public final int maxRange = 6;
		
		/*
		 * value to reset before each roll method call
		 */
		private int value = 0;

		// Default Constructor
		public Dice() {

		}

		// Constructor with args
		public Dice(int range) {
			this.setRange(range);
		}

		// Getters and setters
		/**
		 * @return the range
		 */
		public int getRange() {
			return range;
		}

		/**
		 * Business rule, range of dice must be above 0 and below 6
		 * 
		 * @param range the range to set
		 */
		public void setRange(int range) throws IllegalArgumentException {
			if ((range <= maxRange) && (range > 0)) {
				this.range = range;
			} else {
				throw new IllegalArgumentException("Range must be max of 6 " + this.maxRange);
			}
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value the value to set Value defaults to zero and once roll() method
		 *              is called it will be set to that value
		 */
		private void setValue(int value) {
			this.value = value;
		}

		// Method
		/**
		 * Method to produce a random number in the given range of the dice object
		 * 
		 * @return
		 */
		public int roll() {
			int ans;
			Random r = new Random();
			ans = r.nextInt(this.range) + 1;
			this.setValue(ans);
			return ans;
		}

//		/**
//		 * used for testing
//		 * @param args
//		 */
//		public static void main(String[] args) {
//			// create die objects to test they work
//			Dice diceOne = new Dice(2); //can set dice range up to a max of 6
//			Dice diceTwo = new Dice(maxRange);
//	
//			// method call
//			diceOne.roll();
//			diceTwo.roll();
//	
//			System.out.println("dice one random value is " + diceOne.getValue());
//			System.out.println("dice two random value is " + diceTwo.getValue());
//	
//		}
	
	}