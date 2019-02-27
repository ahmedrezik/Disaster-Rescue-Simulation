package model.units;
import java.util.*;

import model.people.Citizen;
import simulation.Address;
abstract class PoliceUnit extends Unit {
private ArrayList<Citizen> passengers;
private int maxCapacity;
private int distanceToBase;

public PoliceUnit(String id , Address location , int stepsPerCycle , int maxCapacity){
	super(id,location,stepsPerCycle);
	this.maxCapacity = maxCapacity;
	passengers = new ArrayList<Citizen>();
}


public int getMaxCapacity() {
	return maxCapacity;
}

public int getDistanceToBase() {
	return distanceToBase;
}
public void setDistanceToBase(int distanceToBase) {
	this.distanceToBase = distanceToBase;
}
}
