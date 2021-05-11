package com.algonquincollege.cst8284.section314.simulation;

/**
 * @author various,silin
 * <p> section: 314, student number:041007321
 * this {SpaceProgram} class have the main method that instantiate the SpaceExplorationSimulator and call the {sunSimulation} method.
 */

public class SpaceProgram {

	public static void main(String[] args) {
		
		SpaceExplorationSimulator simulator = new SpaceExplorationSimulator();
		simulator.runSimulation();
	}

}
