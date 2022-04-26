/* 
 * Property of Mitchell Jonker
 */

public class Fruit implements Comparable<Fruit> {

	String type;
	double weight;
	
	public Fruit() {
		
		type = "apple";
		weight = 1.0;
	}
	public Fruit(String aT, double aW) {
		
		type = aT;
		weight = aW;
	}
	public String getType() {
		
		return this.type;
	}
	public double getWeight() {
		
		return this.weight;
	}
	public void setType(String aT) {
		
		// Check for valid names
		if(aT.equalsIgnoreCase("orange")) {
			this.type = "orange";
		}
		if(aT.equalsIgnoreCase("banana")) {
			this.type = "banana";
		}
		if(aT.equalsIgnoreCase("kiwi")) {
			this.type = "kiwi";
		}
		if(aT.equalsIgnoreCase("tomato")) {
			this.type = "tomato";
		}
		else { // set default name
			this.type = "apple";
		}
	}
	public void setWeight(Double aW) {
		
		if(aW > 0.0) {
			this.weight = aW;
		}
		else {
			this.weight = 1.0;
		}
	}
	public String toString() {
		
		return "Type: "+this.type+" Weight: "+this.weight;
	}
	public int compareTo(Fruit aF) {
		
		if(aF == null) {
			return -1;
		}
		if(this.weight < aF.weight) {
			return -10;
		}
		if(this.weight > aF.weight) {
			return 10;
		}
		return this.type.compareTo(aF.type);
	}
}