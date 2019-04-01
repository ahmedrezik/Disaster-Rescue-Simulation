package model.units;

import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.CitizenState;
import simulation.Address;

public class Evacuator extends PoliceUnit {

	public Evacuator(String unitID, Address location, int stepsPerCycle,WorldListener w, int maxCapacity) {

		super(unitID, location, stepsPerCycle, w,maxCapacity);

	}
	//public void treat(){
		//super.treat();
	    //while(this.getPassengers().size()<this.getMaxCapacity() && ((ResidentialBuilding)this.getTarget()).getOccupants().size()!=0){
	    	//this.getPassengers().add(((ResidentialBuilding)this.getTarget()).getOccupants().get(0));
	    	//((ResidentialBuilding)this.getTarget()).getOccupants().remove(0);
	    //}
	    //if(this.getPassengers().size()==0 && ((ResidentialBuilding)this.getTarget()).getOccupants().size()==0){
	    	//this.jobsDone();
	    //}
	//}
     public void treat(){
    	 super.treat();
    	 boolean flag=true;
    	 if(this.getPassengers().size()==0 &&  ((ResidentialBuilding)this.getTarget()).getOccupants().size()==0)
			 this.jobsDone();
    	 //dy ziadat
    	 else if(this.getPassengers().size()==0 &&  ((ResidentialBuilding)this.getTarget()).getOccupants().size()!=0){
    		 for(int i=0;i<((ResidentialBuilding)this.getTarget()).getOccupants().size();i++) {
    			 if(((ResidentialBuilding)this.getTarget()).getOccupants().get(i).getState()!=CitizenState.DECEASED) {
    				flag=false;
    				break;
    			 }
    		if(flag) {
    			this.jobsDone();
    		}
    		 }
    	 }
	 //elhetta dy metkarra
    	 if(this.getDistanceToBase()==0){
    		 while(!this.getPassengers().isEmpty()){
     			this.getPassengers().get(0).getWorldListener().assignAddress(this.getPassengers().get(0), 0, 0);
     			if(this.getPassengers().get(0).getState()!=CitizenState.DECEASED){
       		      this.getPassengers().get(0).setState(CitizenState.RESCUED);}
     			this.getPassengers().remove(0);
     		 }
        	 }
    		 
    	 else{
    	 while(this.getPassengers().size()<this.getMaxCapacity() && ((ResidentialBuilding)this.getTarget()).getOccupants().size()>0){
    		 if(((ResidentialBuilding)this.getTarget()).getOccupants().get(0).getState()!=CitizenState.DECEASED){
    		 this.getPassengers().add(((ResidentialBuilding)this.getTarget()).getOccupants().get(0));
    		 ((ResidentialBuilding)this.getTarget()).getOccupants().remove(0);}
    		 
    	 }
    	
     }
}}
