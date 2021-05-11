package com.algonquincollege.cst8284.assignment2.model;

import com.algonquincollege.cst8284.assignment2.util.*;

/**
 * This class represents FireElemental extends from Character
 * @see Character
 * @author silin
 *
 */


public class FireElemental extends Character{

	/**
	 * default constructor, set the default values. chain to the next one.
	 */
	
	public FireElemental() {
		   this(
				   DiceBag.rollFourSidedDice() * 25,
				   DiceBag.rollSixSidedDice() + 10
				   );

   
					
	}
	//maxHealth,strength
	/**
	 * 
	 * @param maxHealth the maxHealth of the character
	 * @param strength the strength of the character
	 */
	public FireElemental(int maxHealth, int strength) {
		super(maxHealth,maxHealth,strength);
		
	}
	
	
	/**
	 * override the method attack() for fire attack
	 */
	
	
	@Override
	public Attack attack() {
	int myDamage = getStrength() + DiceBag.rollEightSidedDice();
	Attack attack;
	if(DiceBag.rollOneHundredSidedDice()<=50) {
		attack= new BasicAttack(myDamage);
		
	}else { 
	  attack= new FireAttack(myDamage);
		
	}
	
	
	return attack;
	
	}
	/**
	 * override the defend method
	 * @return result the result of the attack
	 */
	
	@Override
	public  AttackReport defend(Attack attack) {
		AttackReport result = null;
	    Boolean isPoison=attack instanceof PoisonAttack;
		if(attack != null && !isPoison) {
			result = new AttackReport();
			int damage = attack.getDamage();
			
			this.setCurrentHealth(this.getCurrentHealth() -damage);
			
			
			result.setReport(getTypeClassName() + " Took full damage");
			result.setActualDamage(damage);
		}
		return result;
	}
	
	
	
}
