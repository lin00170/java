package lab6W;

/**
 * This class represents a HeadWaiter
 * @see Waiter
 * @author silin
 */
public class HeadWaiter extends Waiter {
	
	/**
	 * wage which stores the wage of the waiter per piece of sandwich.
	 * pieces,which stores of the number of pieces of sandwiches made.
	 */
	private double wage; 
	
	private double pieces;
	
	/**
	 * constructor
	 * @param firstName the first name of head waiter
	 * @param lastName  the last name of head waiter
	 * @param socialSecurityNumber  the SIN of head waiter
	 * @param month
	 * @param day
	 * @param year
	 * @param wage the wage of the head waiter
	 * @param pieces the pieces made by the head waiter
	 */
	
	public HeadWaiter(String firstName, String lastName, String socialSecurityNumber, 
			int month, int day, int year,double wage,double pieces) {
		super(firstName, lastName, socialSecurityNumber, month, day, year);
		
		this.wage=wage;
		this.pieces=pieces;
	}
/**
 * the method earnings
 */
	@Override
	public double earnings() {
	return wage*pieces;
	}
	/**
	 * get wage
	 * @return wage
	 */
	public double getWage() {
		return wage;
	}
/**
 *  set Wage
 * @param wage the wage for the headwaiter
 */
	public void setWage(double wage)
	{ 
		this.wage = wage;
	}
/**
 * get Pieces	
 * @return the pieces of sandwiches made by head waiter
 */
	public double getPieces() {
		return pieces;
	}
/**
 * set pieces of sandwiches
 * @param pieces
 */
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	
}
