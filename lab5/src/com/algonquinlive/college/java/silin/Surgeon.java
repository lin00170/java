package com.algonquinlive.college.java.silin;

public class Surgeon extends Doctor {

	/**
	 * constructor
	 * @param name2 the name of surgeon
	 * @param salary2 the salary of surgeon
	 */
       public Surgeon(String name2, double salary2) {
		super(name2, salary2);
		
	}
       
       /**
   	 * override the toSting method.
   	 */

   	@Override 
   	public String toString() {
   		
   		System.out.print("Surgeon[name=" +  this.getName() + ",salary=" + this.getSalary() + "]");
   		 
   		 return null;	
   		 }
   }


	
