package com.algonquincollege.cst8284.section314.simulation;

import java.util.Scanner;

/**
 * <p> This is a space simulator game. 
 * @author various,silin
 * <p> section: 314, student number:041007321
 */

public class SpaceExplorationSimulator {
	/**
	 * declare Max_Rows, Max_columns, Max_ships. Assign the start values.
	 */
	private final int MAX_ROWS;
	private final int MAX_COLUMNS;
	private final int MAX_SHIPS;
	private int shipsDestroyed = 0;
	private int shipsEscaped = 0;
	private int turnCount = 0;
	private Scanner input = new Scanner(System.in);
	/**
	 * instantiate the actors arrays.
	 */
	private Actor[][] actors;
	
	/**
	 * magic number become meaningful static fixed variables
	 */
	private static final int UP=0;
	private static final int DOWN=2;
	private static final int RIGHT=1;
	/**
	 * default class constructor, chained with the second one.
	 */
	public SpaceExplorationSimulator() { 
		this(5,20,5);
	}
    /**
     * class constructor with parameters.
     * @param MAX_ROWS  the maximum number of rows
     * @param MAX_COLUMNS the maximum number of columns
     * @param MAX_SHIPS  the maximum number of ships
     */
	public SpaceExplorationSimulator(int MAX_ROWS, int MAX_COLUMNS,int MAX_SHIPS){

		this.MAX_ROWS=MAX_ROWS;
		this.MAX_COLUMNS=MAX_COLUMNS;
		this.MAX_SHIPS=MAX_SHIPS;
		this.actors=new Actor[MAX_ROWS][MAX_COLUMNS];
				
	}
	/**
	 * start the game. ask user to input enter key to continue. if not, the program exits. This portion can not be changed.
	 */
	public void runSimulation() {
		
		turnCount = 0;
		boolean continueSimulation = true;
		
		System.out.println("Welcome to Space Simulation");
		System.out.println("Use enter key to run next turn");
		System.out.println("Typing anything other than return will end program");
		initializeArray();
		drawSpaceSimulation();
		
		do {
			addAsteroid();
			prepareActorsForMovement();
			moveActors();
			drawSpaceSimulation();
			turnCount++;
			System.out.println("Use enter key to run next turn");
			System.out.println("Typing anything other than return will end program");
			String userInput = input.nextLine();
						
			if(userInput.length() > 0) {
				continueSimulation = false;
			}
		
		}while(continueSimulation && ! isEndOfSimulation());
		
		System.out.println("Thanks for using the simulation");
	}

