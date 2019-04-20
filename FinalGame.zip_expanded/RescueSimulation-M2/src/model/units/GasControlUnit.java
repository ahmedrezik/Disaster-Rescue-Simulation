package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;

public class GasControlUnit extends FireUnit {

	public GasControlUnit(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
	}
	public String toString() {
		 return "Unit type: Gas Control Unit" + "\n"+super.toString()  ;
		
	}


	public void treat() {
		getTarget().getDisaster().setActive(false);

		ResidentialBuilding target = (ResidentialBuilding) getTarget();
		if (target.getStructuralIntegrity() == 0) {
			jobsDone();
			return;
		} else if (target.getGasLevel() > 0) 
			target.setGasLevel(target.getGasLevel() - 10);
		for(int i=0;i<target.getOccupants().size();i++) {
			target.getOccupants().get(i).setOxygenLevel(target.getOccupants().get(i).getOxygenLevel()+15);
		}
		if (target.getGasLevel() == 0)
			jobsDone();

	}

}
