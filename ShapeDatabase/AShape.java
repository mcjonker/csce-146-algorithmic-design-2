/*
 * Property of Mitchell Jonker
 */

public class AShape implements Comparable<AShape> {
	
	String type;
	double area;
	
	public AShape() {
		
		type = "default";
		area = 0.0;
	}
	
	public AShape(String aT, double aA) {
		
		type = aT;
		area = aA;
	}
	
	public double getArea() {
		if(this.area != 0) {
			return this.area;
		}
		else return 0;
	}
	public String getType() {
		if(this.type != null) {
			return this.type;
		}
		else return null;
	}
	public void setType(String aT) {
		
		if(aT == null) {
			this.type = "Rectangle"; // Default name
		}
		else if(aT.equalsIgnoreCase("Circle")) {
			this.type = "Circle";
		}
		else if(aT.equalsIgnoreCase("Right Triangle")) {
			this.type = "Right Triangle";
		}
		else {
			this.type = "Rectangle";
		}
	}	
	public void setArea(double aA) {
		
		if(aA < 0) {
			this.area = 1.0;
		}
		this.area = aA;
	}
	public int compareTo(AShape aS) {
		
		if(aS == null) {
			return -1;
		}
		if(this.area < aS.area) {
			return -10;
		}
		if(this.area > aS.area) {
			return 10;
		}
		return this.type.compareTo(aS.type);
		
	}
	
	
}
