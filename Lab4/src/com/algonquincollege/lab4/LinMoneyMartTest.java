
package com.algonquincollege.lab4;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinMoneyMartTest {

	private static final double EPSILON = 0;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test
	/**
	 * Test the method {giveChange}
	 */
	public void testgiveChange() {
		MoneyMart mart2 = new MoneyMart();
		   mart2.recordPurchase(2);
		   mart2.receivePayment(1,0,0,0,100);
		   double expected=0;
		   
		   Assert.assertEquals(expected, mart2.giveChange(),EPSILON);
		   
		
	}

	
	
}
