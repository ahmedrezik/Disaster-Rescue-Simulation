package model.units;
import simulation.Simulatable;
import model.events.WorldListener;
import simulation.Address;
import simulation.Rescuable;


public abstract class Unit implements Simulatable,Rescuable {
private String unitID;
private UnitState state;
private  Address location;
private Rescuable target;
private int distanceToTarget;
private int stepsPerCycle;
private WorldListener worldListener;

public Unit(String id,Address location,int stepsPerCycle) {
	unitID=id;
	this.location=location;
	this.stepsPerCycle= stepsPerCycle;
	this.state=UnitState.IDLE;
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
}
