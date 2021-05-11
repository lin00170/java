
package paying;
// LAB 7: PayableInterfaceTest.java
/**
 * <p>This program calculate all payments, either for waiters or for invoices.
 * @author linsi
 *
 */

// This code tests the interface Payable.
public class PayableInterfaceTest  {
public static void main(String[] args) {

// TO DO: IN THIS PORTION OF THE CODE, SEVERAL CHANGES SHOULD BE MADE:
// TO DO: CREATE SIX-ELEMENTS Payable array HERE */
/**
 * declare a array type Payable, named payableObjects, including 6 objects.
 */
//START CODE 
	Payable[] payableObjects = new Payable[6];
			

//END CODE
 
// TO DO: POULATE THE ARRAY YOU CREATED WITH OBJECTS THAT IMPLEMENT Payable
//CHECK THE OUTPUT FILE AND REUSE EXACTLY THE DETAILS PROVIDED SUCH AS FIRST NAME
// LAST NAME, SOCIAL INSURANCE NUMBER, ETC.
/**
 * populate the array according the constructors in every classes.
 */
		
 // START CODE
	payableObjects[0]= new Invoice(
		      "45343", "break", 3, 350.00);
	payableObjects[1]= new Invoice(
		      "85634", "pedal", 5, 60.99);
	
		    payableObjects[2]= new SalariedWaiter(
		      "Ada", "Chukwu", "345-67-8901", 610.00);
		    
			payableObjects[3] = new HourlyWaiter( "Blessing", "Obioma","234-56-7890",18.95, 40.00);
								 
		    payableObjects[4]= new CommissionWaiter(
		      "Peter", "John", "123-45-6789",27500, 0.44);
		    payableObjects[5] = new BasePlusCommissionWaiter(
		      "Itunu", "Ebere", "102-34-5678",2500, 0.04, 720);

// END CODE
/**
 * print out the description of objects and the results of calculations.
 */
 System.out.println(
    "Invoices and Waiters are processed polymorphically:\n"); 

 // generically process each element in array payableObjects
 for (Payable currentPayable : payableObjects) {
    // output currentPayable and its appropriate payment amount
    System.out.printf("%s \n", currentPayable.toString()); 
       
    if (currentPayable instanceof BasePlusCommissionWaiter) {
       // downcast Payable reference to 
       // BasePlusCommissionWaiter reference
       BasePlusCommissionWaiter waiter = 
          (BasePlusCommissionWaiter) currentPayable;

       double oldBaseSalary = waiter.getBaseSalary();
       waiter.setBaseSalary(1.10 * oldBaseSalary);
       System.out.printf(
          "new base salary with 10%% increase is: $%,.2f\n",
          waiter.getBaseSalary());
    } 

// TO DO: INSERT YOUR PRINT STATEMENT HERE: ENSURE THAT YOUR 
// OUTPUT FOLLOWS THE OUTPUT SAMPLE PROVIDED

// START CODE 
      
     System.out.println("Payment due:"+ String.format("%.2f", currentPayable.getPaymentAmount()));
     System.out.println();

    	 // generically process each element in array payableObjects
    	
    
    
    
// END CODE

    
 }
}
}


