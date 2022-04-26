/*
 * Property of Mitchell Jonker
 */

import java.util.*;
import java.io.*;

public class ShapeDatabase {
	
	public static void main(String[] args) {
		
		BST<AShape> database = new BST<AShape>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Shape Database!\n");
		
		// Required Action Loop Booleans
		boolean running = true;
		boolean getAction = true;
		
		// Individual Actions Loop Booleans
		boolean readFile = false;
		boolean enterShape = false;
		boolean writeToFile = false;
		boolean removeShape = false;
		boolean searchShape = false;
		boolean findLargest = false;
		boolean removeGreaterThan = false;
		boolean printOut = false;
		
		while(running) {
			
			while(getAction) {
				
				getAction = false;
				
				System.out.println("\nEnter \"1\" to read from shape database file,");
				System.out.println("Enter \"2\" to enter a shape,");
				System.out.println("Enter \"3\" to write to a shape database file,");
				System.out.println("Enter \"4\" to remove a shape,");
				System.out.println("Enter \"5\" to search for a shape,");
				System.out.println("Enter \"6\" to find the largest shape by area,");
				System.out.println("Enter \"7\" to remove all shapes greater than a certain area,");
				System.out.println("Enter \"8\" to print the database to the console");
				System.out.println("Enter anything else to quit the program.\n");
				
				String actionS = input.nextLine();
				
				if(StringArbiter.toInteger(actionS) == 1) { // Read from a Database
					readFile = true;
				}
				if(StringArbiter.toInteger(actionS) == 2) { // Enter a Shape
					enterShape = true;
				}
				if(StringArbiter.toInteger(actionS) == 3) { // Write to a Database
					writeToFile = true;
				}
				if(StringArbiter.toInteger(actionS) == 4) { // Remove a Shape
					removeShape = true;
				}
				if(StringArbiter.toInteger(actionS) == 5) { // Search for a Shape
					searchShape = true;
				}
				if(StringArbiter.toInteger(actionS) == 6) { // Find Largest Shape by Area
					findLargest = true;
				}
				if(StringArbiter.toInteger(actionS) == 7) { // Remove All Shapes Greater Than a Certain Area
					removeGreaterThan = true;
				}
				if(StringArbiter.toInteger(actionS) == -1) { // Try again
					getAction = true;
				}
			}
			while(readFile) { // Database Entry
				
				readFile = false;
				
				System.out.println("Enter the name of the shape database file");
				
				String databaseName = input.nextLine();
				
				try {
					
					Scanner dataScan = new Scanner(new File("./"+databaseName));
					
					while(dataScan.hasNextLine()) { // Enter valid shape entries into the database.
					
						String line = dataScan.nextLine();
						line.strip();
					
						if(line.contains("\t")) {
							
							int pos = line.indexOf("\t");
							
							String type = line.substring(0,pos);
							String areaAS = line.substring(pos+1, line.length()); // Contains data values
							
							if(areaAS.contains("\t")) {
								
								String areaAR = areaAS.substring(0,pos);
								String areaBR = areaAS.substring(pos+1, areaAS.length());
								
								double val1 = StringArbiter.toDouble(areaAR);
								double val2 = StringArbiter.toDouble(areaBR);
								
								AShape temp = new AShape(type,0.0);
								
								AShape aShape = setArea(temp,val1,val2);
								
								database.add(aShape);
							}
						}
					}
				}
				catch(Exception e) {
					readFile = true;
					System.out.println("File not found. Try again.");
				}
				
			}
			while(enterShape) { // Manual Entry
				
				System.out.println("Enter the type of shape");
				String addType = input.nextLine();
				
				AShape addShape = new AShape(addType,1.0);
				
				if(addShape.type.contains("Rectangle")) {
					
					enterShape = false;
					
					System.out.println("Enter the first dimension");
					double d1 = input.nextDouble();
					System.out.println("Enter the second dimension");
					double d2 = input.nextDouble();
					addShape = setArea(addShape, d1, d2);
					
					database.add(addShape);
					System.out.println("Shape added.");
				}
				else if(addShape.type.contains("Right Triangle")) {
					
					enterShape = false;
					
					System.out.println("Enter the first dimension");
					double d1 = input.nextDouble();
					System.out.println("Enter the second dimension");
					double d2 = input.nextDouble();
					addShape = setArea(addShape, d1, d2);
					
					database.add(addShape);
					System.out.println("Shape added.");
				}
				else if(addShape.type.contains("Circle")) {
					
					enterShape = false;
					
					System.out.println("Enter the radius");
					double d1 = input.nextDouble();
					double d2 = 0;
					addShape = setArea(addShape, d1, d2);
					
					database.add(addShape);
					System.out.println("Shape added.");
				}
				else {
					System.out.println("\nTry entering a valid shape type.\n");
				}
			}
			while(writeToFile) { // Output to File
				
				try {
					
					writeToFile = false;
					
					System.out.println("Enter the name of the file to write to.");
					String fileName = input.nextLine();
					String filePath = "./"+fileName;
					
					File outputFile = new File(fileName);
					
					PrintStream termx = System.out;
					PrintStream output = new PrintStream(outputFile); // create file writer
					System.setOut(output);
					
					database.printInorder();
					
					System.setOut(termx); // set output back to terminal
					System.out.println("Database written to file");
					
				}
				catch(Exception e) {
					System.out.println("Exception: "+e+" occured. Try again.\n");
					writeToFile = true;
				}
			}
			while(removeShape) { // Remove Shape
				
				System.out.println();
			}
			while(searchShape) { // Search for Shape
				
				System.out.println("Enter \"1\" to search by type.");
				System.out.println("Enter \"2\" to search by area.");
				
				String searchParam = input.nextLine();
				
				if(StringArbiter.toInteger(searchParam) == 1) {
					System.out.println("Enter the type of shape you wish to search for.");
					String typeSearch = input.nextLine();
					AShape search = new AShape(typeSearch,0.0);
					database.search(search);
				}
				if(StringArbiter.toInteger(searchParam) == 2) {
					System.out.println("Enter the area of shape you wish to search for.");
					double areaSearch = input.nextDouble();
					AShape search = new AShape(null,areaSearch);
					database.search(search);
				}
			}
			while(findLargest) { // Find Largest in BST
				System.out.println("Largest shape in the database is:");
				
				AShape maxAreaShape = database.findMaxInTree();
				System.out.println(maxAreaShape.toString()+"\n");
				
			}
			while(removeGreaterThan) { // Remove Greater than Inputted Area
				
				System.out.println("Enter the area to filter by. All shapes with larger areas will be removed.");
				
				double filter = input.nextDouble();
				boolean removing = true;
				
				while(removing) {
					AShape remove = database.findMaxInTree();
					
					if(remove.area > filter) {
						System.out.println("Removing: "+remove.toString());
						database.remove(remove);
					}
					else {
						removing = false;
						System.out.println("Removing process complete.");
					}
				}
			}
			while(printOut) {
				
				printOut = false;
				
				System.out.println("Enter \"1\" to print in Pre-Order Transversal format.");
				System.out.println("Enter \"2\" to print in In-Order Transversal format.");
				System.out.println("Enter \"3\" to print in Post-Order Transversal format.");
				//System.out.println("Enter anything else to skip the printing process.");
				
				String pForm = input.nextLine();
				
				if(StringArbiter.toInteger(pForm) == 1) {
					database.printPreorder();
				}
				if(StringArbiter.toInteger(pForm) == 2) {
					database.printInorder();
				}
				if(StringArbiter.toInteger(pForm) == 3) {
					database.printPostorder();
				}
				else {
					printOut = true;
				}
				
			}
			readFile = false;
			enterShape = false;
			writeToFile = false;
			removeShape = false;
			searchShape = false;
			findLargest = false;
			removeGreaterThan = false;
			printOut = false;
		}
	}
	private static AShape setArea(AShape aS, double a, double b) { // takes in named but un-area'd Shape.
		
		if(a != 0 && b != 0) { // Triangle?
			if(aS.type.contains("Triangle")) {
				aS.area = a*b/2;
				return aS;
			}
		}
		else if(a != 0 && b != 0) { // Rectangle?
			if(aS.type.contains("Right Triangle")) {
				aS.area = a*b;
				return aS;
			}
		}
		else if(a != 0 && b == 0) { // Circle?
			if(aS.type.contains("Circle")) {
				aS.area = a*a*Math.PI;
				return aS;
			}
		}
		else {
			aS.area = 0;
		}
		return aS;
	}
}