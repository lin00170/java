package com.algonquincollege.cst8284.section314.simulation;


/**
 * @author various,silin
 * <p> section: 314, student number:041007321
 * This {Actor} class define the actor.
 */

public class Actor {
	/**
	 * declare private variables:icon and isMoved
	 */
	private char icon;
	private boolean isMoved;
	/**
	 * default constructor
	 */
	public Actor() {
		this('A');
	}
	/** 
	 * @param icon the ship or the anterior
	 */
	public Actor(char icon) {
		this.icon=icon;
	}
/**
 * GetIcon method
 * @return icon 
 */
	public char getIcon() {
		return icon;
	}
/**
 * setIcon method
 * @param icon the ship or the anterior
 */
	public void setIcon(char icon) {
		this.icon = icon;
	}
/**
 * isMoved method is a boolean
 * @return isMoved
 */
	public boolean isMoved() {
		return isMoved;
	}
/**
 * setMoved method
 * @param isMoved a boolean variable
 */
	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}
	
	
}
