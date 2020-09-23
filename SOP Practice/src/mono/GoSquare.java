package mono;

public class GoSquare extends Square {
	
	//Instance variables
	private int collection;
	
	//Constructors
	public GoSquare() {
		
	}
	
	public GoSquare(String ID, String name, int collection) {
		this.setID(ID);
		this.setName(name);
		this.setCollection(collection);
		
	}

	//Getters and settters
	/**
	 * @return the collection
	 */
	public int getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(int collection) {
		this.collection = collection;
	}
	
	

}
