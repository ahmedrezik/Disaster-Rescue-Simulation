package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class Collapse extends Disaster {

	public Collapse(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	public void strike(){ 
		this.setActive(true);
		int x = ((ResidentialBuilding)getTarget()).getFoundationDamage();
		((ResidentialBuilding)getTarget()).setFoundationDamage(x+10);
		((ResidentialBuilding)getTarget()).struckBy(this);
		
		
		}
	public void cycleStep(){
		
		
			int z = ((ResidentialBuilding)getTarget()).getFoundationDamage();
			
			((ResidentialBuilding)getTarget()).setFoundationDamage(z+10);
		
		

		
			
	}
}
