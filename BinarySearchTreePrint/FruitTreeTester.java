/*
 * Property of Mitchell Jonker
 */

import java.util.*;
import java.io.*;

public class FruitTreeTester {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		LinkedBST<Fruit> LBST = new LinkedBST<Fruit>();
		
		System.out.println("Welcome to Fruit Tree Tester");
		
		boolean getFile = true;
		boolean running = true;
		
		while(running) {
			
			while(getFile) {
				
				try {
					
					getFile = false;
					
					System.out.println("Enter the name of the fruit database you wish to use");
					
					String fileName = input.nextLine();
					
					Scanner dataScan = new Scanner(new File("./"+fileName));
					
					System.out.println("\nLoading fruits into the Binary Search Tree.");
					
					while(dataScan.hasNextLine()) { // Enter valid fruit entries into the database.
						
						String line = dataScan.nextLine();
						line.strip();
						
						if(line.contains("\t")) {
							
							int pos = line.indexOf("\t");
							
							String type = line.substring(0,pos);
							String weightS = line.substring(pos+1, line.length());
							
							double weight = StringArbiter.toDouble(weightS);
							
							Fruit aFruit = new Fruit(type,weight);
							
							LBST.add(aFruit);
						}
					}
				}
				catch(Exception e) {
					getFile = true; // Attempt to get file again.
					System.out.println("File not found. Try again");
					//System.out.println(e);
				}
			}
			
			// Print pre order
			System.out.println("\nPrinting Pre-order:");
			LBST.printPreorder();
			
			// print in order
			System.out.println("\nPrinting in-order:");
			LBST.printInorder();
			
			// print post order
			System.out.println("\nPrinting post-order:");
			LBST.printPostorder();
			
			// deleting a particular fruit 
			System.out.println("\nRemoving Banana with weight of 0.006167454282033358");
			Fruit removeF = new Fruit("Banana",0.006167454282033358);
			LBST.remove(removeF);
			
			// printing in order again 
			System.out.println("\nPrinting in-order:");
			LBST.printInorder();
			
			System.out.println("\nTerminating Program Demonstration");
			running = false;
		}
	}
}