package model.units;
import model.people.*;
import simulation.Address;
public  abstract class MedicalUnit extends Unit {
	private int healingAmount;//This corresponds to increasing the HP;
	private int treatmentAmount; //This corresponds to decreasing the bloodLoss;
	
    
	public MedicalUnit(String id, Address location, int StepsPerCycle) {
		super(id,location,StepsPerCycle);
		this.healingAmount = 10;
		this.treatmentAmount = 10;
		
		
		
	}


	public int getTreatmentAmount() {
		return treatmentAmount;
	}
   public void heal(){
	   if(((Citizen)this.getTarget()).getHp()==100)
		   this.jobsDone();
	   else
	       ((Citizen)this.getTarget()).setHp(((Citizen)this.getTarget()).getHp()+this.healingAmount);
}

	
}
