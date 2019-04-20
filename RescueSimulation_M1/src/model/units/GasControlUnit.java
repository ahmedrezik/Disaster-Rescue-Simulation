package model.units;
import model.events.*;
import model.infrastructure.*;
import simulation.Address;
import model.events.*;
public class GasControlUnit extends FireUnit {

	public GasControlUnit(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		super(unitID, location, stepsPerCycle,w);

	}
	public void treat(){
		super.treat();
		if (((ResidentialBuilding)this.getTarget()).getGasLevel()==0 || ((ResidentialBuilding)this.getTarget()).getGasLevel() == 100)
		 this.jobsDone();
			else
		((ResidentialBuilding)this.getTarget()).setGasLevel(((ResidentialBuilding)this.getTarget()).getGasLevel()-10);
		

		 
		
	}
}
