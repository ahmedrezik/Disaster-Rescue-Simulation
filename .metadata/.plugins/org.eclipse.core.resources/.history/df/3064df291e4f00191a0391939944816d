package model.units;

import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;

public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		super(unitID, location, stepsPerCycle,w);

	}
	public void treat(){
		super.treat();
		if ( ((Citizen)this.getTarget()).getBloodLoss() == 100)
		 this.jobsDone();
		else if(((Citizen)this.getTarget()).getBloodLoss()==0 ){
			((Citizen)this.getTarget()).setState(CitizenState.RESCUED);
			this.heal();}
		else
		((Citizen)this.getTarget()).setBloodLoss(((Citizen)this.getTarget()).getBloodLoss()-this.getTreatmentAmount());
		
	}

}
