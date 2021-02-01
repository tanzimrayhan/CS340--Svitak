import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {

	private List<Process> processes;
	private int n;
	private int k;
	private int d;
	private int v;
	private Random rand = new Random();

	public Simulator(int n, int k, int d, int v) {
		this.n = n;
		this.k = k;
		this.d = d;
		this.v = v;
	}

	public void createProcesses() {
		processes = new ArrayList<Process>();
		for (int i = 0; i < n; i++) {
			int arrivalTime = (int) (rand.nextDouble() * k);
			int totalCpuTime = (int) (rand.nextGaussian() * v + d);
			boolean active = (arrivalTime == 0) ? true : false;
			Process p = new Process("P" + i, active, arrivalTime, totalCpuTime);
			processes.add(p);
		}
	}

	public List<Process> getProcesses() {
		return processes;
	}

	public void run(Scheduler scheduler) {
		int time = 0;
		while (true) {
			time++;
			Process p = scheduler.next();
			if (p == null)
				break;
			p.setRemCpuTime(p.getRemCpuTime() - 1);
			if (p.getRemCpuTime() == 0) {
				p.setActive(false);
				p.setTurnAroundTime(time - p.getArrivalTime());
			}

		}
		printProcessTable();
		int totalTT = 0;
		for (Process p : processes) {
			totalTT += p.getTurnAroundTime();
		}
		double avgTT = totalTT / (double) n;
		System.out.println("Avg TurnAround Time (ATT): " + avgTT);
	}

	public void printProcessTable() {
		System.out.printf("%-10s%-10s%-15s%-15s%-15s%s\n", "Process", "Active", "Arrival-Time", "Total-CPU-Time",
				"Rem-CPU-Time", "Turnaround-Time");
		for (Process p : processes) {
			System.out.printf("%-10s%-10d%-15d%-15d%-15d%d\n", p.getId(), p.isActive() ? 1 : 0, p.getArrivalTime(),
					p.getTotalCpuTime(), p.getRemCpuTime(), p.getTurnAroundTime());
		}
	}

}
