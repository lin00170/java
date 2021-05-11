package com.algonquincollege.cst8284.assignment2.model;

public class BasicAttack extends Attack {
	/**
	 * default constructor,chain to the next one.
	 */
	
	public BasicAttack() {
	 this(0);
	}
	
	/**
	 * This constructor sets the value specified into the damage
	 * field, no data validation is performed.
	 * @param damage the damage score for this attack
	 */
	public BasicAttack(int damage) {
		super();
		setDamage(damage);
	}
	
	

}
