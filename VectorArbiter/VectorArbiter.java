/*
 * Property of Mitchell Jonker
 */

import java.util.*;
public class VectorArbiter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean valid = false;
		int v1size = 1;
		int v2size = 1;
		
		System.out.println("Welcome to Vector Arbiter!\nEnter two vectors of compatible, equal size, to perform operations on them!\n");
		
		while(!valid) {
			System.out.println("Enter the size of the first vector.\n");
			v1size = input.nextInt();
			input.nextLine();
			System.out.println("Enter the size of the second vector.\n");
			v2size = input.nextInt();
			input.nextLine();
			
			int[] vector1 = VectorArbiter.createVector(v1size);
			int[] vector2 = VectorArbiter.createVector(v2size);
			
			if(vector1.length == vector2.length && vector1 != null && vector2 != null) {
				valid = true;
				
				System.out.println("Enter the values of the first vector:");
				vector1 = VectorArbiter.enterValues(vector1);
				System.out.println("Enter the values of the second vector:");
				vector2 = VectorArbiter.enterValues(vector2);
			}
			else {
				System.out.println("Vectors must be compatible, equal sizes.\n");
			}
			while(valid) {
				System.out.println("\nSelect from the following operations to perform on the two vectors.");
				System.out.println("Enter \"1\" to add the two vectors");
				System.out.println("Enter \"2\" to subtract the two vectors");
				System.out.println("Enter \"3\" to find the magnitude of one of the two vectors.");
				System.out.println("Enter \"4\" to enter a new pair of vectors.");
				System.out.println("Enter \"5\" to exit the program.");
				
				String comp = input.nextLine();
				int numb = StringArbiter.toInteger(comp);
				
				if(numb == 1) { // Add the vectors
					int[] resultant = VectorArbiter.addVectors(vector1, vector2);
				//	System.out.println("(A + B = R)");
					for(int i = 0; i < resultant.length; i++) {
						System.out.println("("+vector1[i]+" + "+vector2[i]+" = "+resultant[i]+")");
					}
					System.out.println();
				}
				if(numb == 2) { // Subtract the vectors
					int[] resultant = VectorArbiter.subVectors(vector1, vector2);
				//	System.out.println("(A - B = R)");
					for(int i = 0; i < resultant.length; i++) {
						System.out.println("("+vector1[i]+" - "+vector2[i]+" = "+resultant[i]+")");
					}
				}
				if(numb == 3) { // Find the magnitude
					double resultant = VectorArbiter.magnitudeVector(vector1, vector2);
					System.out.println("Vector's Magnitude:\n"+resultant);
				}
				if(numb == 4) {
					valid = false;
				}
				if(numb == 5) { // Terminate the program.
					System.out.println("Thank you for using Vector Arbiter.\n");
					System.exit(0);
				}
			}
		}
	}
	public static int[] addVectors(int[] a, int[] b) {
		System.out.println("Adding Vectors...\n");
		
		int[] c = new int[a.length];
		
		if(a.length == b.length) {
			for(int i = 0; i < c.length; i++) {
				c[i] = a[i] + b[i];
			}
			return c;
		}
		else {
			System.out.println("The two vectors are not compatible sizes.");
			return null;
		}
	}
	public static int[] subVectors(int[] a, int[] b) { 
		System.out.println("Subtracting Vectors...\n");
		
		int[] c = new int[a.length];
		
		if(a.length == b.length) {
			for(int i = 0; i < c.length; i++) {
				c[i] = a[i] - b[i];
			}
			return c;
		}
		else {
			System.out.println("The two vectors are not compatible sizes.");
			return null;
		}
	}
	public static double magnitudeVector(int[] a, int[] b) { //TODO create the insides of this magnitude calculator. Requires choice between choosing the magnitude of A or B.
		Scanner input = new Scanner(System.in);
		double temp = 0;
		
		System.out.println("Would you like to find the magnitude of:\nThe first or the second vector you entered?");
		System.out.println("Enter \"1\" to calculate the magnitude of the first vector.");
		System.out.println("Enter \"2\" to calculate the magnitude of the second vector.");
		
		String choice = input.nextLine();
		int d = StringArbiter.toInteger(choice);
		
		if(d == 1) { // Find mag. of vector a
			temp = 0;
			for(int i = 0; i < a.length; i++) {
				temp = temp + Math.pow(a[i],2);
			}
			temp = Math.sqrt(temp);
			return temp;
		}
		else if(d == 2) { // find mag. of vector b
			temp = 0;
			for(int i = 0; i < b.length; i++) {
				temp = temp + Math.pow(b[i],2);
			}
			temp = Math.sqrt(temp);
			return temp;
		}
		else if(d == -1) {
			System.out.println("Please enter a valid integer:\n\"1\" or \"2\" to complete their specific actions.");
			return 0.0;
		}
		else {
			System.out.println("Please enter a valid integer:\n\"1\" or \"2\" to complete their specific actions.");
			return 0.0;
		}
	}
	public static int[] enterValues(int[] a) {
		Scanner input = new Scanner(System.in);
		for(int j = 0; j < a.length; j++) {
			System.out.println("Enter the value for vector value position "+(j+1)+" out of "+a.length);
			int value = input.nextInt();
			a[j] = value;
		}
		return a;
	}
	public static int[] createVector(int a) {
		if(a >= 1) {
			int[] v = new int[a];
			return v;
		}
		else {
			System.out.println("Vector size must be greater than or equal to 1.\n"+a+" is not a valid value.");
			return null;
		}
	}
}