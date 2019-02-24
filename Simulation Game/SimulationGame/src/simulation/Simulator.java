package simulation;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import model.people.Citizen;
import model.infrastructure.ResidentialBuilding;
import model.units.*;
import model.disasters.Disaster;
import model.disasters.Fire;
import model.disasters.GasLeak;
import model.disasters.Infection;
import model.disasters.Injury;
public class Simulator {
private int currentCycle;
private static ArrayList<ResidentialBuilding> buildings;
private static ArrayList<Citizen> citizens;
private static  ArrayList<Unit> emergencyUnits;
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

//This method is used to retreive a Building using it's Location
private static ResidentialBuilding retrieveBuilding (int x, int y) {
	Address a = new Address(x,y);
	for(int i =0; i < buildings.size();i++) {
		if(buildings.get(i).getLocation().equals(a)) {
			return buildings.get(i);
		}
	}
	return null;
}


//This method is used to retrieve a Citizen using his ID
private static Citizen retrieveCitizen(String id ) {
	
	for(int i =0; i < citizens.size();i++) {
		if(citizens.get(i).getNationalID().equals(id)) {
			return citizens.get(i);
		}
	}
	return null;
}

//The intialization of Addresses ya Mayouya eh nzmha?
private void loadUnits(String filePath)throws IOException {
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br = new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		switch(s[0]) {
		case"AMB":emergencyUnits.add(new Ambulance(s[1],new Address(0,0),Integer.parseInt(s[2])));break;
		case"DCU":emergencyUnits.add(new DiseaseControlUnit(s[1],new Address(0,0),Integer.parseInt(s[2])));break;
		case"EVC":emergencyUnits.add(new Evacuator(s[1],new Address(0,0),Integer.parseInt(s[2]),Integer.parseInt(s[3])));break;
		case"GCU":emergencyUnits.add(new GasControlUnit(s[1],new Address(0,0),Integer.parseInt(s[2])));}		}
	
	
	br.close();
}
private void loadBuildings(String filePath) throws IOException{
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		buildings.add(new ResidentialBuilding(new Address(Integer.parseInt(s[0]),Integer.parseInt(s[1]))));
		}
	
	br.close();
}	
private void loadCitizens(String filePath)throws IOException{
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		citizens.add(new Citizen(new Address(Integer.parseInt(s[0]),Integer.parseInt(s[1])),s[2],s[3],Integer.parseInt(s[4])));
	}
	br.close();
}
private void loadDisasters(String filePath) throws IOException{
	String currentLine="";
	FileReader fileReader=new FileReader(filePath);
	BufferedReader br=new BufferedReader(fileReader);
	while((currentLine=br.readLine())!=null){
		String[] s=currentLine.split(",");
		
		if(s.length == 4) {
		switch(s[1]){
		
		case"FIR": plannedDisasters.add( new Fire(Integer.parseInt(s[0]),retrieveBuilding (Integer.parseInt(s[2]), Integer.parseInt(s[3]))) ) ;
		case"GLK": plannedDisasters.add( new GasLeak(Integer.parseInt(s[0]),retrieveBuilding (Integer.parseInt(s[2]), Integer.parseInt(s[3]))) ) ;
		}}
		else if(s.length == 3) {
			switch(s[1]){
			case"INJ": plannedDisasters.add( new Injury(Integer.parseInt(s[0]),retrieveCitizen(s[2])));
			case"INF": plannedDisasters.add( new Infection(Integer.parseInt(s[0]),retrieveCitizen(s[2])));
			
			}
			
		}
		else {
			System.out.println("Error with csv file element");
		}
}
	br.close();
}

}
