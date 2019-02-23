package model.units;
import simulation.Simulatable;
import simulation.Address;
abstract public class Unit implements Simulatable,Rescuable {
private String UnitID;
private UnitState state;
private  Address location;
private Rescuable target;
private int distanceToTarget;
private int stepsPerCycle;

public Unit(String id,Address location,int stepsPerCycle) {
	UnitID=id;
	this.location=location;
	this.stepsPerCycle=stepsPercycle;
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
	return UnitID;
}
public Rescuable getTarget() {
	return target;
}
public int getStepsPerCycle() {
	return stepsPerCycle;
}
}
