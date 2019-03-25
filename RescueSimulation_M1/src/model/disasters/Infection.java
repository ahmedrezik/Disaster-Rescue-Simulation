package model.disasters;

import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;

public class Infection extends Disaster {

	public Infection(int startCycle, Citizen target) {

		super(startCycle, target);

	}
	public void strike(){ 
		this.setActive(true);
		int x = ((Citizen)getTarget()).getToxicity();
		((Citizen)getTarget()).setToxicity(x+25);
		//((Citizen)getTarget()).struckBy(this);
		super.strike();
		
		}
public void cycleStep(){
		
		
		int z = ((Citizen)getTarget()).getToxicity();
		
		((Citizen)getTarget()).setToxicity(z+15);
	
	

	
		
}
}
