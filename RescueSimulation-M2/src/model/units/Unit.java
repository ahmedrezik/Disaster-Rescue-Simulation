package model.units;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import exceptions.UnitException;
import model.disasters.Disaster;
import model.events.SOSResponder;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Unit implements Simulatable, SOSResponder {
	private String unitID;
	private UnitState state;
	private Address location;
	private Rescuable target;
	private int distanceToTarget;
	private int stepsPerCycle;
	private WorldListener worldListener;
	
	
	

	public Unit(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		this.unitID = unitID;
		this.location = location;
		this.stepsPerCycle = stepsPerCycle;
		this.state = UnitState.IDLE;
		this.worldListener = worldListener;
	}
	public String toString() {
		if (this.target != null) {
			if(this.target instanceof ResidentialBuilding)
			return "Unit ID:"  + this.unitID + "\n" + "Location: (" + this.location.getX() + "," + this.location.getY() + ")" + "\n" + "Unit's Target: Building"+"\n"+"target's location:"+this.target.getLocation() + "\n" +"StepsPerCycle:" +this.stepsPerCycle + "\n" + "Distance to Target:" + this.distanceToTarget + "\n" + "Unit State:" + this.state;
			return  "Unit ID:"  + this.unitID + "\n" + "Location: (" + this.location.getX() + "," + this.location.getY() + ")" + "\n" + "Unit's Target: Citizen"+"\n"+"target's location:"+this.target.getLocation() + "\n" +"StepsPerCycle:" +this.stepsPerCycle + "\n" + "Distance to Target:" + this.distanceToTarget + "\n" + "Unit State:" + this.state; }
		return "Unit ID:"  + this.unitID + "\n" +  "Location: (" + this.location.getX() + "," + this.location.getY() + ")" + "\n" +"StepsPerCycle:" + this.stepsPerCycle + "\n" + "Distance to Target:" + this.distanceToTarget + "\n" + "Unit State:" + this.state ;
	}

	public void setWorldListener(WorldListener listener) {
		this.worldListener = listener;
	}

	public WorldListener getWorldListener() {
		return worldListener;
	}

	public UnitState getState() {
		return state;
	}

	public void setState(UnitState state) {
		this.state = state;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getUnitID() {
		return unitID;
	}

	public Rescuable getTarget() {
		return target;
	}

	public int getStepsPerCycle() {
		return stepsPerCycle;
	}

	public void setDistanceToTarget(int distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
	}

	@Override
	public void respond(Rescuable r) throws UnitException {

		if (target != null && state == UnitState.TREATING)
			reactivateDisaster();
		finishRespond(r);

	}

	public void reactivateDisaster() {
		Disaster curr = target.getDisaster();
		curr.setActive(true);
	}

	public void finishRespond(Rescuable r) throws UnitException {
		if(((this instanceof PoliceUnit || this instanceof FireUnit) && r instanceof ResidentialBuilding) || (this instanceof MedicalUnit && r instanceof Citizen)) {
			if(this.canTreat(r)) { 
			target = r;
		state = UnitState.RESPONDING;
		Address t = r.getLocation();
		distanceToTarget = Math.abs(t.getX() - location.getX())
				+ Math.abs(t.getY() - location.getY());
		}
			else {
					CannotTreatException e=new CannotTreatException(this,r,"CANNOT TREAT");
					throw e;}
			}
		else {
			IncompatibleTargetException e=new IncompatibleTargetException(this,r,"InCompatibleTarget");
			throw e;
		}
		
	}
	public boolean canTreat(Rescuable r){
		if(this instanceof DiseaseControlUnit && r instanceof Citizen && ((Citizen)r).getToxicity()==0)
			return false;
		if(this instanceof Ambulance && r instanceof Citizen && ((Citizen)r).getBloodLoss()==0) 
            return false;
		if(this instanceof FireTruck && r instanceof ResidentialBuilding && ((ResidentialBuilding)r).getFireDamage()==0)
			return false;
		if(this instanceof PoliceUnit && r instanceof ResidentialBuilding && ((ResidentialBuilding)r).getFoundationDamage()==0)
			return false;
		if(this instanceof GasControlUnit && r instanceof ResidentialBuilding && ((ResidentialBuilding)r).getGasLevel()==0)
			return false;
		return true;
	}

	public abstract void treat();

	public void cycleStep() {
		if (state == UnitState.IDLE)
			return;
		if (distanceToTarget > 0) {
			distanceToTarget = distanceToTarget - stepsPerCycle;
			if (distanceToTarget <= 0) {
				distanceToTarget = 0;
				Address t = target.getLocation();
				worldListener.assignAddress(this, t.getX(), t.getY());
			}
		} else {
			state = UnitState.TREATING;
			treat();
		}
	}

	public void jobsDone() {
		target = null;
		state = UnitState.IDLE;
       
	}
}
