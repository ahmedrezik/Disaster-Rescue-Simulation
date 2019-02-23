package simulation;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import model.people.Citizen;
import model.infrastructure.ResidentialBuilding;
import model.units.*;
import model.disasters.Disaster;
public class Simulator {
private int currentCycle;
private ArrayList<ResidentialBuilding> buildings;
private ArrayList<Citizen> citizens;
private ArrayList<Unit> emergencyUnits;
private ArrayList<Disaster> plannedDisasters;
private ArrayList<Disaster> executedDisasters;
private Address[][] world;

public Simulator() throws IOException{
	world= new Address[10][10];
    buildings=new ArrayList<ResidentialBuilding>();
    citizens=new ArrayList<Citizen>();
    emergencyUnits=new ArrayList<Unit>();
    plannedDisasters=new ArrayList<Disaster>();
    this.loadUnits("units.csv");
    this.loadBuildings("buildings.csv");
    this.loadCitizens("citizens.csv");
    this.loadDisasters("disasters.csv");
}

private void loadUnits(String filePath)throws IOException {
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		switch(s[0]) {
		case"AMB":emergencyUnits.add(new Ambulance(s[1],new Address(0,0),Integer.parseInt(s[2])));break;
		case"DCU":emergencyUnits.add(new DiseaseControlUnit(s[1],new Address(0,0),Integer.parseInt(s[2])));break;
		case"EVC":emergencyUnits.add(new Evacuator(s[1],new Address(0,0),Integer.parseInt(s[2]),Integer.parseInt(s[3])));break;
		case"GCU":emergencyUnits.add(new GasControlUnit(s[1],new Address(0,0),Integer.parseInt(s[2])));}		}
}
private void loadBuildings(String filePath) throws IOException{
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		buildings.add(new ResidentialBuilding(new Address(Integer.parseInt(s[0]),Integer.parseInt(s[1]))));
		}
}	
private void loadCitizens(String filePath)throws IOException{
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		citizens.add(new Citizen(new Address(Integer.parseInt(s[0]),Integer.parseInt(s[1])),s[2],s[3],Integer.parseInt(s[4])));
	}
}
private void loadDisasters(String filePath) throws IOException{
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		switch(s[1]){
		case "INJ":
		case"INF":
		case"FIR":
		case"GLK":
		}
}
}
}
