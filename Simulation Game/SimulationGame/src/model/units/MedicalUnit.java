package model.units;

public  abstract class MedicalUnit extends Unit {
	
	private int healingAmount;//This corresponds to increasing the HP;
	private int treatAmount; //This corresponds to decreasing the bloodLoss;

	
	public MedicalUnit(String id, Adress location, int StepsPerCycle) {
		super(id,location,StepsPerCycle);
		this.healingAmount = 10;
		this.treatAmount = 10;
		
		
		
	}
}
