package model.disasters;
import model.infrastructure.*;
import model.people.CitizenState;
import simulation.Rescuable;
import simulation.Simulatable;
import exceptions.BuildingAlreadyCollapsedException;
import exceptions.CitizenAlreadyDeadException;
import exceptions.DisasterException;
import model.people.*;
public abstract class Disaster implements Simulatable{
	private int startCycle;
	private Rescuable target;
	private boolean active;
	public Disaster(int startCycle, Rescuable target) {
		this.startCycle = startCycle;
		this.target = target;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getStartCycle() {
		return startCycle;
	}
	public Rescuable getTarget() {
		return target;
	}
	public void strike() throws DisasterException{
		if((this instanceof Injury || this instanceof Infection) && ((Citizen)this.target).getState() == CitizenState.DECEASED)
		{
			CitizenAlreadyDeadException e = new CitizenAlreadyDeadException(this,"Citizen is dead");
			throw e ;}
		if((this instanceof Collapse || this instanceof GasLeak || this instanceof Fire) &&  (((ResidentialBuilding)this.target).getDisaster() instanceof Collapse ||  ((ResidentialBuilding)this.target).getStructuralIntegrity()==0)) {
			BuildingAlreadyCollapsedException e = new BuildingAlreadyCollapsedException (this,"already collapsed building");
		throw e;
		}
		target.struckBy(this);
		active=true;
	}
	public String toString(){
		if(this instanceof Fire)
			return "Fire hits the Building located in ("+this.target.getLocation().getX()+","+this.target.getLocation().getY()+")";
	    if(this instanceof Collapse)
			return "Collapse the Building located in ("+this.target.getLocation().getX()+","+this.target.getLocation().getY()+")";
		if(this instanceof GasLeak)
			return "GasLeak the Building located in ("+this.target.getLocation().getX()+","+this.target.getLocation().getY()+")";
	    if(this instanceof Injury)
			return "Injury the Citizen located in ("+this.target.getLocation().getX()+","+this.target.getLocation().getY()+")";
		return "Infection the Citizen located in ("+this.target.getLocation().getX()+","+this.target.getLocation().getY()+")";
		
	}
}
