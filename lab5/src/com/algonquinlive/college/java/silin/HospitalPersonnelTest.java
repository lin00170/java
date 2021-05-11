package com.algonquinlive.college.java.silin;

/**
*<p>This program tests the HospitalPersonnel class and its subclasses.
* You are required to write your code and update this file. 
*Remember to provide the necessary Javadoc output for your documentations.
*Check the sample output to give you an idea of what to expect.
* The Doctor works at the Inpatients ward
* Use your name as the surgeon and assign any salary you wish to earn. 
* The Surgeon works at the Inpatients Theatre ward
* Use your friend's name as the doctor and give any salary you wish.
* Ensure that your output shows all necessary details based on the concepts applied in this lab 
*/

public class HospitalPersonnelTest {  

	public static void main(String[] args)
	{  
	
		/** 
		 * instantiate an object of the class Surgeon called me
		*/
	Surgeon me=new Surgeon("SiLIN",60000.00);
	
	me.toString();
	
	System.out.println();
	
	/** 
	 * instantiate an object of the class Surgeon called myFriend
	*/
	
	Doctor myFriend=new Doctor("YueYue",70000.00);
	myFriend.toString();
	
	
	}
	
}

