package model.disasters;

import model.infrastructure.ResidentialBuilding;

public class GasLeak extends Disaster {

	public GasLeak(int startCycle, ResidentialBuilding target) {

		super(startCycle, target);

	}
	public void strike(){ 
		this.setActive(true);
		int x = ((ResidentialBuilding)getTarget()).getGasLevel();
		((ResidentialBuilding)getTarget()).setGasLevel(x+10);
		//((ResidentialBuilding)getTarget()).struckBy(this);
		super.strike();
		
		}
	public void cycleStep(){
		
		
		int z = ((ResidentialBuilding)getTarget()).getGasLevel();
		
		((ResidentialBuilding)getTarget()).setGasLevel(z+15);
	
	

	
		
}
}
