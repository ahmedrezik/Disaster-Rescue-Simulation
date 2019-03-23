package model.disasters;
import model.infrastructure.ResidentialBuilding;
public class Collapse extends Disaster {
public Collapse(int cycle,ResidentialBuilding target) {
	super(cycle,target);
}
public void strike(){ 
	this.setActive(true);
	int x = ((ResidentialBuilding)getTarget()).getFoundationDamage();
	((ResidentialBuilding)getTarget()).setFoundationDamage(x+10);
	
	
	
	}
public void cycleStep(){
	
	
		int z = ((ResidentialBuilding)getTarget()).getFoundationDamage();
		
		((ResidentialBuilding)getTarget()).setFoundationDamage(z+10);
	
	

	
		
}
}
