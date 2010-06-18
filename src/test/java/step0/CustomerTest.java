package step0;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import step0.Customer;
import step0.Movie;
import step0.Rental;

/**
 * Tests for the example in chapter 1 of "Refactoring" by Fowler.
 *  
 */
public class CustomerTest {

	private static final String TEST_CUSTOMER = "John Smith";
	private static final int ONE_DAY = 1;
	private static final int TWO_DAYS = 2;
	private static final int THREE_DAYS = 3;
	private static final int FOUR_DAYS = 4;

	@Test
	public void testStatementOneRegular() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "Die Hard", Movie.REGULAR, TWO_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for John Smith\n");
		expectedStatement.append("\tDie Hard\t2.0\n");
		expectedStatement.append("Amount owed is 2.0\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void testStatementOneRegularMoreThanTwoDays() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental;
		aRental = createRental(customer, "Die Hard", Movie.REGULAR, THREE_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for John Smith\n");
		expectedStatement.append("\tDie Hard\t3.5\n");
		expectedStatement.append("Amount owed is 3.5\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	
	@Test
	public void testStatementOneForChildren() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "Kung Fu Panda", Movie.CHILDRENS, TWO_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for John Smith\n");
		expectedStatement.append("\tKung Fu Panda\t1.5\n");
		expectedStatement.append("Amount owed is 1.5\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void testStatementOneForChildrenMoreThanThreeDays() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "Kung Fu Panda", Movie.CHILDRENS, FOUR_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for John Smith\n");
		expectedStatement.append("\tKung Fu Panda\t3.0\n");
		expectedStatement.append("Amount owed is 3.0\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void testStatementOneRentalNewRelease() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental = createRental(customer, "The Incident", Movie.NEW_RELEASE, TWO_DAYS);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for John Smith\n");
		expectedStatement.append("\tThe Incident\t6.0\n");
		expectedStatement.append("Amount owed is 6.0\n");
		expectedStatement.append("You earned 2 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	@Test
	public void testStatementNoRentals() {
		Customer customer = new Customer(TEST_CUSTOMER);
		String statementResult = customer.statement();
		assertEquals("Rental Record for John Smith\nAmount owed is 0.0\nYou earned 0 frequent renter points",statementResult);
	}

	@Test
	public void testStatementFourRentals() {
		Customer customer = new Customer(TEST_CUSTOMER);
		Rental aRental;
		aRental = createRental(customer, "Die Hard", Movie.REGULAR, TWO_DAYS);
		customer.addRental(aRental);
		aRental = createRental(customer, "The Incident", Movie.NEW_RELEASE, TWO_DAYS);
		customer.addRental(aRental);
		aRental = createRental(customer, "Kung Fu Panda", Movie.CHILDRENS, THREE_DAYS);
		customer.addRental(aRental);
		aRental = createRental(customer, "Star Wars", Movie.REGULAR, ONE_DAY);
		customer.addRental(aRental);
		String statementResult = customer.statement();
		StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for John Smith\n");
		expectedStatement.append("\tDie Hard\t2.0\n");
		expectedStatement.append("\tThe Incident\t6.0\n");
		expectedStatement.append("\tKung Fu Panda\t1.5\n");
		expectedStatement.append("\tStar Wars\t2.0\n");
		expectedStatement.append("Amount owed is 11.5\n");
		expectedStatement.append("You earned 5 frequent renter points");
		assertEquals(expectedStatement.toString(),statementResult);
	}

	private Rental createRental(Customer customer, String movieTitle, int moviePriceType, int rentalDays) {
		Movie aMovie = new Movie(movieTitle, moviePriceType);
		Rental aRental = new Rental(aMovie,rentalDays);
		return aRental;
	}
	
}
