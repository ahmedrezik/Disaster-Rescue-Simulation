
package model.infrastructure;
import simulation.Rescuable;
import model.people.Citizen;
import simulation.Simulatable;
import java.util.*;
import model.disasters.Disaster;
import simulation.Address;
public class ResidentialBuilding implements Simulatable , Rescuable {
 private Address location;
 private int structuralIntegrity  ;
 private int fireDamage ; 
 private int gasLevel;
 private int foundationDamage ;
 private ArrayList<Citizen> occupants ;
 private Disaster disaster;
 
 
public ResidentialBuilding(Address location){
	this.location = location;
	fireDamage = 0 ;
	gasLevel = 0;
	foundationDamage = 0 ;
	occupants = new ArrayList<Citizen>();
	structuralIntegrity = 100;
}
public  Address getLocation() {
	return location;
}

public void setStructuralIntegrity(int structuralIntegrity) {
	this.structuralIntegrity = structuralIntegrity;
}

public int getStructuralIntegrity() {
	return this.structuralIntegrity ;
}

public void setFireDamage(int fireDamage) {
	this.fireDamage = fireDamage;
}
public int getFireDamage() {
	return this.fireDamage;
}
public void setGasLevel(int gasLevel) {
	this.gasLevel = gasLevel;
}
public int getGasLevel() {
	return this.gasLevel;
}
public void setFoundationDamage(int foundationDamage) {
	this.foundationDamage = foundationDamage;
}

public int getFoundationDamage() {
	return this.foundationDamage ;
}
public ArrayList<Citizen> getOccupants() {
	return occupants;
}
public Disaster getDisaster() {
	return disaster;
}

 
}
