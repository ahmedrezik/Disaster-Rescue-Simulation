package model.disasters;

import model.infrastructure.ResidentialBuilding;

import model.people.*;
import exceptions.BuildingAlreadyCollapsedException;
import exceptions.CitizenAlreadyDeadException;
import exceptions.DisasterException;
import  model.infrastructure.*;
import simulation.Rescuable;
import simulation.Simulatable;

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
	public String getName(){
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
	public void strike() throws DisasterException 
	{
		if(canStrike(target)) {
		target.struckBy(this);
		active=true;
	}
		else {
			if(target instanceof ResidentialBuilding) {
				throw new BuildingAlreadyCollapsedException(this);
			}
			else {
				throw new CitizenAlreadyDeadException(this);
			}
			
		}
		
	}
	
	public boolean canStrike(Rescuable r) {
		if(this instanceof  Collapse || this instanceof Fire || this instanceof GasLeak) {
			if(!(r instanceof ResidentialBuilding)) {
				return false;
			}
			else {
				if(((ResidentialBuilding) r).getDisaster() instanceof Collapse || ((ResidentialBuilding) r).getStructuralIntegrity() <= 0 || ((ResidentialBuilding) r).getFireDamage() >=100 || ((ResidentialBuilding) r).getGasLevel() >=100 || ((ResidentialBuilding) r).getFoundationDamage() >=100  ) {
					return false;
				}
			}
			
		}
		else if(this instanceof Injury || this instanceof Infection) {
			if(!(r instanceof Citizen)) {
				
				return false;
			}
			else {
				if(((Citizen) r).getState() == CitizenState.DECEASED) {
					return false;
				}
			}
		}
		
			return true;
		
		
		
	}
}
