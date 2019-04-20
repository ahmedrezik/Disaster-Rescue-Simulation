package model.units;

import model.events.WorldListener;
import simulation.Address;

public abstract class FireUnit extends Unit {

	public FireUnit(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		super(unitID, location, stepsPerCycle,w);

	}

}
