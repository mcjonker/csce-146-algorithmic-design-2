/*
 * Property of Mitchell Jonker
 */

public class ProcessScheduler {
	
	private Process current;
	private LLQueue<Process> processes;
	
	public ProcessScheduler() {
		
		processes = new LLQueue<Process>();
		//current = processes.dequeue();
	}
	
	public Process getCurrentProcess() {
		if(current != null) {
			return current;
		}
		else {
			return null;
		}
	}
	public void addProcess(Process aP) {
		if(aP == null) {
			return;
		}
		if(current == null) {
			current = aP;
		}
		processes.enqueue(aP);
	}
	public void runNextProcess() {
		current = processes.dequeue();
		//current = temp;
		
	}
	public void cancelCurrentProcess() {
		current = processes.peek();
		Process temp = processes.dequeue();
		runNextProcess();
		//runNextProcess();
	}
	public void printProcessQueue() {
		LLQueue<Process> temp = processes;
		if(temp != null) {
			temp.print();
			//temp.dequeue();
		}
	}
}