package model.units;
import simulation.Address;
import model.infrastructure.*;
import simulation.Rescuable;
import simulation.Simulatable;
public class FireTruck extends FireUnit  {
public FireTruck(String id,Address location,int stepsPerCycle) {
	super(id,location,stepsPerCycle);
}
public void treat(){
	super.treat();
	if (((ResidentialBuilding)this.getTarget()).getFireDamage()==0 || ((ResidentialBuilding)this.getTarget()).getFireDamage() == 100)
	 this.jobsDone();
		else
	((ResidentialBuilding)this.getTarget()).setFireDamage(((ResidentialBuilding)this.getTarget()).getFireDamage()-10);

	 
	
}}
