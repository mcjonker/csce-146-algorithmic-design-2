/*
 * Property of Mitchell Jonker
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TriangleFractal extends Canvas {

	public static void main(String[] args) {
		System.out.println("Sierpinski's Triangle");
		
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(900,900);
		TriangleFractal st = new TriangleFractal();
		frame.add(st);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void paint(Graphics aG) {
		
		int i = 0; // color
		int x [] = {0,(this.getSize().width)/2,this.getSize().width};
		int y [] = {this.getSize().width,0,this.getSize().width};
		
		drawTriangle(x,y,this.getSize().width,i,aG);
		
	}
	public void drawTriangle(int[] x, int[] y, int width, int color, Graphics aG) {
		
		int shiftX = width/2; // Relative Width parameter
		
		if(shiftX < 5) {
			return;
		}
		aG.setColor(Color.black);
		
		if(color > 0) {
			aG.setColor(Color.white);
		}
		aG.fillPolygon(x, y, 3);
		color++;
		
		if(shiftX >= 450) { // Center white triangle
		
			// Fill algorithm (left, middle, right)
			x[0] = shiftX/2; // 450 "half"
			y[0] = shiftX;
			x[1] = shiftX; 
			y[1] = shiftX*2;
			x[2] = 3*shiftX/2; 
			y[2] = shiftX;
			drawTriangle(x,y,shiftX,color,aG);
			
		}
		if(shiftX > 225 && shiftX < 451) { // Stage 2
			
			// Fill algorithm (left, middle, right)
			x[0] = 3*shiftX/2; // 225 "quarter"
			y[0] = shiftX;
			x[1] = 2*shiftX; 
			y[1] = 2*shiftX;
			x[2] = 5*shiftX/2; 
			y[2] = shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top
			
			x[0] = shiftX/2; // 225 "quarter"
			y[0] = 3*shiftX;
			x[1] = shiftX; 
			y[1] = 4*shiftX;
			x[2] = 3*shiftX/2; 
			y[2] = 3*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left
			
			x[0] = 5*shiftX/2; // 225 "quarter"
			y[0] = 3*shiftX;
			x[1] = 3*shiftX; 
			y[1] = 4*shiftX;
			x[2] = 7*shiftX/2; 
			y[2] = 3*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right
			
		}
		if(shiftX > 112 && shiftX < 226) { // Stage 3 (Reference, Position)
			
			// Fill algorithm (left, middle, right)
			x[0] = shiftX/2; // 112.5 "eighth"
			y[0] = 7*shiftX;
			x[1] = shiftX; 
			y[1] = 8*shiftX;
			x[2] = 3*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left: Bottom Left
			
			x[0] = 5*shiftX/2; // 112.5 "eighth"
			y[0] = 7*shiftX;
			x[1] = 3*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 7*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left: Bottom Right
			
			x[0] = 3*shiftX/2; // 112.5 "eighth"
			y[0] = 5*shiftX;
			x[1] = 2*shiftX; 
			y[1] = 6*shiftX;
			x[2] = 5*shiftX/2; 
			y[2] = 5*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left: Top
			
			x[0] = 11*shiftX/2; // 112.5 "eighth"
			y[0] = 5*shiftX;
			x[1] = 6*shiftX; 
			y[1] = 6*shiftX;
			x[2] = 13*shiftX/2; 
			y[2] = 5*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right: Top 
			
			x[0] = 9*shiftX/2; // 112.5 "eighth"
			y[0] = 7*shiftX;
			x[1] = 5*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 11*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); //Bottom Right: Bottom Left
						
			x[0] = 13*shiftX/2; // 112.5 "eighth"
			y[0] = 7*shiftX;
			x[1] = 7*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 15*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right: Bottom Right
						
			x[0] = 5*shiftX/2; // 112.5 "eighth"
			y[0] = 3*shiftX;
			x[1] = 3*shiftX; 
			y[1] = 4*shiftX;
			x[2] = 7*shiftX/2; 
			y[2] = 3*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top: Bottom Left
			
			x[0] = 9*shiftX/2; // 112.5 "eighth"
			y[0] = 3*shiftX;
			x[1] = 5*shiftX; 
			y[1] = 4*shiftX;
			x[2] = 11*shiftX/2; 
			y[2] = 3*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top: Bottom Right
			
			x[0] = 7*shiftX/2; // 112.5 "eighth"
			y[0] = shiftX;
			x[1] = 4*shiftX; 
			y[1] = 2*shiftX;
			x[2] = 9*shiftX/2; 
			y[2] = shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top: Top
			
		}
		if(shiftX > 55 && shiftX < 113) {
			
			// Fill algorithm (left, middle, right)
			x[0] = shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = shiftX; 
			y[1] = 16*shiftX;
			x[2] = 3*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left: Bottom Left
			
			x[0] = 5*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 3*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 7*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left: Bottom Right
			
			x[0] = 3*shiftX/2; // 56.25 "sixteenths"
			y[0] = 26*shiftX/2;
			x[1] = 2*shiftX; 
			y[1] = 14*shiftX;
			x[2] = 5*shiftX/2; 
			y[2] = 26*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left: Top
			
			x[0] = 9*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 5*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 11*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left-Middle: Bottom Left
			
			x[0] = 13*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 7*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 15*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left-Middle: Bottom Right
			
			x[0] = 19*shiftX/2; // 56.25 "sixteenths"
			y[0] = 26*shiftX/2;
			x[1] = 10*shiftX; 
			y[1] = 14*shiftX;
			x[2] = 21*shiftX/2; 
			y[2] = 26*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Left-Middle: Top
			
			x[0] = 17*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 9*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 19*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right-Middle: Bottom Left
			
			x[0] = 21*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 11*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 23*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right-Middle: Bottom Right
			
			x[0] = 11*shiftX/2; // 56.25 "sixteenths"
			y[0] = 26*shiftX/2;
			x[1] = 6*shiftX; 
			y[1] = 14*shiftX;
			x[2] = 13*shiftX/2; 
			y[2] = 26*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right-Middle: Top
			
			x[0] = 25*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 13*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 27*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right: Bottom Left
			
			x[0] = 29*shiftX/2; // 56.25 "sixteenths"
			y[0] = 30*shiftX/2;
			x[1] = 15*shiftX; 
			y[1] = 16*shiftX;
			x[2] = 31*shiftX/2; 
			y[2] = 30*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Bottom Right: Bottom Right
			
			x[0] = 27*shiftX/2; // 56.25 "sixteenths"
			y[0] = 26*shiftX/2;
			x[1] = 14*shiftX; 
			y[1] = 14*shiftX;
			x[2] = 29*shiftX/2; 
			y[2] = 26*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG);  // Bottom Right: Top
			
			x[0] = 5*shiftX/2; // 56.25 "sixteenths"
			y[0] = 22*shiftX/2;
			x[1] = 3*shiftX; 
			y[1] = 12*shiftX;
			x[2] = 7*shiftX/2; 
			y[2] = 22*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Left Lower Middle: Bottom Left
			
			x[0] = 9*shiftX/2; // 56.25 "sixteenths"
			y[0] = 22*shiftX/2;
			x[1] = 5*shiftX; 
			y[1] = 12*shiftX;
			x[2] = 11*shiftX/2; 
			y[2] = 22*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Left Lower Middle: Bottom Right
			
			x[0] = 7*shiftX/2; // 56.25 "sixteenths"
			y[0] = 9*shiftX;
			x[1] = 4*shiftX; 
			y[1] = 10*shiftX;
			x[2] = 9*shiftX/2; 
			y[2] = 9*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Left Lower Middle: Top
			
			x[0] = 21*shiftX/2; // 56.25 "sixteenths"
			y[0] = 22*shiftX/2;
			x[1] = 11*shiftX; 
			y[1] = 12*shiftX;
			x[2] = 23*shiftX/2; 
			y[2] = 22*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Right Lower Middle: Bottom Left
			
			x[0] = 25*shiftX/2; // 56.25 "sixteenths"
			y[0] = 22*shiftX/2;
			x[1] = 13*shiftX; 
			y[1] = 12*shiftX;
			x[2] = 27*shiftX/2; 
			y[2] = 22*shiftX/2;
			drawTriangle(x,y,shiftX,color,aG); // Right Lower Middle: Bottom Right
			
			x[0] = 23*shiftX/2; // 56.25 "sixteenths"
			y[0] = 9*shiftX;
			x[1] = 12*shiftX; 
			y[1] = 10*shiftX;
			x[2] = 25*shiftX/2; 
			y[2] = 9*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Right Lower Middle: Top
			
			x[0] = 9*shiftX/2; // 56.25 "sixteenths"
			y[0] = 7*shiftX;
			x[1] = 5*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 11*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Left Upper Middle: Bottom Left
			
			x[0] = 13*shiftX/2; // 56.25 "sixteenths"
			y[0] = 7*shiftX;
			x[1] = 7*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 15*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Left Upper Middle: Bottom Right
			
			x[0] = 11*shiftX/2; // 56.25 "sixteenths"
			y[0] = 5*shiftX;
			x[1] = 6*shiftX; 
			y[1] = 6*shiftX;
			x[2] = 13*shiftX/2; 
			y[2] = 5*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Left Upper Middle: Top
			
			x[0] = 17*shiftX/2; // 56.25 "sixteenths"
			y[0] = 7*shiftX;
			x[1] = 9*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 19*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Right Upper Middle: Bottom Left
			
			x[0] = 21*shiftX/2; // 56.25 "sixteenths"
			y[0] = 7*shiftX;
			x[1] = 11*shiftX; 
			y[1] = 8*shiftX;
			x[2] = 23*shiftX/2; 
			y[2] = 7*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Right Upper Middle: Bottom Right
			
			x[0] = 19*shiftX/2; // 56.25 "sixteenths"
			y[0] = 5*shiftX;
			x[1] = 10*shiftX; 
			y[1] = 6*shiftX;
			x[2] = 21*shiftX/2; 
			y[2] = 5*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Right Upper Middle: Top
			
			x[0] = 13*shiftX/2; // 56.25 "sixteenths"
			y[0] = 3*shiftX;
			x[1] = 7*shiftX; 
			y[1] = 4*shiftX;
			x[2] = 15*shiftX/2; 
			y[2] = 3*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top: Bottom Left
			
			x[0] = 17*shiftX/2; // 56.25 "sixteenths"
			y[0] = 3*shiftX;
			x[1] = 9*shiftX; 
			y[1] = 4*shiftX;
			x[2] = 19*shiftX/2; 
			y[2] = 3*shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top: Bottom Right
			
			x[0] = 15*shiftX/2; // 56.25 "sixteenths"
			y[0] = shiftX;
			x[1] = 8*shiftX; 
			y[1] = 2*shiftX;
			x[2] = 17*shiftX/2; 
			y[2] = shiftX;
			drawTriangle(x,y,shiftX,color,aG); // Top: Top
			
		}
	}
}