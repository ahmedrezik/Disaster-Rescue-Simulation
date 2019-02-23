package model.units;
import java.util.*;

import model.people.Citizen;
import simulation.Address;
abstract class PoliceUnit extends Unit {
private ArrayList<Citizen> passengers;
private int maxCapacity;
public int getMaxCapacity() {
	return maxCapacity;
}
private int distanceToBase;
public int getDistanceToBase() {
	return distanceToBase;
}
public void setDistanceToBase(int distanceToBase) {
	this.distanceToBase = distanceToBase;
}
public PoliceUnit(String id , Address location , int stepsPerCycle , int maxCapacity){
	super(id,location,stepsPerCycle);
	this.maxCapacity = maxCapacity;
}
}
