package monopoly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUNIT testing of the square class
 * 
 * @author Michael Mc Ferran
 *
 */
class SquareTesting {

	// create test data
	String ID, IDInvalid, name, nameInvalid;

	@BeforeEach
	void setUp() throws Exception {

		// set test data
		ID = "Valid id";
		IDInvalid = "";
		name = "Valid name";
		nameInvalid = "";

	}

	/**
	 * Testing default constructor
	 */
	@Test
	void testDefaultConstructor() {
		Square square1 = new Square();
		assertNotNull(square1);
	}
	

	
	/**
	 * testing ID string with valid values
	 */
	@Test
	void testValidID() {
		Square square1 = new Square();
		square1.setID(ID);
		assertEquals(ID, square1.getID());
	}

	/**
	 * Testing ID string with invalid values
	 */
	@Test
	void testInvalidID() {
		Square square1 = new Square();
		assertThrows(IllegalArgumentException.class, () -> {
			square1.setID(IDInvalid);
		});

	}

	/**
	 * Testing Name string with valid values
	 */
	@Test
	void testValidName() {
		Square square1 = new Square();
		square1.setName(name);
		assertEquals(name, square1.getName());

	}

	/**
	 * Testing name string with invalid values
	 */
	@Test
	void testInvalidName() {
		Square square1 = new Square();
		assertThrows(IllegalArgumentException.class, () -> {
			square1.setName(nameInvalid);
		});

	}

}
