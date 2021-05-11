/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Si LIN
 * Lab Section:314
 * Lab Professor:Leanne Seaward
 */
package com.algonquincollege.cst8284.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ToDo:
// - See the instructions in this file, above or in each of the methods.
//   Remove the not-yet-implemented throw statement.
// - Provide Javadoc comments for each method.
public class CharacterRecordUtility {

	private String columnNames = null; // used for storing the column names.

	// ToDo:
	// Create a List<T> records = new ArrayList<T>()
	// for storing Character Records, i.e. replace <T> with <CharacterRecord>
	// Note: List<String> is forbidden to be used!

	// No need for a constructor, let the compiler
	// provide the default-no-parameter constructor for this class.

	private List<CharacterRecord> records = new ArrayList<CharacterRecord>();
/**
 * show user the process of the application.
 */
	public void processFile() {
		// ToDo:
		// - use one try with multiple catch blocks to enclose the method body
		// - catch the checked exceptions, use a catch(Exception e) at the
		// bottom of the catch blocks.
		// - There is no reason to alter the starter code presented here

		// try here
		System.out.println("Attempting to open CharacterRecordsUnsorted.csv ...");
		loadFile();

		System.out.println("Sorting by name ...");
		sortName();

		System.out.println("Saving to SortedByName.csv ...");
		System.out.println("(Will overwrite any file with same name)");
		saveFile("SortedByName.csv");

		System.out.println("Sorting by attackChance1 ...");
		sortAttackChance1();

		System.out.println("Saving to SortedByAttackChance1.csv ...");
		System.out.println("(Will overwrite any file with same name)");
		saveFile("SortedByAttackChance1.csv");

		System.out.println("Character Data Sorted and Saved.");
		System.out.println("Program by Si LIN");
		// catches here
	}
/**
 * load the content of the provided file in the program, catch the exceptions.
 */
	private void loadFile() {
		// ToDo: - Open the provided CharacterRecordUnsorted.csv file
		//       - capture the first record as column names, do not use
		//         as part of the List of Character Records.
		//       - parse each line of text into an array, load the fields
		//         into a new CharacterRecord, place reference to
		//         the character record into the list. You will need to convert
		//         the attackChance fields from text into numbers when
		//         placing them into each CharacterRecord object.
		//       - Tip: The first thing you should do is actually empty the list
		//         in case this method is being called more than once. There
		//         may be a method of List that clears (clear()?) it of all items.
		//       - Catch any exceptions, ensure your file is closed in all cases
		//       - re-throw any caught exception so that the calling method
		//         is notified there was a problem.
		// - Place the csv file provided into the project folder itself,
		//   not the src folder. Eclipse will move the csv file where it is
		//   needed to run the program. (Outside of Eclipse when using only
		//   the file-name, the relative path used is the folder that the
		//   java.exe file was run in)
		// - Tip: You will need to add any CheckedExceptions to the method signature.
	
		try(BufferedReader  readerFile = new  BufferedReader(new FileReader("CharacterRecordsUnsorted.csv"))){
					 String line = "",cvsSplitBy=",";
                     int i=1;
			   while((line=readerFile.readLine())!=null) {
				   if(i==1) {
					   
					   this.columnNames=line;
						 //System.out.println( "FIRST:"+columnNames);
				   }
				   else{
					   String[] row = line.split(cvsSplitBy); 
					   CharacterRecord record=new CharacterRecord();
					for(int index=0;index<row.length;index++) {
				         switch(index){
				        	 case 0:
				        		 record.setName(row[index]);
				        		 break;
				        	 case 1:
				        		 record.setHealth(row[index]);
				        		 break;
				        	 case 2:
				        		 record.setStrength(row[index]);
				        		 break;
				        	 case 3:
				        		    record.setAttackDamage(row[index]);
				        		 break;
				        	 case 4:
				        	      record.setAttackChance1(Integer.parseInt(row[index]));
				        		 break;
				        	 case 5:
				    	         record.setAttackChance2(Integer.parseInt(row[index]));
				        		 break;
				        	 case 6:
						         record.setAttackType1(row[index]);
				        		 break;
				        	 case 7:
				                 record.setAttackType2(row[index]);
				        		 break;
				        	 case 8:
				        		  record.setDefense(row[index]);
				        		 break;					       
				         }
				        			    
					}  
					 records.add(record);
					 //System.out.println( this.records.get(i-2).toString());
				   }
				    
		            i++;
			   }
				//fileReader.close();
			}catch(FileNotFoundException e) {
				
				  System.out.println(e.getMessage());
			}catch(IllegalArgumentException e) {
				
				  System.out.println(e.getMessage());
				  
			} catch (IOException e) {
				
				 System.out.println(e.getMessage());
				 
			}
			
		//throw new UnsupportedOperationException(
				//"not implemented yet (DID YOU FORGET SOMETHING??"); // remove
	}
/**
 * sort the list using Collections.sort
 */
	private void sortName() {
		// ToDo: Sort the list using Collections.sort(list, Comparator<T>)
		// Create a class that implements comparator and overrides
		// method compare(<T>,<T>);
		
		Collections.sort(records,new NameComparator());
		
		
		 //throw new UnsupportedOperationException("not implemented yet (DID YOU FORGET SOMETHING??");
		 
		// remove
	}
/**
 * Sort the list using Collections.sort
 */
	private void sortAttackChance1() {
		// ToDo: Sort the list using Collections.sort(list, Comparator<T>)
		// Create a class that implements comparator and overrides
		// method compare(<T>,<T>);
		Collections.sort(records,new AttackChance1Comparator());
		//throw new UnsupportedOperationException("not implemented yet (DID YOU FORGET SOMETHING??"); // remove
	}
/**
 * output the records to a csv file
 * @param fileName
 */
	private void saveFile(String fileName) {
		// ToDo:
		// - Write out the records to a csv file using the fileName argument
		// - However, the first line written should be the column names
		// separated by commas.
		// - Overwrite the file if it already exists, this is the default behavior.
		// - Capture any exceptions, and re-throw them to caller.
		// - Ensure the file is closed down after writing is complete
		// - Tip1: Method toString() of class CharacterRecord was set up
		// for this assignment to produce a comma-separated-value
		// representation of the CharacterRecord, call toString() and
		// write the data out on separate lines (add a line terminator
		// character, either \n or better yet %n in a format-string.
		// - Tip2: The last write operation should be a line-terminator.
		// - Tip3: You will need to add any CheckExceptions to the method signature.
		   File writeFile= new File(fileName);
		   BufferedWriter writeText = null;
	    try {  	
	              writeText=new BufferedWriter(new FileWriter(writeFile));
	              writeText.write(this.columnNames);
	          for(int i=0;i<this.records.size();i++) {
	        	  writeText.newLine();
	    	      writeText.write(this.records.get(i).toString());
	       }
	    	 
	    }catch(FileNotFoundException e) {
	    	
	    	System.out.println(e.getMessage());
	    }catch(IOException e) {
	    	
	    	System.out.println(e.getMessage());
	    }finally {
	    	try {
				writeText.close();
			} catch (IOException e) {
			
				System.out.println(e.getMessage());
			}
	    }	
		//throw new UnsupportedOperationException("not implemented yet (DID YOU FORGET SOMETHING??");
		// remove
	}
}
