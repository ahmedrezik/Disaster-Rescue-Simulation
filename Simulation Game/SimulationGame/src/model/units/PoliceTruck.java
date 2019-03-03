package model.units;

import simulation.Address;

public class PoliceTruck extends PoliceUnit implements Truck{
	// MileStone 1 Quiz class
	
	private ReconstructionSpeed rspeed;
	
	public PoliceTruck(String id, Address location, int StepsPerCycle, ReconstructionSpeed reconstructionSpeed) {
		super(id,location,StepsPerCycle,20);
		this.rspeed = reconstructionSpeed;
		
		
	}

	public ReconstructionSpeed getRspeed() {
		return rspeed;
	}
	
	
	

}
