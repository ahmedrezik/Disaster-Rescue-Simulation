package model.units;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;
public class GasControlUnit extends FireUnit {
public GasControlUnit(String id,Address location,int stepsPerCycle) {
	super(id,location,stepsPerCycle);
}
public void treat(){
	super.treat();
	if (((ResidentialBuilding)this.getTarget()).getGasLevel()==0 || ((ResidentialBuilding)this.getTarget()).getGasLevel() == 100)
	 this.jobsDone();
		else
	((ResidentialBuilding)this.getTarget()).setGasLevel(((ResidentialBuilding)this.getTarget()).getGasLevel()-10);
	

	 
	
}
}
