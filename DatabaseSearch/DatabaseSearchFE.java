/*
 * Property of Mitchell Jonker
 */

import java.util.*;
import java.io.*;

public class DatabaseSearchFE {

	public GeneralLinkedList<String> dataList;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		GeneralLinkedList<String> gameList = new GeneralLinkedList<String>();
		GeneralLinkedList<String> consList = new GeneralLinkedList<String>();
		GeneralLinkedList<String> output = new GeneralLinkedList<String>(); // System Output LL
		
		System.out.println("Welcome to Database Search!\n");
		
		boolean getFile = true;
		boolean load = false;
		boolean append = true;
		boolean running = true;
		
		while(running) {
		
			while(getFile) {
				
				getFile = false;
				System.out.println("Enter the name of the database file you wish to scan!\nWarning: files are case-sensitive and must be in the root folder.");
				
				String file = input.nextLine(); // Get database file name
				file.strip();
				
				try {
					Scanner database = new Scanner(new File("./"+file)); // attempt to construct file name
					load = true;
					
					while(database.hasNextLine()) { // While another line exists, store to data.
						String temp = database.nextLine();
						
						if(temp.contains("\t")) { // If format is not tabbed, do nothing.
							int pos = temp.indexOf("\t"); // Index of tab
							
							String game = temp.substring(0, pos);
							String console = temp.substring(pos+1, temp.length());
							game.strip();
							console.strip();
							
							// Parsed, parallel databases
							gameList.add(temp);
							consList.add(console);
						}
					}
				} 
				catch (FileNotFoundException e) {
					getFile = true;
					load = false;
					//e.printStackTrace();
					System.err.println("File not found. Please try again.");
				}
			}
			while(load) {
				//output.empty();
				System.out.println("\nEnter a search phrase or term.");
				System.out.println("Or enter \"???\" to print the most recent output to a file.");
				System.out.println("Or enter \"!!!\" to select a new database file.");
				
				String query = input.nextLine();
				System.out.println("--- --- --- ---\n");
				
				if(query.equalsIgnoreCase("!!!")) {
					gameList.empty();
					consList.empty();
					load = false;
					break;
				}
				while(gameList.hasMore() && consList.hasMore()) {
					String glued = gameList.getCurrent()+"\t"+consList.getCurrent();
					
					if(query.equalsIgnoreCase("???")) {
						
						System.out.println("Enter 1 to overwrite an file if it exists.");
						System.out.println("Enter 2 to append to a file if it exists.");
						
						String resp = input.nextLine();
						int respp = StringArbiter.toInteger(resp);
						
						if(respp == 1) {
							append = false;
						}
						else {
							append = true;
						}
						System.out.println("What is the name of the file you want to write to?");
						String name = input.nextLine();
						
						try {
							FileWriter writer = new FileWriter(name, append);
							
							while(output.hasMore()) {
								writer.write(output.getCurrent());
								writer.write("\n");
								output.gotoNext();
							}
							writer.close();
							output.empty();
							break;
							
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
					else if(query.contains("*")) {
						
						if(query.length() < 2) {
							System.out.println(glued);
							output.add(glued);
						}
						int wildcard = query.indexOf('*');
						String fh = query.substring(0, wildcard);
						String bh = query.substring(wildcard+1, query.length());
						
						// check for content surrounding the wild card.
						if((gameList.getCurrent().toLowerCase().contains(fh.toLowerCase()) && gameList.getCurrent().toLowerCase().contains(bh.toLowerCase()))
								|| (consList.getCurrent().toLowerCase().contains(fh.toLowerCase()) && consList.getCurrent().toLowerCase().contains(bh.toLowerCase()))) {
							
							// If the first half's index is less than the second half's index, print game & console.
							if(gameList.getCurrent().toLowerCase().indexOf(fh.toLowerCase()) < gameList.getCurrent().toLowerCase().indexOf(bh.toLowerCase()) 
									|| consList.getCurrent().toLowerCase().indexOf(fh.toLowerCase()) <= consList.getCurrent().toLowerCase().indexOf(bh.toLowerCase())) {
								System.out.println(glued);
								output.add(glued);
							}
						}
					}
					else if(gameList.getCurrent().toLowerCase().contains(query.toLowerCase()) || consList.getCurrent().toLowerCase().contains(query.toLowerCase())) { // Regular contains search
						System.out.println(glued);
						output.add(glued);
					}
					else if(!gameList.hasMore() && !consList.hasMore()) { // serach reached end of database file wihout result.
						System.out.println("Nothing in the database met your search query's entry.");
						break;
					}
					gameList.gotoNext();
					consList.gotoNext();
				}
				gameList.reset();
				consList.reset();
			}
			getFile = true;
		}
	}
}