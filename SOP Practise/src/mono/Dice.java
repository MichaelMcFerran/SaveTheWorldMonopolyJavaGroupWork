package mono;

import java.util.Random;

public class Dice {
	
	//Instance variables
	private int range;
	private int value = 0;
	

	
	// Default Constructor
	public Dice(){
		
	}
	
	//Constructor with args
	public Dice(int range) {
		this.setRange(range);
	}
	
	//Getters and setters
	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * Business rule, range of dice must be above 0 and below 6 
	 * @param range the range to set
	 */
	public void setRange(int range) {
		if (range > 0) {
			this.range = range;
		} else {
			throw new IllegalArgumentException("Range must be greater than 0");
		}
	}
	
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 *  Value defaults to zero and once roll() method is called it will be set to that value
	 */
	private void setValue(int value) {
		this.value = value;
	}

	//Method
	/**
	 * Method to produce a random number in the given range of the dice object
	 * @return
	 */
	public int roll() {
		int ans;
		Random r = new Random();
		ans = r.nextInt(this.range) +1;
		this.setValue(ans);
		return ans;
	}
	
	

}
