package model.disasters;
import model.infrastructure.ResidentialBuilding;
public class GasLeak extends Disaster{
	public GasLeak(int cycle , ResidentialBuilding target){
		super(cycle, target);
	}
	public void strike(){ 
		this.setActive(true);
		int x = ((ResidentialBuilding)getTarget()).getFireDamage();
		((ResidentialBuilding)getTarget()).setFireDamage(x+10);
		
		
		
		}
	public void cycleStep(){
		
		
		int z = ((ResidentialBuilding)getTarget()).getGasLevel();
		
		((ResidentialBuilding)getTarget()).setGasLevel(z+10);
	
	

	
		
}


}
