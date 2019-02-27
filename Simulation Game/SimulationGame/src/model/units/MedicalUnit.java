package model.units;
import simulation.Address;
public  abstract class MedicalUnit extends Unit {
	private int healingAmount;//This corresponds to increasing the HP;
	private int treatmentAmount; //This corresponds to decreasing the bloodLoss;
	
    
	public MedicalUnit(String id, Address location, int StepsPerCycle) {
		super(id,location,StepsPerCycle);
		this.healingAmount = 10;
		this.treatmentAmount = 10;
		
		
		
	}
}
