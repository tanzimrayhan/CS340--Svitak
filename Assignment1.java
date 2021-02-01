import java.util.List;

public class Assignment1 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int d = Integer.parseInt(args[2]);
		int v = Integer.parseInt(args[3]);

		Simulator sim = new Simulator(n, k, d, v);
		sim.createProcesses();
		List<Process> processes = sim.getProcesses();
		Scheduler scheduler = new FCFS(processes);
		sim.run(scheduler);
	}

}
