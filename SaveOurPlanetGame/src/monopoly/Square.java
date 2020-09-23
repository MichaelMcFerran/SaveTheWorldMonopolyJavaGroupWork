package monopoly;

/**
 * class is
 * 
 * @author EOIN - Michael added testing arguments
 *
 */
public class Square {

	// Instance variables
	private String ID;
	private String Name;

	// Getters and setters
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Default constructor used in sub classes PropertySquare and GoSquare
	 */
	public Square() {
		super();
	}

	/**
	 * Constructor with args added by Michael to correct the dead square in
	 * gameboard
	 * 
	 * @param iD
	 * @param name
	 */
	public Square(String iD, String name) {

		ID = iD;
		Name = name;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String ID) throws IllegalArgumentException {
		if (ID.length() > 0) {
			this.ID = ID;
		} else {
			throw new IllegalArgumentException(" no ID entered");
		}

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String Name) throws IllegalArgumentException {
		if (Name.length() > 0) {
			this.Name = Name;
		} else {
			throw new IllegalArgumentException(" no name entered");
		}

	}

}