package model.units;

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
public PoliceUnit(String id , Adress location , int stepsPerCycle , int maxCapacity){
	super();
	this.maxCapacity = maxCapacity;
}
}
