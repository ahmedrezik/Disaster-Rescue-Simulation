package model.units;

import simulation.Address;


// MileStone 1 Quiz class

public class PoliceCar extends PoliceUnit implements Car{
	private boolean siren;
	
	
	public PoliceCar(String id, Address location, int StepsPerCycle) {
		super(id,location,StepsPerCycle,6);
		
		siren = true;
	}


	public boolean isSiren() {
		return siren;
	}


	public void setSiren(boolean siren) {
		this.siren = siren;
	}
	
	

}
