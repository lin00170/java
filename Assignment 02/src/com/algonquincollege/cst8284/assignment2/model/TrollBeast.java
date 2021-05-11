package com.algonquincollege.cst8284.assignment2.model;

import com.algonquincollege.cst8284.assignment2.util.DiceBag;
/**
 * This class represents TrollBeast extends from Character
 * @see Character
 * @author  silin
 *
 */



public class TrollBeast extends Character{
	
/**
 * default constructor, chain to the next one
 */
	public TrollBeast() {
			this(DiceBag.rollSixSidedDice() * 25,
				DiceBag.rollTwelveSidedDice() +20);
					
	}
	
	/**
	 * 
	 * @param maxHealth the maxHealth of the character
	 * @param strength  the strength of the character
	 */
	
	public TrollBeast(int maxHealth, int strength) {
		super(maxHealth,maxHealth,strength);
        
	}
	
	
	
	/**
	 * override the attack method
	 * @return  attack 
	 */
	
	
	
	@Override
	public Attack attack() {
	int myDamage = getStrength() + DiceBag.rollTwentySidedDice();
	Attack attack;
	if(DiceBag.rollOneHundredSidedDice()<=70) {
		attack= new BasicAttack(myDamage);
		
	}else { 
	  attack= new PoisonAttack(myDamage);
		
	}
	
	
	return attack;
	
	}
	/**
	 * override the defend method
	 * @return result 
	 */
	
	@Override
	public  AttackReport defend(Attack attack) {
		AttackReport result = null;
	    Boolean isFire=attack instanceof FireAttack;
	    result = new AttackReport();
		int damage = attack.getDamage();
		int h=this.getCurrentHealth();
		if(isFire) {
			
			this.setCurrentHealth(h -damage);
			result.setReport(getTypeClassName() + " Took full damage");
			result.setActualDamage(damage);
		}else {
		  int d=DiceBag.rollTwentySidedDice()+h;
		  int m=this.getMaxHealth();
		  int t=m-d>0?d:m;
			this.setCurrentHealth(t);
		}
		return result;
	}
	
	

}
