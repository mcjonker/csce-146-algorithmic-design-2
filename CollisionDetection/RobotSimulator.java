/*
 * Property of Mitchell Jonker 
 */

import java.util.*;
import java.io.*;

public class RobotSimulator {

	// Initiate Standardized Characters and Commands
	public static char E_CHAR = '_';
	public static char OB_CHAR = 'X';
	public static String MU = "Move Up";
	public static String MD = "Move Down";
	public static String ML = "Move Left";
	public static String MR = "Move Right";
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Robot Command Simulator.");
		
		GenLLQueue<String> commands = new GenLLQueue<String>();
		
		// Init game board rows and columns
		// [Row][Value]
		String block[][] = new String[10][10]; 
		
		boolean running = true, getBoard = true, getComs = true, moving = true, crashed = false;
		
		while(running) {
			
			while(getBoard) {
				
				crashed = false;
				getBoard = false;
				
				System.out.println("Enter the name of the board file you wish to read.");
				
				String boardName = input.nextLine();
				boardName.strip();
				
				try {
					Scanner board = new Scanner(new File("./"+boardName));
					
					// Store values into multidimensional array
					for(int i = 0; i < 10; i++) {
						String tempLine = board.nextLine();
						
						if(tempLine.length() != 10) {
							System.out.println("Board file is not of the proper format. Game board must be 10x10.");
							break; 
						}
						for(int j = 0; j < 10; j++) {
							String tempChar = ""+tempLine.charAt(j);
							tempChar.strip();
							block[i][j] = tempChar;
						}
					}
				}
				catch (FileNotFoundException e) {
					getBoard = true; // Needs to loop through again to get a valid board file.
					System.err.println("File not found. Please try again.");
				}
			}
			while(getComs) {
				
				getComs = false;
				System.out.println("Enter the name of the commands file you wish to read.");
				
				String comsName = input.nextLine();
				comsName.strip();
				
				try {
					Scanner coms = new Scanner(new File("./"+comsName));
					while(coms.hasNextLine()) {
						String parseCommand = coms.nextLine();
						commands.enqueue(parseCommand);
					}
				}
				catch (FileNotFoundException e) {
					getComs = true;
					System.err.println("File not found. Please try again.");
				}
			}
			// Init game board
			int r = 0, v = 0; // Start at top left
			
			String[][] blockE = new String[10][10];
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					blockE[i][j] = block[i][j];
				}
			}
			
			blockE[r][v] = "R";
			
			String cmdInput = "";
			cmdInput.strip();
			
			boolean basePrinted = false;
			
			int log = 1;
			
			// Start robot at (0,0) (row, value) (Robot represented with R)
			while(moving) {
				
				boolean checker = false;
				
				if(commands.peek() != null) {
					cmdInput = commands.dequeue().strip();
				}
				else if(commands.peek() == null) {
					moving = false;
				}
				if(!basePrinted) {
					System.out.println("\nStarting Robot Position:");
					blockE[0][0] = "R";
					for(int i = 0; i < 10; i++) {
						if(i > 0) {
							System.out.println();
						}
						for(int j = 0; j < 10; j++) {
							System.out.print(blockE[i][j]);
						}
					}
					System.out.println();
					blockE[0][0] = block[0][0];
					basePrinted = true;
				}
				
				// Remove R from prev location
				blockE[r][v] = block[r][v];
				
				// Hold previous coordinates
				int prevr = r; 
				int prevv = v;
				
				// Update coordinates of robot
				if(cmdInput.equalsIgnoreCase(MU)) { // Move Up
					r--;
					checker = true;
				}
				else if(cmdInput.equalsIgnoreCase(MD)) { // Move Down
					r++;
					checker = true;
				}
				else if(cmdInput.equalsIgnoreCase(ML)) { // Move Left
					v--;
					checker = true;
				}
				else if(cmdInput.equalsIgnoreCase(MR)) { // Move Right
					v++;
					checker = true;
				}
				
				if(checker) {
					
					// Collision check here
					if(r > 9 || r < 0) {
						r = prevr;
						System.out.println("\nCRASH");
						crashed = true;
						moving = false;
						//break;
					}
					if(v > 9 || r < 0) {
						v = prevv;
						System.out.println("\nCRASH");
						crashed = true;
						moving = false;
						//break;
					}
					if(block[r][v].equalsIgnoreCase("X")) {
						System.out.println("\nCRASH");
						crashed = true;
						moving = false;
						//break;
					}
					if(commands.peek() == null) {
						moving = false;
					}
				
					// Insert R at new position
					blockE[r][v] = "R";
					
					// Print Board
					System.out.println("\nUpdated Robot Position:");
					System.out.println("log: "+log);
					for(int i = 0; i < 10; i++) {
						if(i > 0) {
							System.out.println();
						}
						for(int j = 0; j < 10; j++) {
							System.out.print(blockE[i][j]);
						}
					}
					System.out.println();
					
					log++;
					
					if(commands.peek() == null) {
						moving = false;
					}
				}
			}
			if(!crashed) { 
				System.out.println("\nTest Complete Successfully");
			}
			
			System.out.println("\nWould you like to restart the program?\nEnter 0 to restart and anything else to quit the program.");
			String action = input.nextLine();
			
			int act = StringArbiter.toInteger(action);
			
			if(act == 0) {
				System.out.println("Restarting...");
				getBoard = true;
				getComs = true;
				moving = true;
			}
			if(act == -1) {
				System.out.println("Thanks for using Robot Simulator.");
				running = false;
			}
		}
	}
}