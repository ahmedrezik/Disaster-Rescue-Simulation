package simulation;
import java.util.*;
import model.people.Citizen;
import model.infrastructure.ResidentialBuilding;
import model.units.unit;
import model.disasters.Disaster;
public class Simulator {
private int currentCycle;
private ArrayList<ResidentialBuilding> buildings;
private ArrayList<Citizen> citizens;
private ArrayList<unit> emergencyUnits;
private ArrayList<Disaster> plannedDisasters;
private ArrayList<Disaster> executedDisasters;
private Address[][] world;

public Simulator() {
	world= new Address[10][10];
}
}
