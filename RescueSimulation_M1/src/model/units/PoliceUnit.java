package model.units;
import model.people.*;
import java.util.ArrayList;

import simulation.Address;
import model.events.WorldListener;
import model.people.Citizen;
import model.infrastructure.*;
public abstract class PoliceUnit extends Unit {

	private ArrayList<Citizen> passengers;
	private int maxCapacity;
	private int distanceToBase;

	public PoliceUnit(String unitID, Address location, int stepsPerCycle,WorldListener w, int maxCapacity) {

		super(unitID, location, stepsPerCycle,w);
		passengers = new ArrayList<Citizen>();
		this.maxCapacity = maxCapacity;

	}

	public int getDistanceToBase() {
		return distanceToBase;
	}

	public void setDistanceToBase(int distanceToBase) {
		if(distanceToBase<=0){
			this.distanceToBase=0;
			  this.getWorldListener().assignAddress(this, 0,0);
			  while(!this.getPassengers().isEmpty()){
	    			this.getPassengers().get(0).getWorldListener().assignAddress(this.getPassengers().get(0), 0, 0);
	    			if(this.passengers.get(0).getState()!=CitizenState.DECEASED)
	    			this.passengers.get(0).setState(CitizenState.RESCUED);
	    			this.getPassengers().remove(0);}
		}
		else
		this.distanceToBase = distanceToBase;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	//public void cycleStep(){
		//if(passengers.size()==0){
			//super.cycleStep();
		//}else{
			//if(this.distanceToBase==0)
				//while(!this.passengers.isEmpty()){
					//this.passengers.get(0).getWorldListener().assignAddress(this.passengers.get(0), 0, 0);
					//if(this.passengers.get(0).getState()!=CitizenState.DECEASED)
					//this.passengers.get(0).setState(CitizenState.RESCUED);
					//this.passengers.remove(0);
				//}
			//this.setDistanceToBase(distanceToBase-this.getStepsPerCycle());
		//}
			//}
	


	public ArrayList<Citizen> getPassengers() {
		return passengers;
	}
}
