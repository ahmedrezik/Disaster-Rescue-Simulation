package controller;
import simulation.Simulator;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.units.Unit;
public class CommandCenter {
private Simulator engine;
private ArrayList<ResidentialBuilding> visibleBuildings;
private ArrayList<Citizen> visibleCitizens;
private ArrayList<Unit> emergencyUnits;

public CommandCenter() {
engine=new Simulator();
visibleBuildings =new ArrayList<ResidentialBuilding>;
visibleCitizens=new ArrayList<Citizen>;
emergencyUnits=new ArrayList<Unit>;
}
}
