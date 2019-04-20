package model.units;

import model.events.WorldListener;
import simulation.Address;
import model.people.*;
public class DiseaseControlUnit extends MedicalUnit {

	public DiseaseControlUnit(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		super(unitID, location, stepsPerCycle,w);

	}
	public void treat(){
		super.treat();
		if ( ((Citizen)this.getTarget()).getToxicity() == 100)
		 this.jobsDone();
		else if(((Citizen)this.getTarget()).getToxicity()==0 ){
			((Citizen)this.getTarget()).setState(CitizenState.RESCUED);
			this.heal();}
		else
		((Citizen)this.getTarget()).setToxicity(((Citizen)this.getTarget()).getToxicity()-this.getTreatmentAmount());
		
	}

}
