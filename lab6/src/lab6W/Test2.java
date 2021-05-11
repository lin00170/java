package lab6W;

/**
 * This is the Waiter hierarchy Test2 program. 
 */

import java.util.Scanner; // This program uses Scanner to obtain user input. NOTE!!!!


public class Test2 {
public static void main(String[] args) {
  /** create subclass objects
   * add a head waiter
   */
   SalariedWaiter salariedWaiter = 
      new SalariedWaiter(
      "Blessing", "Obioma", "123-44-1234", 3, 15, 1945, 750.00);
   HourlyWaiter hourlyWaiter = 
      new HourlyWaiter(
      "Ife", "Oluwa", "123-55-5678", 6, 29, 1965, 16.75, 40);
   CommissionWaiter commissionWaiter = 
      new CommissionWaiter(
      "Andrew", "Peters", "123-66-9012", 9, 8, 1985, 30000, .06);
   BasePlusCommissionWaiter basePlusCommissionWaiter = 
      new BasePlusCommissionWaiter(
      "John", "Mercy", "123-77-3456", 12, 2, 2005, 7000, .04, 300);

   HeadWaiter headWaiter = 
		      new HeadWaiter(
		      "si", "lin", "467-88-3456", 7, 1, 2005,1.5,300);
   
   /**print out individually
    * 
    */
   System.out.println("Waiter processed individually:\n");
   
   System.out.printf("%s\n%s: $%,.2f\n\n", 
      salariedWaiter, "earned", salariedWaiter.earnings());
   System.out.printf("%s\n%s: $%,.2f\n\n",
      hourlyWaiter, "earned", hourlyWaiter.earnings());
   System.out.printf("%s\n%s: $%,.2f\n\n",
      commissionWaiter, "earned", commissionWaiter.earnings());
   System.out.printf("%s\n%s: $%,.2f\n\n", 
      basePlusCommissionWaiter, 
      "earned", basePlusCommissionWaiter.earnings());
   
   System.out.printf("%s\n%s: $%,.2f\n\n", 
		   headWaiter, 
		      "earned", headWaiter.earnings());

   /** 
    *   Create the elements Waiter array as required, then print out the values in the array
   */

	// START
   Waiter[] Waiters= new Waiter[] {salariedWaiter, hourlyWaiter,commissionWaiter,basePlusCommissionWaiter,headWaiter};
   
   System.out.println("Waiters of the array:");
   for(Waiter w:Waiters) {
	   System.out.printf("%s\n%s: $%,.2f\n\n", 
			      w, "earned", w.earnings());
	   }
	// END
   

   
   /** IMPLEMENT THE USE OF A SCANNER TO GET THE CURRENT MONTH. COMPLETE THIS PORTION */
   
	// START
   
   Scanner input=new Scanner(System.in);
   System.out.println("Please enter the current month(1-12):");
   int inputMonth= input.nextInt();
  
	// END   


   /** IN THIS SECTION OF CODE, YOU SHOULD GET AND VALIDATE THE CURRENT MONTH. */
  	// START
   
   while(inputMonth<1||inputMonth>12) {	 
	   System.out.println("Please enter the current month(1-12)");
	   inputMonth= input.nextInt();
   };
 	// END

   System.out.println("Waiters processed polymorphically:\n");
   
   
   /** Generically process each element in array Waiters */

   for (Waiter currentWaiter : Waiters) {
      System.out.println(currentWaiter); // invokes toString

      // determine whether element is a BasePlusCommissionWaiter
      if (currentWaiter instanceof BasePlusCommissionWaiter) {
         // downcast Waiter reference to 
         // BasePlusCommissionWaiter reference
         BasePlusCommissionWaiter Waiter = 
            (BasePlusCommissionWaiter) currentWaiter;

         double oldBaseSalary = Waiter.getBaseSalary();
         Waiter.setBaseSalary(1.10 * oldBaseSalary);
         System.out.printf(
            "new base salary with 15%% increase is: $%,.2f\n",
            Waiter.getBaseSalary());
      }

      /** COMPLETE THIS PORTION OF THE CODE.
       * If this is the month of a Waiter's birthday, then add the sum of $350 to salary
       *  and print out the current waiter's earning
       *  Otherwise, go ahead and print what the waiter has earned.
       */
      
     	// START
      final int birthBonus=350; 
      double earn=currentWaiter.earnings();
       if (currentWaiter.getBirthDate().getMonth()== inputMonth) {
       	earn+=birthBonus;
       }
       System.out.println( "earned:"+earn );
      
	// END

   }

   /** get type name of each object in Waiters array */

   for (int j = 0; j < Waiters.length; j++) {
      System.out.printf("Waiter %d is a %s\n", j, 
         Waiters[j].getClass().getName()); 
   }
}
}

