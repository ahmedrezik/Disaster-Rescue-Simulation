package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;

public class FireTruck extends FireUnit {

	public FireTruck(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		super(unitID, location, stepsPerCycle,w);

	}
	public void treat(){
		super.treat();	
		((ResidentialBuilding)this.getTarget()).setFireDamage(((ResidentialBuilding)this.getTarget()).getFireDamage()-10);
		if (((ResidentialBuilding)this.getTarget()).getFireDamage()==0 || ((ResidentialBuilding)this.getTarget()).getFireDamage() == 100)
			 this.jobsDone();
				
			 
		
	}
}
