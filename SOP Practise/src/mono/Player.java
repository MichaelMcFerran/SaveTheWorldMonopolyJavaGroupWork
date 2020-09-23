package mono;

public class Player {
	
	//Instance variables
	private String name;
	private double balance;
	private int currentPosition;
	private int lastPosition;
	private int lastRoll;
	
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
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
	public void setCurrentPosition(int newPosition) {
		this.setLastPosition(this.currentPosition);
		this.currentPosition = newPosition;
	}
	
	
	/**
	 * @return the lastPosition
	 */
	public int getLastPosition() {
		return lastPosition;
	}

	/**
	 * @param lastPosition the lastPosition to set
	 */
	private void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
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
	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}

	//Other methods
	public void updateBalanceAdd(double amount) {
		this.setBalance(this.balance +amount);
		System.out.println(this.getName() +"'s balance = £" +this.getBalance());
	}
	
	public void updateBalanceSub(double amount) {
		this.setBalance(this.balance -amount);
		System.out.println(this.getName() +"'s balance = £" +this.getBalance());
	}
	
}
