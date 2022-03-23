/*
 * Property of Mitchell Jonker
 */

public class ReversePolishCalculator {

	StackI<Integer> vStack = new LLStack<Integer>();
	
	public int calculate(String aPFN) {
		
		int ret = 0;
		if(aPFN.length() < 2) {
			System.out.println("\nExpression was not formatted properly.f");
			return 0;
		}
		for(int i = 0; i < aPFN.length(); i++) {
			boolean op = false;
			try { // Add value to stack if it is an integer
				if(intTest(aPFN.charAt(i))) {
					int val = Integer.parseInt(aPFN.charAt(i)+"");
					vStack.push(val);
				}
			}
			catch(Exception e) {
				// Exception
			}
			if(aPFN.charAt(i) == '+') { // If addition operator detected
				if(vStack.size() < 2) {
					System.out.println("\nExpression was not formatted properly.");
					return 0; // Return 0 if stack does not hold enough variables
				}
				op = true; // Operation occured
				int aVal = vStack.pop();
				int bVal = vStack.pop();
				ret = aVal + bVal;
			}
			else if(aPFN.charAt(i) == '-') {
				if(vStack.size() < 2) {
					System.out.println("\nExpression was not formatted properly.");
					return 0;
				}
				op = true;
				int aVal = vStack.pop();
				int bVal = vStack.pop();
				ret = bVal - aVal;
			}
			else if(aPFN.charAt(i) == '*') {
				if(vStack.size() < 2) {
					System.out.println("\nExpression was not formatted properly.");
					return 0;
				}
				op = true;
				int aVal = vStack.pop();
				int bVal = vStack.pop();
				ret = aVal * bVal;
			}
			else if(aPFN.charAt(i) == '/') {
				if(vStack.size() < 2) {
					System.out.println("\nExpression was not formatted properly.");
					return 0;
				}
				int aVal = vStack.pop();
				int bVal = vStack.pop();
				if(aVal == 0) {
					System.out.println("\nExpression was not formatted properly.\nAttempted Divide by Zero.");
					return 0;
				}
				else {
					ret = bVal / aVal;
					op = true;
				}
			}
			if(op) { // Iff operation took place, push calculated value to the stack.
				vStack.push(ret);
			}
			op = false;
		}
		int r = vStack.pop();
		if(vStack.size() >= 1) { // Insure proper format by stack-remainder check.
			System.out.println("\nExpression was not formatted properly.");
			return 0;
		}
		return r;
	}
	public boolean intTest(char aC) { // Returns true if the char is an integer.
		try {
			String str = aC+"";
			int val = Integer.parseInt(str);
			if(val >= 0 || val < 0) {
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}
}