
public class Process implements Comparable<Process>{

	private String id;
	private boolean active;
	private int arrivalTime;
	private int totalCpuTime;
	private int remCpuTime;
	private int turnAroundTime;
	
	public Process(String id, boolean active, int arrivalTime, int totalCpuTime) {
		this.id = id;
		this.totalCpuTime = totalCpuTime;
		this.remCpuTime = totalCpuTime;
		this.arrivalTime = arrivalTime;
	}
	
	public String getId() {
		return id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getTotalCpuTime() {
		return totalCpuTime;
	}
	
	public int getRemCpuTime() {
		return remCpuTime;
	}

	public void setRemCpuTime(int remCpuTime) {
		this.remCpuTime = remCpuTime;
	}

	
	public int getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	@Override
	public int compareTo(Process other) {
		if(this.isActive() && !other.isActive())
			return -1;
		if(!this.isActive() && other.isActive())
			return 1;
		if(this.getArrivalTime() < other.getArrivalTime())
			return -1;
		if(this.getArrivalTime() > other.getArrivalTime())
			return 1;
		return 0;
	}
	
}
