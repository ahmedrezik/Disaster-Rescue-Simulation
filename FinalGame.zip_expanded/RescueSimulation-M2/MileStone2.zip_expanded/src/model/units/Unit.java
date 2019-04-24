package model.units;
import model.people.*;
import model.events.SOSResponder;
import model.events.WorldListener;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;
import model.infrastructure.*;

public abstract class Unit implements Simulatable, SOSResponder {

	private String unitID;
	private UnitState state;
	private Address location;
	private Rescuable target;
	private int distanceToTarget;
	private int stepsPerCycle;
	private WorldListener worldListener;

	public Unit(String unitID, Address location, int stepsPerCycle,WorldListener w) {

		this.unitID = unitID;
		this.location = location;
		this.stepsPerCycle = stepsPerCycle;
		this.state = UnitState.IDLE;
		this.worldListener=w;

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
		if( distanceToTarget <= 0){
			this.distanceToTarget = 0 ;
			worldListener.assignAddress(this, this.target.getLocation().getX(), this.target.getLocation().getY());
			if(this instanceof PoliceUnit) {
				((PoliceUnit)this).setDistanceToBase(this.getManhattanDistance( this.getLocation(), new Address(0,0)));
			}
		}	else
		this.distanceToTarget = distanceToTarget;
	}

	public void setWorldListener(WorldListener worldListener) {
		this.worldListener = worldListener;
	}

	public WorldListener getWorldListener() {
		return worldListener;
	}
//public  void cycleStep(){
	//if(this.distanceToTarget==0){
			//this.state=UnitState.TREATING;
			//this.treat();
		//}	
		//else if(this.state == UnitState.RESPONDING){
				//int x = this.distanceToTarget - this.stepsPerCycle ;
				//this.setDistanceToTarget(x);
				//if(this instanceof PoliceUnit)
					//((PoliceUnit)this).setDistanceToBase(((PoliceUnit)this).getDistanceToBase()+this.stepsPerCycle);
				//}
		//}
	public void cycleStep(){
		 if(this instanceof PoliceUnit) {
			 if(((PoliceUnit)this).getDistanceToBase()==0 && this.state==UnitState.TREATING) {
				this.treat();
				}
			 if(((PoliceUnit)this).getPassengers().size()!=0) {
				if(((PoliceUnit)this).getDistanceToBase()-this.stepsPerCycle<0) {
					int x=this.stepsPerCycle+((PoliceUnit)this).getDistanceToBase()-this.stepsPerCycle;
					this.setDistanceToTarget(this.distanceToTarget+x);
				}else
				this.setDistanceToTarget(this.distanceToTarget+this.stepsPerCycle);
				((PoliceUnit)this).setDistanceToBase(((PoliceUnit)this).getDistanceToBase()-this.stepsPerCycle);
			}
			else {
				if(this.distanceToTarget==0 && this.state==UnitState.IDLE) {
					((PoliceUnit)this).setDistanceToBase(((PoliceUnit)this).getDistanceToBase()-this.stepsPerCycle);
				}
				else if(this.distanceToTarget==0){
					this.state=UnitState.TREATING;
					this.treat();
				}
				else this.setDistanceToTarget(this.distanceToTarget-this.stepsPerCycle);
				
		}
		}else if(this.distanceToTarget==0 && this.state!=UnitState.IDLE){
				this.state=UnitState.TREATING;
				this.treat();
			
		} 
		else if(this.state==UnitState.RESPONDING) {
			this.setDistanceToTarget(distanceToTarget-this.stepsPerCycle);
		}
	}
	
	//public  void cycleStep(){
		//if(this.state == UnitState.RESPONDING){
			//int x = this.distanceToTarget - this.stepsPerCycle ;
			//this.setDistanceToTarget(x);
			//}
		//if(this.state == UnitState.TREATING){
		//	this.treat();
	//	}

	
//}
	public void treat(){
		this.target.getDisaster().setActive(false);
	}
	public void jobsDone(){
		this.setState(UnitState.IDLE);
		this.target=null;
	}
	
	
	
	public void respond(Rescuable r){
	   if(this instanceof MedicalUnit){
		   if(this.getState()==UnitState.RESPONDING)
				 this.getTarget().getDisaster().setActive(true);
			 else if(this.getState()==UnitState.TREATING){
				 if(((Citizen)this.getTarget()).getBloodLoss()!=0 ||((Citizen)this.getTarget()).getToxicity()!=0 )
					 this.getTarget().getDisaster().setActive(true);
			 } 
	   }
	 //ELCASE ELY FADLA LW KHALASET HNAK BS LSA MARG3TSH 3LA ELBASE BYKHALEHA IDLE 3ASHAN MAY-REACTIVATESH EL DISASTER TANY
	   else if(this instanceof PoliceUnit){
		   if(((PoliceUnit)this).getPassengers().size()<((PoliceUnit)this).getMaxCapacity() &&((ResidentialBuilding)this.getTarget()).getOccupants().size()==0) {
		   this.state=UnitState.IDLE;
		   }
		   else if(((PoliceUnit)this).getPassengers().size()<((PoliceUnit)this).getMaxCapacity()) {
			   boolean flag=true;
			   for(int i=0;i<((ResidentialBuilding)this.getTarget()).getOccupants().size();i++) {
				   if(((ResidentialBuilding)this.getTarget()).getOccupants().get(i).getState()!=CitizenState.DECEASED) {
					   flag=false;
				   break;}
			   }
			   if(flag) this.state=UnitState.IDLE;
		   }
	   }
	   else {if(this.state==UnitState.RESPONDING || this.state==UnitState.TREATING){
	    	this.target.getDisaster().setActive(true);
	    }}
		this.target=r;
		this.state=UnitState.RESPONDING;
		this.setDistanceToTarget(getManhattanDistance(this.getLocation(),this.target.getLocation()));
	    
	}
	public int getManhattanDistance(Address x,Address y){
		return Math.abs(x.getX()-y.getX())+Math.abs(x.getY()-y.getY());
	}
}
