package mono;

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
	private double nextDevCost = this.minDevCost;
	private boolean fullyUpgraded = false;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public PropertySquare() {
		
	}
	
	public PropertySquare(String ID, String name, double cost, double tax, double minDevCost, double majDevCost) {
		this.setID(ID);
		this.setName(name);
		this.setCost(cost);
		this.setTax(tax);
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
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the tax
	 */
	public double getTax() {
		return this.tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}
	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	private void setOwner(Player owner) {
		this.owner = owner;
	}
	/**
	 * @return the minDevCost
	 */
	public double getMinDevCost() {
		return this.minDevCost;
	}
	/**
	 * @param minDevCost the minDevCost to set
	 */
	public void setMinDevCost(double minDevCost) {
		this.minDevCost = minDevCost;
	}
	/**
	 * @return the majDevCost
	 */
	public double getMajDevCost() {
		return this.majDevCost;
	}
	/**
	 * @param majDevCost the majDevCost to set
	 */
	public void setMajDevCost(double majDevCost) {
		this.majDevCost = majDevCost;
	}
	
	/**
	 * @return the isOwned
	 */
	public boolean isOwned() {
		return isOwned;
	}

	/**
	 * @param isOwned the isOwned to set
	 */
	private void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	/**
	 * @return the nextDevCost
	 */
	public double getNextDevCost() {
		return nextDevCost;
	}

	/**
	 * @param nextDevCost the nextDevCost to set
	 */
	private void setNextDevCost(double nextDevCost) {
		this.nextDevCost = nextDevCost;
	}

	/**
	 * @return the fullyUpgraded
	 */
	public boolean isFullyUpgraded() {
		return fullyUpgraded;
	}

	//Other Methods
	public void buyProperty(Player player) {
		//Set variables
		this.setOwner(player);
		this.setOwned(true);
		
		//Display message
		System.out.println(player.getName() +" has just purchased " +this.getName() +" for £" +this.getCost());
		
		//Adjust player balance
		player.updateBalanceSub(this.getCost());
	}
	
	public void upgradeProperty() {
		//Set count to keep track of upgrade
		if (this.minDevCount < 3 ) {
			this.minDevCount++;
			System.out.println("Min" +this.minDevCount);
		} else if (this.minDevCount >= 3 && this.majDevCount < 1) {
			this.nextDevCost = this.majDevCost;
			this.minDevCount++;
			this.majDevCount++;
			System.out.println("Maj" +this.majDevCount);
		} else if (this.minDevCount >= 3 && this.majDevCount >= 1) {
			this.majDevCount++;
			System.out.println("Max");
			fullyUpgraded = true;
		}
		
		//Set new tax, adjust owner balance and display message
		switch (this.minDevCount) {
		case 1 : this.setTax(this.tax +(0.1*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(minDevCost); break;
		case 2 : this.setTax(this.tax +(0.125*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(minDevCost); break;
		case 3 : this.setTax(this.tax +(0.15*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(minDevCost); break;
		default : break;
		}
		
		switch (this.majDevCount) {
		case 1 : this.setTax(this.tax +(0.2*this.tax)); System.out.println(this.getName() +" now has a tax cost of £" +this.getTax()); owner.updateBalanceSub(majDevCost);break;
		default : break;
		}	
	}
	
	public void payTax(Player taxPayer) {
		System.out.println(taxPayer.getName() +" must pay £" +this.getTax() +" to " +this.getOwner().getName());
		taxPayer.updateBalanceSub(this.getTax());
		this.getOwner().updateBalanceAdd(this.getTax());
	}
	
	
	
	

}
