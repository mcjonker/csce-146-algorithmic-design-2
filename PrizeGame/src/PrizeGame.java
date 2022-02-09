/*
 * Property of Mitchell Jonker
 */

import java.io.*;
import java.util.*;

public class PrizeGame {
	
	public static int VARIANCE = 3;
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		String[] prizes = new String[5];
		int[] prices = new int[5];
		
		System.out.println("Welcome to the Showcase Prize Game!\n");
		
		boolean playing = true;
		
		while(playing) {
			
			// Select 5 random prizes.
			int val = rand.nextInt(VARIANCE);
			int counter = 0;
			try {
				Scanner prizetext = new Scanner(new File("./prizelist.txt")); // Initialize text scanner
				while(counter < 5) { // After 5 items have been selected, selection is complete. No item is selected twice per run.
					val = rand.nextInt(VARIANCE); 
					
					String item = prizetext.nextLine(); // Read line
				
					int pos = item.indexOf("\t"); // Index of tab
					
					// Parse line and store as respective type
					String name = item.substring(0, pos);
					String price = item.substring(pos+1, item.length());
					int cost = StringArbiter.toInteger(price);
					
					if(val == 1) {
						prizes[counter] = name;
						prices[counter] = cost;
						counter++;
					}
					pos = 0;
					val = 0;
					//System.err.println(counter);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			playing = false;
			
			// Calculate Total Value of Prizes
			int sum = 0;
			for(int j = 0; j < 5; j++) {
				sum = sum + prices[j];
			}
			// Lower Limit of the sum
			int llim = sum-(3500);
			
			// List Prizes
			System.out.println("Prizes are:");
			for(int i = 0; i < 5; i++) {
				System.out.println(prizes[i]);
			}
			System.out.println("\nWhat is the sum of the values of these prizes?");
			System.out.println("Enter a number to guess.");
			System.out.println("Correct answers are: the exact value of the sum of the prizes, or anything up to $3500 below the sum value.");
			System.out.println("Values greater than the sum are incorrect.");
			
			String g = input.nextLine();
			int gval = StringArbiter.toInteger(g);
			
			if(gval > sum || gval < llim) {
				System.out.println("You lost!\nYour guess: "+gval+" is incorrect.\nThe correct answer was: "+sum);
				System.out.println("Thanks for playing!\n");
			}
			else if(gval <= sum && gval >= llim) {
				System.out.println("Congrats! You guessed correctly!\nYour answer: "+gval+" Exact value: "+sum);
				
			}
			else {
				System.out.println("You lost!\nYour guess: "+gval+" is incorrect.\nThe correct answer was: "+sum);
				System.out.println("Thanks for playing!\n");
			}
			
			System.out.println("\nEnter 1 to play again.");
			System.out.println("Enter 2 to exit the game.");
			
			String a = input.nextLine();
			int ai = StringArbiter.toInteger(a);
			
			if(ai == 1) {
				playing = true;
			}
			if(ai == 2) { // Enter 2 to exit, or if the user enters anything else, the playing loop does not renew itself.
				System.out.println("Thanks for playing!\n");
			}
		}
	}
}
