package model.disasters;
import model.infrastructure.ResidentialBuilding;
public class Fire extends Disaster {
public Fire (int cycle , ResidentialBuilding target){
	super(cycle,target);
}


public void strike(){ 
	this.setActive(true);
	int x = ((ResidentialBuilding)getTarget()).getGasLevel();
	((ResidentialBuilding)getTarget()).setGasLevel(x+10);
	
	
	
	}

public void cycleStep(){
		
		
		int z = ((ResidentialBuilding)getTarget()).getFireDamage();
		
		((ResidentialBuilding)getTarget()).setFireDamage(z+10);
	
	

	
		
}

}
