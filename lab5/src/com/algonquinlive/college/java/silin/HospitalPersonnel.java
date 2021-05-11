package com.algonquinlive.college.java.silin;


/**
* In a hospital there are many people who work to ensure good health outcomes.
* Hospital personnel are paid salaries and such personnel could belong to different wards.
* An example of a ward is the inpatients ward, and inside the ward you can have specialties like Inpatients Theatre, etc.
* @author linsi
*/

public class HospitalPersonnel
{  
private String name;
private double salary;



/**
  * the Construct with String and double parameters to allow us instantiate an HospitalPersonnel object.
  * @param n the name of the Hospital Personnel
  * @param s the salary of the Hospital Personnel
*/

public HospitalPersonnel(String n, double s)
{  
   name = n;
   salary = s;
}

/**
   Returns the string representation of the object.
   @return a string representation of the object
*/

public String toString()
{  
   return "HospitalPersonnel[name=" + name + ",salary=" + salary + "]";
}

/**
 * this method allows to get the name of the personnel
 * @return name name of the personnel
 */
public String getName() {
	return name;
	
}
/**
 * this method allows us to set a name
 * @param name the name of hospitalPersonnel
 */
public void setName(String name) {
	this.name= name;
	
}

/**
 * this method allows to get the salary
 * @return the salary of the personnel
 */
public double getSalary() {
	return salary;
	
	}
/**
 * this method allows to set a value to the salary
 * @param salary the salary of the personnel
 */
public void setSalary(double salary) {
	this.salary=salary;
	
}
}