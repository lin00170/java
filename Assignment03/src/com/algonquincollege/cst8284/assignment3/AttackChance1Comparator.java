/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Si LIN
 * Lab Section:314
 * Lab Professor:Leanne Seaward
 */




package com.algonquincollege.cst8284.assignment3;

import java.util.Comparator;



public class AttackChance1Comparator implements Comparator<CharacterRecord> {

	/**
	 * the method compare will compare the records
	 * @return int
	 */
	public int compare(CharacterRecord record1,CharacterRecord record2) {
		      
		      int a=record1.getAttackChance1();
		      int b=record2.getAttackChance1();
		     
       	   	  return b<a?-1:a==b?0:1;
       	   	  
	}
}
