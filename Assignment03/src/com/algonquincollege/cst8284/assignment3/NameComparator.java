/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Si LIN
 * Lab Section:314
 * Lab Professor:Leanne Seaward
 */




package com.algonquincollege.cst8284.assignment3;

import java.util.Comparator;

/**
 * This class implements the interface Comparator, to sort the name.
 * @author Si LIN
 */

public class NameComparator implements Comparator<CharacterRecord>{
	
	public int compare(CharacterRecord record1,CharacterRecord record2) {
		
		/*
		 * int a=(int)record1.getName().charAt(0); int
		 * b=(int)record2.getName().charAt(0);
		 */
		      String a=record1.getName(),b=record2.getName();
		    
		      return b.compareTo(a);
    	   	 
	}
}

