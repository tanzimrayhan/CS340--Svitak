import java.util.List;
import java.util.PriorityQueue;

public class FCFS implements Scheduler {

	private PriorityQueue<Process> queue;
	private Process currentProcess;
	
	public FCFS(List<Process> processes) {
		queue = new PriorityQueue<Process>(processes);
		currentProcess = queue.peek();
	}
	
	public Process next() {
		if(currentProcess.getRemCpuTime() > 0)
			return currentProcess;
		queue.remove();
		if(queue.isEmpty())
			return null;
		currentProcess = queue.peek();
		return currentProcess;
	}
	
}
