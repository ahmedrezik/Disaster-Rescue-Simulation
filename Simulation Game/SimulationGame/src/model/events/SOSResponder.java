package model.events;

import simulation.Rescuable;

public interface SOSResponder {
	
	//Used by Player during Gameplay to decide unit dispatching to target "r" and update the unit's state
	// if there's another target reintialize the disaster o that target except for Medicsl units in healing phase
	//Set Distance to Target 
public void respond(Rescuable r);

}
