package monopoly;


/**
 * 
 * This class is property square, which extends the properties of square class 
 * and allows developments to be made on these squares, collect tax and so on
 * added business rules for testing- Michael
 */
public class PropertySquare extends Square {
	
	//Instance variables
	private double cost;
	private double tax;
	private Player owner;
	private double minDevCost;
	private double majDevCost;
	
	//Variables used for checks
	private boolean isOwned = false;
	private int minDevCount = 0;
	private int majDevCount = 0;
	private double nextDevCost = 0;
	private boolean fullyUpgraded = false;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public PropertySquare() {
		
	}
	
	/**
	 * Constructor with args
	 * @param ID
	 * @param name
	 * @param cost
	 * @param tax
	 * @param minDevCost
	 * @param majDevCost
	 */
	public PropertySquare(String ID, String name, double cost, double tax, double minDevCost, double majDevCost) {
		this.setID(ID);
		this.setName(name);
		this.setCost(cost);
		this.setTax(tax);
		this.setNextDevCost(nextDevCost);
		this.setMinDevCost(minDevCost);
		this.setMajDevCost(majDevCost);
	}
	
	//Getters and setters
	/**
	 * @return the cost
	 */
	public double getCost() {
		return this.cost;
	}
	/**
	 * Business rule as each property square must cost something but not be an extreme amount
	 * @param cost the cost to set
	 */
	public void setCost(double cost) throws IllegalArgumentException {
		if ((cost > 0) && (cost <200000)) {
			this.cost = cost;
		} else {
			throw new IllegalArgumentException("cost of property is outside reasonable range");
		}
		
	}
	/**
	 * @return the tax
	 */
	public double getTax() {
		return this.tax;
	}
	/**
	 * Business rule to set tax amount as has to cost something but not be an extreme amount
	 * @param tax the tax to set
	 */
	public void setTax(double tax) throws IllegalArgumentException {
		if ((tax > 0) && (tax <200000)) {
			this.tax = tax;
		} else {
			throw new IllegalArgumentException("tax of property is outside reasonable range");
		}
		
	}
	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}
	/**
	 * Can only be a max of one owner of a square - business rule
	 * so a check would be if player has a name as one name per player object
	 * @param owner object is set
	 */
	private void setOwner(Player owner) throws IllegalArgumentException {
		if (owner.getName()!=null) {
			this.owner = owner;
		} else {
			throw new IllegalArgumentException("only own owner of square allowed");
		}
		
	}
	/**
	 * @return the minDevCost
	 */
	public double getMinDevCost() {
		return this.minDevCost;
	}
	/**
	 * Business rule - development cost must be something and in a reasonable range
	 * @param minDevCost variable is being set
	 */
	public void setMinDevCost(double minDevCost) throws IllegalArgumentException {
		if ((minDevCost > 0) && (minDevCost <800000)) {
			this.minDevCost = minDevCost;
		} else {
			throw new IllegalArgumentException("minimum development cost of property is outside reasonable range");
		}
		
	}
	/**
	 * Business rule - major development cost must be something and in a reasonable range
	 * @return the majDevCost
	 */
	public double getMajDevCost() {
		return this.majDevCost;
	}
	
	/**
	 * @param majDevCost variable is being set
	 */
	public void setMajDevCost(double majDevCost) throws IllegalArgumentException {
		if ((majDevCost > 0) && (majDevCost <800000)) {
			this.majDevCost = majDevCost;
		} else {
			throw new IllegalArgumentException("minimum development cost of property is outside reasonable range");
		}
		
	}
	
	/**
	 * @return the isOwned
	 */
	public boolean isOwned() {
		return isOwned;
	}

	/**
	 * Business rule to ensure boolean can be set correctly
	 * @param isOwned boolean setter
	 */
	private void setOwned(boolean isOwned) throws IllegalArgumentException {
		if ((isOwned == true) || (isOwned == false)) {
			this.isOwned = isOwned;
		} else {
			throw new IllegalArgumentException("property square is either owned by one person or none");
		}
		
	}

	/**
	 * @return the nextDevCost
	 */
	public double getNextDevCost() {
		if (this.minDevCount <= 3) {
			return minDevCost;
		} else if (this.minDevCount >= 3 && this.majDevCount < 1) {
			return majDevCost;
		} else {
			
		}
		return nextDevCost;
		
	}

	/** unused in this class, but is in main game class
	 * Business rule - development cost must be something and within a reasonable limit
	 * @param nextDevCost the nextDevCost to set
	 */
	private void setNextDevCost(double nextDevCost)  throws IllegalArgumentException {
		if ((nextDevCost >= 0) && (nextDevCost <800000)) {
			this.nextDevCost = nextDevCost;
		} else {
			throw new IllegalArgumentException("next development cost of property is outside reasonable range");
		}
		
	}

	/**
	 * @return the fullyUpgraded
	 */
	public boolean isFullyUpgraded() {
		return fullyUpgraded;
	}

	public int getMinDevCount() {
		return minDevCount;
	}

	public void setMinDevCount(int minDevCount) {
		this.minDevCount = minDevCount;
	}

	public int getMajDevCount() {
		return majDevCount;
	}

	public void setMajDevCount(int majDevCount) {
		this.majDevCount = majDevCount;
	}

	//Other Methods
	/**
	 * Added param current square by Michael
	 * @param player
	 * @param currentSquare
	 */
	public void buyProperty(Player player, PropertySquare currentSquare) {
		//Set variables
		this.setOwner(player);
		this.setOwned(true);
		//added
		player.setOwnedProperties(currentSquare);
		
		//Display message
		System.out.println(player.getName() +" has just purchased " +this.getName() +" for £" +this.getCost());
		
		//Adjust player balance
		player.updateBalanceSub(this.getCost());
	}
	
	public void upgradeProperty() {
		//Set count to keep track of upgrade
		if (this.minDevCount < 3 ) {
			this.minDevCount++;
			System.out.println("Small Upgrade successful! " +"This is upgrade: "+ this.minDevCount);
		} else if (this.minDevCount >= 3 && this.majDevCount < 1) {
			this.nextDevCost = this.majDevCost;
			this.minDevCount++;
			this.majDevCount++;
			System.out.println("Major Upgrade " +this.majDevCount +  "Complete!");
		} else if (this.minDevCount >= 3 && this.majDevCount >= 1) {
			this.majDevCount++;
			System.out.println("Maximum Upgrade");
			fullyUpgraded = true;
		}
		
		//Set new tax, adjust owner balance and display message
		switch (this.minDevCount) {
		case 1 : this.setTax(this.tax +(0.1*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(minDevCost); break;
		case 2 : this.setTax(this.tax +(0.2*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(minDevCost); break;
		case 3 : this.setTax(this.tax +(0.3*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(minDevCost); break;
		default : break;
		}
		
		switch (this.majDevCount) {
		case 1 : this.setTax(this.tax +(0.30*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(majDevCost);break;
		default : break;
		}	
	}
	
	public void payTax(Player taxPayer) {
		System.out.println(taxPayer.getName() +" must pay £" +this.getTax() +" to " +this.getOwner().getName());
		taxPayer.updateBalanceSub(this.getTax());
		this.getOwner().updateBalanceAdd(this.getTax());
	}
	
	
	
	

}

