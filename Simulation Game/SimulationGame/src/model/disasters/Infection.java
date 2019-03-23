package model.disasters;
import model.people.*;
import simulation.Rescuable;
public class Infection extends Disaster{
//A sub-class of Disaster representing an infection that can occur to a citizen
	
	public Infection(int cycle, Citizen target) {
		super(cycle,target);
	}
	public void strike(){ 
		this.setActive(true);
		int x = ((Citizen)getTarget()).getToxicity();
		((Citizen)getTarget()).setToxicity(x+25);
		
		
		
		}
public void cycleStep(){
		
		
		int z = ((Citizen)getTarget()).getToxicity();
		
		((Citizen)getTarget()).setToxicity(z+15);
	
	

	
		
}
	}