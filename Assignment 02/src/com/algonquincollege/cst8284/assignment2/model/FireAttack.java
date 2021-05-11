package com.algonquincollege.cst8284.assignment2.model;

/**
 * This class represents FireAttack extends from Attack
 * @see Attack
 * @author silin
 *
 */


public class FireAttack extends Attack {
	
	/**
	 * default constructor,chain to the next one.
	 */
	public FireAttack() {
		this(0);
	}
	
	/**
	 * This constructor sets the value specified into the damage
	 * field, no data validation is performed.
	 * @param damage the damage score for this attack
	 */
	public FireAttack(int damage) {
		super();
		setDamage(damage);
	}
	
	

}