	/**
	 * initializeArray method is initialize an array. add an asteroid after every 10 turns.
	 */
	private void initializeArray() {
		
		for(int row = 0; row < actors.length; row++) {
			actors[row][0] = new Actor('S');
		}
		addAsteroid();
	}
  /**
   * AddAsteroid using Math.random to set 10% chance to add an asteroid to the play field.
   * If a ship encounters an asteroid, the ship will be destroyed. 
   * If an asteroid encounters another asteroid, both will be destroyed.
   */
	private void addAsteroid() {
		
		final int CHANCE = 10;
		int result = (int)(Math.random() * 100) + 1;
		if(result < CHANCE) {
			
			int row = (int)(Math.random() * 5);
			int col = actors[row].length - 1;
			if(actors[row][col] == null) {
				actors[row][col] = new Actor('A');
			}
			else if(actors[row][col].getIcon() == 'S') {
				actors[row][col] = new Actor('A');
				shipsDestroyed++;
			}
			else { 
				actors[row][col] = null;
			}
		}
	}
	/**
	 * This method contains a for loop over the 2D array. According the actions of actors, the ships or the asteroids will be destroyed.
	 * movement rules:
	 * Ships move up, right, down at random.
	 * Asteroids move left only.
	 * After each actor is moved, it is flagged so that it is not moved
	 * more than once per call of this method. Another method is used to 
	 * flag the actors as movable before this method is called again.
	 * Ship to Asteroid: Ship is destroyed (set element to null)
	 * Ship to Ship: The ship skips it's turn and does not move.
	 * Asteroid to Ship: Ship is removed, asteroid moves.
	 * Asteroid to Asteroid: Both asteroids are removed.
	 * Ships are not allowed to leave the top or bottom of the play area
	 * Ships that are destroyed should be counted.
	 * Ships that attempt to move past the right-most column are 
	 * considered safe and should be removed from the simulation, 
	 * i.e. mark their place in the 2D array as null, and counted as safe.
	 */
	private void moveActors() {
	
		for(int row = 0; row < actors.length; row++) {
			for(int col = 0; col < actors[row].length; col++) {
				
				if(actors[row][col] != null && ! actors[row][col].isMoved() ) {
					actors[row][col].setMoved(true);
					
					char item=actors[row][col].getIcon();
					actorGo(item,row,col);
				}
				}
			}
	}
   /**
    * This method defines the consequences of encounters.
    */
    private void actorGo(char actor,int row,int col) {
    	
		int newCol = col,newRow=row;
		
    	if(actor=='A') {
    		newCol--;
    	}else {
    		
    	int direction = (int) (Math.random()*3);
        switch(direction) { 
		
        case RIGHT:
        	newCol++;
            break;  
        case UP:
        	newRow--;
            break;
        case DOWN:	
        	newRow++;
        	break;
        }
    	}
    	
      	
    	if(! isMoveOffBoard(newRow, newCol)) {
    	  	
			if(actors[newRow][newCol] == null) {
				actors[newRow][newCol] = actors[row][col];
				actors[row][col] = null;
			}
			
			else if(actors[newRow][newCol].getIcon() !=actor ) {
			
				actors[newRow][newCol] = actor=='A'?actors[row][col]:null;
				
				actors[row][col] = null;
				shipsDestroyed++;
				
			}else {
			
				
				if( actor=='A')actors[newRow][newCol] = actors[row][col] = null;
				
			}
			}else {
			
				actors[row][col] = null;
				if(actor=='S')
					shipsEscaped++;

			}
             
    	}				
								
	/**
	 * this method allows users to start the game, and ask user to choose a vertical bar or not. print out the result.
	 * meanwhile, this will draw the appearance of the game			
	 */

	private void drawSpaceSimulation() {
		
		boolean isVertical=true;
		System.out.println("Want a vertical bar?(Yes=1;No=0)");
		
		Scanner input= new Scanner(System.in);
		
		isVertical=input.nextInt()==1?true:false;
		
		 String bar=isVertical?"|":" ";
	
		
		String rowText = "";
		for(Actor[] row: actors) {
			rowText +=bar;
			for(Actor actor: row) {
				if(actor == null) {
					rowText += " ";
				}
				else {
					rowText += actor.getIcon();
				}
				rowText +=bar;
			}
			rowText += "\n";
		}
		System.out.print(rowText);
		System.out.println("Ships destroyed: " + shipsDestroyed);
		System.out.println("Ships escaped: " + shipsEscaped);
		System.out.println("Turn number: " + turnCount);
		System.out.println("Simulation by:Si LIN");
	}
/**
 * this boolean method check the number of ships. If there is no more ship, the simulation game will end.
 * @return the boolean result
 */
	private boolean isEndOfSimulation() {
		
		boolean result = false;
		if(shipsDestroyed + shipsEscaped >= MAX_SHIPS) {
			result = true; 
		}
		return result;
	}
/**
 * This boolean method checks if a proposed move would be outside the bounds of the 2D array.
 * @param newRow new row
 * @param newCol new column
 * @return the boolean result
 */
	
	private boolean isMoveOffBoard(int newRow, int newCol) {
		boolean isOffBoard = true;
		if((newRow >= 0 && newRow < MAX_ROWS)&&(newCol >= 0 && newCol < MAX_COLUMNS)) {
			isOffBoard = false; 
		}
		return isOffBoard;
	}

	/**
	 *  This methods loops over the 2D array and re-activates all of the actors
	 *  so that when the moveActors() methods loops over the array each actor
	 *  will be moved at least once.
	 */
	
	private void prepareActorsForMovement() {
		for(int row = 0; row < actors.length; row++) {
			for(int col = 0; col < actors[row].length; col++) {
				if(actors[row][col] != null) {
					actors[row][col].setMoved(false);
				}
			}
		}
	}


}
