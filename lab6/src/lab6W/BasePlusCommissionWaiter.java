package lab6W;


/** BasePlusCommissionWaiter.java
 * BasePlusCommissionWaiter class extends CommissionWaiter.
 * You do not need to modify this codes.
*/

public class BasePlusCommissionWaiter extends CommissionWaiter { 
private double baseSalary; // base salary per week
/**
 * constructor
 * @param firstName the first name of waiter
 * @param lastName  the last name of waiter
 * @param socialSecurityNumber the SIN of waiter
 * @param month   the month of birthday of waiter
 * @param day    the day of birthday of waiter
 * @param year   the year of birthday of waiter
 * @param grossSales the gross sales of waiter
 * @param commissionRate  the commission rate of waiter
 * @param baseSalary  the base salary
 */

public BasePlusCommissionWaiter(String firstName, String lastName, 
   String socialSecurityNumber, int month, int day, int year, 
   double grossSales, double commissionRate, double baseSalary) {
   super(firstName, lastName, socialSecurityNumber, 
      month, day, year, grossSales, commissionRate);

   if (baseSalary < 0.0) { // validate baseSalary                  
      throw new IllegalArgumentException("Base salary must be >= 0.0");
   }

   this.baseSalary = baseSalary;                
}

/**
 * method to set the base salary
 * @param baseSalary the base salary of waiter
 */

public void setBaseSalary(double baseSalary) {
   if (baseSalary < 0.0) { // validate baseSalary                  
      throw new IllegalArgumentException("Base salary must be >= 0.0");
   }

   this.baseSalary = baseSalary;                
} 
/**
 * method to get the base salary of waiter
 * @return the base salary of waiter
 */

public double getBaseSalary() {
   return baseSalary;
}

/**
 * method to calculate earnings;override method earnings in CommissionWaiter
 */

@Override                                                            
public double earnings() {                                             
   return getBaseSalary() + super.earnings();                        
} 

/**
 * @return String representation of BasePlusCommissionWaiter object
 */

@Override                                                           
public String toString() {                                            
   return String.format("%s %s; %s: $%,.2f",                       
      "base-salaried", super.toString(),                            
      "base salary", getBaseSalary());                             
} 
}

