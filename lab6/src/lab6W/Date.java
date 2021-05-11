package lab6W;


/** Date
* This is the Date class declaration.
* It is required for the birthday computation for the Waiters.
* It is your responsibility to complete the designated portions of this code.
*/

public class Date {
private int month; // 1-12
private int day; // 1-31 based on month
private int year; // any year

private static final int[] daysPerMonth = 
   {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

// constructor: confirm proper value for month and day given the year
public Date(int month, int day, int year) {
   // check if month in range
   if (month <= 0 || month > 12) {
      throw new IllegalArgumentException(
         "month (" + month + ") must be 1-12");
   }

   // check if day in range for month
   if (day <= 0 || 
      (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
      throw new IllegalArgumentException("day (" + day + 
         ") out-of-range for the specified month and year");
   }

   // check for leap year if month is 2 and day is 29
   if (month == 2 && day == 29 && !(year % 400 == 0 || 
        (year % 4 == 0 && year % 100 != 0))) {
      throw new IllegalArgumentException("day (" + day +
         ") out-of-range for the specified month and year");
   }

   this.setMonth(month);
   this.setDay(day);
   this.setYear(year);

   System.out.printf(
      "Date object constructor for date %s%n", this.showDate());
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
} 

/** TO DO: YOU SHOULD COMPLETE THIS PORTION OF THE CODE add the necessary get methods */

	// START
	// END




/** TO DO: YOU SHOULD COMPLETE THIS PORTION OF THE CODE: write the code to return a String of the form month/day/year */


	// START

public String showDate() {

	String a="This day is"+ this.month+"/"+this.day+"/"+this.year;
	
	return a;
}
}

	// END
 


