package model.units;

import java.util.ArrayList;

import simulation.Address;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;

public abstract class PoliceUnit extends Unit {

	private ArrayList<Citizen> passengers;
	private int maxCapacity;
	private int distanceToBase;

	public PoliceUnit(String unitID, Address location, int stepsPerCycle, int maxCapacity,WorldListener w) {

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
		    this.getWorldListener().assignAddress(this, this.getTarget().getLocation().getX(),this.getTarget().getLocation().getY());
		    for(int i=0;i<this.passengers.size();i++){
		    	this.passengers.get(i).setState(CitizenState.RESCUED);
		    }
		    if(this.getState()!=UnitState.IDLE)
		    		this.setState(UnitState.RESPONDING);
		    
		}
		this.distanceToBase = distanceToBase;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void cycleStep(){
		if(passengers.size()==0){
			super.cycleStep();
		}else{
			this.setDistanceToBase(distanceToBase-this.getStepsPerCycle());
		}
			}
	public void treat(){
		super.treat();
	    while(this.passengers.size()<this.maxCapacity && ((ResidentialBuilding)this.getTarget()).getOccupants().size()!=0){
	    	this.passengers.add(((ResidentialBuilding)this.getTarget()).getOccupants().get(0));
	    	((ResidentialBuilding)this.getTarget()).getOccupants().remove(0);
	    }
	    if(this.passengers.size()==0 && ((ResidentialBuilding)this.getTarget()).getOccupants().size()==0){
	    	this.jobsDone();
	    }
	}


	public ArrayList<Citizen> getPassengers() {
		return passengers;
	}
}
