
package com.algonquincollege.lab4;

import org.junit.Test;
import org.junit.Assert;
/**
* <p> This program will test the MoneyMart class.
* @author various SiLin

*/
public class MoneyMartTest
{
   private static final double EPSILON = 1E-12;
/**
 * test with the expected balance=0.25
 */
   @Test public void currencies()
   {
      MoneyMart mart = new MoneyMart();
      mart.recordPurchase(0.75);
      mart.recordPurchase(1.50);
      mart.receivePayment(2, 0, 5, 0, 0);
      double expected = 0.25;
      Assert.assertEquals(expected, mart.giveChange(), EPSILON);
   }
   
   /**
    * test with a expected balance=0
    */
   
   @Test public void testZeroBalance() {
	   MoneyMart mart2 = new MoneyMart();
	   mart2.recordPurchase(2);
	   mart2.receivePayment(1,0,0,0,100);
	   double expected=0;
	   
	   Assert.assertEquals(expected, mart2.giveChange(),EPSILON);
	   
   }

  //NEW TEST CASE REQUIRED HERE. FOLLOW INSTRUCTIONS BELOW.

   /**YOUR TASKS STARTS HERE: DO THE FOLLOWING:
    * YOUR TASK 1: Run the code files AS PROVIDED for you (JUnit Test) and show that THERE IS NO ERROR - IT MUST SHOW THE GREEN BAR.
    * YOUR TASK 2: During your demo to your professor, MODIFY the TEST CASE in this file named: currencies() by introducing an error in the test so that the test fails.
    * YOUR TASK 3: Demo the failed test to your professor (IT MUST SHOW THE RED BAR)
    * YOUR TASK 4: Modify this MoneyMartTest code file by adding just one NEW TEST CASE. Name your NEW TEST CASE: testZeroBalance.
    * Ensure that in your new test case, you have used an assertion.
    * YOUR TASK 5: Add Javadoc comments as necessary within this file.
    * YOUR TASK 6: Run your new test suite and demo this to your professor.
   */ 
}

