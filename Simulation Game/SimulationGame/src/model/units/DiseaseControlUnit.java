package model.units;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
public class DiseaseControlUnit extends MedicalUnit{
public DiseaseControlUnit (String id , Address location , int stepsPerCycle){
	super(id,location,stepsPerCycle);
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
