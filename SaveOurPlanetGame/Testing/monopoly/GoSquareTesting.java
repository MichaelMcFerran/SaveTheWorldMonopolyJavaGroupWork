package monopoly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUNIT testing the GoSquare Class
 * @author Michael Mc Ferran
 *
 */
class GoSquareTesting {

	// create test data
	String ID, name, IDInvalid, nameInvalid;
	int collection, collectionInvalid;

	@BeforeEach
	void setUp() throws Exception {
		// initialise data
		ID = "valid ID";
		name = "valid name";
		IDInvalid = "";
		nameInvalid = "";
		collection = 50; // random amount
		collectionInvalid = 0;
	}

	/**
	 * Test default constructor
	 */
	@Test
	void testGoSquareDefaultConstructor() {
		GoSquare Go = new GoSquare();
		assertNotNull(Go);
	}

	/**
	 * Testing Constructor with arguments and valid values
	 */
	@Test
	void testGoSquareConstructorArguments() {
		GoSquare Go = new GoSquare(ID, name, collection);
		assertEquals(ID, Go.getID());
		assertEquals(name, Go.getName());
		assertEquals(collection, Go.getCollection());
	}

	/**
	 * Testing Constructor with arguments and invalid values
	 */
	@Test
	void testGoSquareConstructorArgumentsInvalid() {
		// invalid ID
		assertThrows(IllegalArgumentException.class, () -> {
			GoSquare Go = new GoSquare(IDInvalid, name, collection);
		});

		// invalid name
		assertThrows(IllegalArgumentException.class, () -> {
			GoSquare Go = new GoSquare(ID, nameInvalid, collection);
		});
		
		
	}

	/**
	 * Testing getting and setting collection int with valid values
	 */
	@Test
	void testValidCollection() {
		GoSquare Go = new GoSquare();
		Go.setCollection(collection);
		assertEquals(collection, Go.getCollection());
	}



}
