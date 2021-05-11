package com.algonquincollege.cst8284.assignment2.model;

public class PoisonAttack extends Attack{

	
	public PoisonAttack() {
		super();
	}
	
	/**
	 * This constructor sets the value specified into the damage
	 * field, no data validation is performed.
	 * @param damage the damage score for this attack
	 */
	public PoisonAttack(int damage) {
		super();
		setDamage(damage);
	}
	

}
