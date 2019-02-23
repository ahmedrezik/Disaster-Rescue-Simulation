package model.disasters;
import simulation.Rescuable;
public abstract class Disaster implements Rescuable{
//The class represents a disaster that could happen to a "Citizen" or to "Resedential Buidling"
	
	
	private int startCycle;
	private Rescuable target;
	private boolean active;
	
	public Disaster(int startCycle, Rescuable target) {
		this.startCycle = startCycle;
		this.target = target;
		this.active = false;
		
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getStartCycle() {
		return startCycle;
	}



	public Rescuable getTarget() {
		return target;
	}

	public boolean isActive() {
		return active;
	}
}
