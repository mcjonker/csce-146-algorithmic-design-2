/*
 * Property of Mitchell Jonker
 */

public class Process {
	
	String name;
	double runtime;
	
	public Process() {
		this.name = "none";
		this.runtime = 0.0;
	}
	public Process(String aS, double aD) {
		this.setName(aS);
		this.setCompletionTime(aD);
	}
	// Accessors
	public String getName() {
		return this.name;
	}
	public double getCompletionTime() {
		return this.runtime;
	}
	// Mutators
	public void setName(String aN) {
		if(aN != null) {
			this.name = aN;
		}
		else {
			this.name = "none";
		}
	}
	public void setCompletionTime(double aT) {
		if(aT > 0.0) {
			this.runtime = aT;
		}
		else {
			this.runtime = 0.0;
		}
	}
	public String toString() {
		return "Process Name: "+name+" Completion Time: "+runtime;
	}
}
