/* 
 * Property of Mitchell Jonker
 */

public class StringArbiter {
	
	public static int toInteger(String aI) {
		
		Boolean isType = false;
		int out = 0;
		if(aI != null) {
			try { 
				out = Integer.parseInt(aI);
				isType = true;
			} catch (NumberFormatException e) {
				System.err.println(aI+" is not an Integer. Returning -1"); // Returns -1
				isType = false;
			}
		}
		if(isType) {
			return out;
		}
		else {
			//System.err.println(aI+" is not an Integer. Returning -1"); // Returns -1
			return -1;
		}
	}
	public static double toDouble(String aI) {
		Boolean isType = false;
		double out = 0;
		if(aI != null) {
			try { 
				out = Double.parseDouble(aI);
				isType = true;
			} catch (NumberFormatException e) {
				System.err.println(aI+" is not a Double. Returning -0.1"); // Returns -0.1
				isType = false;
			}
		}
		if(isType) {
			return out;
		}
		else {
			return -0.1;
		}
	}
	public static char toChar(String aI) {
		char out = 'a';
		if(aI.length() == 1) {
			out = aI.charAt(0);
			return out;
		}
		else {
			System.err.println(aI+" is not a Char. Returning '∆'"); // Returns ∆
			return '∆';
		}
	}
	// Default Format
	/* 
	public String toType(String aI) {
		// Content
	}
	*/
}
