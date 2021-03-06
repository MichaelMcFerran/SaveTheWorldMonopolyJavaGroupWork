/**
 * 
 */
package gamecodeMichael;

/**
 * @author MIchael(edited by)
 *
 */
public class Player {

	//Instance variables
		private String name;
		
		private int balance;
		
		/**
		 * balance must be at least zero for game to run
		 */
		public final int balanceMin = 0;
		
		/**
		 * balance must be at most balance limit of 32767
		 */
		public final int balanceMax = 32767;
		
		private int currentPosition;
		
		/**
		 * player position must be at an index value of 0 at least
		 */
		public final int currentPositionMinimum = 0;
		
		/**
		 * player position must be at an index value of 11 at most
		 */
		public final int currentPositionMaximum = 11;
		
		
		private int lastPosition;
		
		/**
		 * player position must be at an index value of 0 at least
		 */
		public final int lastPositionMinimum = 0;
		
		/**
		 * player position must be at an index value of 11 at most
		 */
		public final int lastPositionMaximum = 11;
		
		
		private int lastRoll;
		
		/**
		 * two roll combinations must be at least 2 as 1-6
		 */
		public final int lastRollMinimum = 2;
		
		/**
		 * two roll combinations must be at most 12 as 1-6
		 */
		public final int lastRollMaximum = 12;
		
		
		private int playerNumber;
		
		/**
		 * player number must be a minimum of 1
		 */
		public final int playerNumberMin = 1;
		
		/**
		 * player number must be a maximum of 4 as per requirements, can be edited to store more players if
		 * added functionality is required in future
		 */
		public final int playerNumberMax = 4;
		
		//Constructors
		/**
		 * Default constructor
		 */
		public Player() {
			
		}
		
		/**
		 * Constructor with args
		 * @param name
		 * @param balance
		 */
		public Player(String name, int balance, int currentPosition) {
			this.setName(name);
			this.setBalance(balance);
			this.setCurrentPosition(currentPosition);
		}
		
		//Getters and setters
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * business rule- player needs a name
		 * @param name the name to set
		 */
		public void setName(String name)throws IllegalArgumentException {
			if (name.length() > 0) {
				this.name = name;
			} else {
				throw new IllegalArgumentException("Name must be entered");
			}
		}
			
		

		/**
		 * @return the balance
		 */
		public int getBalance() {
			return balance;
		}

		/**
		 * @param balance must be above minimum of zero
		 */
		public void setBalance(int balance) throws IllegalArgumentException {
			if ((balance >= balanceMin)&& (balance <= balanceMax)) {
				this.balance = balance;
			} else {
				throw new IllegalArgumentException("must have a balance");
			}
		}
			

		/**
		 * @return the position
		 */
		public int getCurrentPosition() {
			return currentPosition;
		}

		/**
		 * @param position the position to set
		 */
		public void setCurrentPosition(int newPosition) throws IllegalArgumentException {
			if ((currentPosition>=currentPositionMinimum) && (currentPosition<=currentPositionMaximum) ) {
				this.setLastPosition(this.currentPosition);
				this.currentPosition = newPosition;
			} else {
				throw new IllegalArgumentException("position is out of index range");
			}
		}
			
		
		
		
		/**
		 * @return the lastPosition
		 */
		public int getLastPosition() {
			return lastPosition;
		}

		/**
		 * @param lastPosition as per current position must be in range index 0-11
		 */
		public void setLastPosition(int lastPosition)throws IllegalArgumentException {
			if ((lastPosition>=lastPositionMinimum)&& (lastPosition<=lastPositionMaximum) ) {
				this.lastPosition = lastPosition;
			} else {
				throw new IllegalArgumentException("position is out of index range");
			}
		}
			
		

		/**
		 * @return the lastRoll
		 */
		public int getLastRoll() {
			return lastRoll;
		}

		/**
		 * @param lastRoll the lastRoll to set
		 */
		public void setLastRoll(int lastRoll)  throws IllegalArgumentException {
			if ((lastRoll >= lastRollMinimum) && (lastRoll <= lastRollMaximum)) {
				this.lastRoll = lastRoll;
			} else {
				throw new IllegalArgumentException("two dice roll 1-6, so range is outside of 1-12");
			}
			
		}
		
		public int getPlayerNumber() {
			return playerNumber;
		}

		/**
		 * business rule - player must have a number 1-4, max can be changed for more players in future
		 * @param playerNumber
		 */
		public void setPlayerNumber(int playerNumber) throws IllegalArgumentException {
			if ((playerNumber >= playerNumberMin) && (playerNumber <= playerNumberMax)) {
				this.playerNumber = playerNumber;
			} else {
				throw new IllegalArgumentException("player must have a number between 1-4");
			}
			
		}

		//Other methods
		
		public void updateBalanceAdd(int amount) {
			this.setBalance(this.balance +amount);
			System.out.println(this.getName() +"'s balance = �" +this.getBalance());
		}
		
		public void updateBalanceSub(int amount) {
			this.setBalance(this.balance -amount);
			System.out.println(this.getName() +"'s balance = �" +this.getBalance());
		}
		
	}
