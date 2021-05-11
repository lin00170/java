package com.algonquincollege.cst8414;
/**
* @author - various - updated by Si LIN
* @since  January 27th 2021
*<p>MyDateChoice class definition
*/

public class MyDateChoice {
   private static final String[] monthNames = {"January", "February", 
      "March", "April", "May", "June", "July", "August", 
      "September", "October", "November", "December"};
   private static final int[] monthDays = {31, 28, 31, 30, 31, 30, 
      31, 31, 30, 31, 30, 31};

   private int day; // day of the month
   private int month; // month in the year
   private int year; // year   
   private String monthName;//declare a String called monthName

   /**
   * Class default constructor
   */    
public MyDateChoice() {
	this(1,1,1989);
	
};
   
/**
 * Class constructor specifying month,day and year to create.
 * @param month user input
 * @param day  the day of the month from 1 to 31/30
 * @param year  year from 0 to Maximum
 */   
public MyDateChoice(int month,int day, int year) {
	this(day,year);
	this.month=month;
};

/**
 * Class overloaded constructor specifying monthName,day and year to create. 
 * @param monthName String monthName from January to December
 * @param day day of the month
 * @param year year from 0 to Maximum
 */ 
  
public MyDateChoice(String monthName,int day, int year) {
	this(day,year); 
	this.month=MyDateChoice.convertFromMonthName(monthName);
	
};

   
   /** 
     * This is the implementation of the THIRD CASE (SEE LAB SLIDES DESCRIPTION): constructor for the format: DDD YYYY.
     *@param ddd day number from 1 to 366
     *@param year year from 0 to Maximum
     */

   public MyDateChoice(int ddd, int year) {
      if (year < 0) { // validate year
         throw new IllegalArgumentException("year must be > 0");
      }

      if (ddd < 1 || ddd > 366) { // check for invalid day
         throw new IllegalArgumentException("day out of range");
      }

      this.year = year;

      int dayTotal = 0;

      for (int m = 1; 
         m < 13 && (dayTotal + daysInMonth(m, year)) < ddd; ++m) {
         dayTotal += daysInMonth(m, year);
         this.month = m + 1;
      } 

      this.day = ddd - dayTotal;
   }

    /**
    * Set the day
    * @param day user input
    */
   public void setDay(int day) {
      if (day < 1 || day > daysInMonth(month, year)) {
         throw new IllegalArgumentException("day out of range for current month");
      }

      this.day = day;
   }

    /**
    * Set the month
    * @param month user input
    */
   public void setMonth(int month) {
      if (month <= 0 || month > 12) { // validate month
         throw new IllegalArgumentException("month must be 1-12");
      }

      this.month = month;
   }

   
   /**
    * set the year
    * @param year the user input
    */
   public void setYear(int year) {
      if (year < 0) { // validate year
         throw new IllegalArgumentException("year must be > 0");
      }

      this.year = year;
   }

   /**
    * This method<code>toString()</code> always return the following format. 
    * @return Date in format: mm/dd/yyyy
    */
   
   public String toString() {
      return String.format("%d/%d/%d", month, day, year); 
   }

   // 
  /**
   * This method convert the input <code>monthName</code>to a integer number.
   * @return Date in format: MonthName dd, yyyy
   */
   public String toMonthNameDateString() {
      return String.format(
         "%s %d, %d", monthNames[month - 1], day, year);
   }

   /**
    * This method convert the entered day to a integer format of day of year.
    * @return Date in format DDD YYYY
    */
   public String toDayDateString() {
      return String.format("%d %d", convertToDayOfYear(), year);
   }

   /**
    * @param month the input by user
    * @param year  the input by user
    * @return Return the number of days in the month
    */
   private static int daysInMonth(int month, int year) {
      return leapYear(year) && month == 2 ? 29 : monthDays[month - 1];
   }

   /** 
    * test for a leap year
    * @param year the user input
    * @return a boolean to know how many days has a year
    */
   private static boolean leapYear(int year) {
      if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
         return true;
      }
      else {
         return false;
      }
   }

    /**
    * convert mm and dd to ddd
    * @return a integer number for the day of year
    */
   private int convertToDayOfYear() {
      int ddd = 0;

      for (int m = 1; m < month; ++m) {
         if (leapYear(year) && m == 2) {
            ddd += 29;
         }
         else  {
            ddd += monthDays[m -1];
         }
      } 

      ddd += day;
      return ddd;
   }

   
   /**
    * convert from month name to month number
    * @param monthName the user input
    * @return a integer number of month
    */
   private static int convertFromMonthName(String monthName) {
      for (int subscript = 0; subscript < 12; subscript++) {
         if (monthName.equals(monthNames[subscript])) {
            return subscript + 1;
         }
      }

      throw new IllegalArgumentException("Invalid month name");
   }
} 
