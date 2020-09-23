package monopoly;

import monopoly.Square;

/**
 * 
 * This class is different from square as the GOsquare  gives resources and restarts/starts the loop of the gameboard index
 *
 */
public class GoSquare extends Square {
	
	//Instance variables
	private int collection;
	
	//Constructor default
	public GoSquare() {
		
	}
	
	/**
	 * Cosntructor with arguments
	 * @param ID
	 * @param name
	 * @param collection
	 */
	public GoSquare(String ID, String name, int collection) {
		this.setID(ID);
		this.setName(name);
		this.setCollection(collection);
		
	}

	//Getters and setters
	/**
	 * @return the collection
	 */
	public int getCollection() {
		return collection;
	}

	/**
	 * @param collection integer is being set
	 */
	public void setCollection(int collection) throws IllegalArgumentException {
		if (collection >= 0) {
			this.collection = collection;
		}else {
			throw new IllegalArgumentException("Collection amount must be more than zero");
		}
		
	}
	
	

}