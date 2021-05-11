/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Si LIN
 * Lab Section:314
 * Lab Professor:Leanne Seaward
 */

// ToDo: Update the comment block at the top of the file.
package com.algonquincollege.cst8284.assignment3;

/**
 * This class launches the application.
 * @author piedas
 */
public class ProgramStartUp {
	/**
	 * The main method simply instantiates the CharacterRecordUtility
	 * and calls method processFile() to run the program.
	 * @param args Command Line Arguments are not used by this program.
	 */
	public static void main(String[] args) {
		new CharacterRecordUtility().processFile();
	}
}
