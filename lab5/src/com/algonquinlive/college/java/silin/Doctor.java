package com.algonquinlive.college.java.silin;

public class Doctor extends HospitalPersonnel{
	
	private String ward;

	/**
	 * constructor
	 * @param name1 the name of surgeon
	 * @param salary1 the salary of surgeon
	 */

	public Doctor(String name1,double salary1 ) {
		super(name1,salary1);
		
	}
	
	/**
	 * override the toSting method.
	 */

	@Override 
	public String toString() {
		
		System.out.print("Doctor[name=" +  this.getName() + ",salary=" + this.getSalary() + "]");
		 
		 return null;	
		 }
}
