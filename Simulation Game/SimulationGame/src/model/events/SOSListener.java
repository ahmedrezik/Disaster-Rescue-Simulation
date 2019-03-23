package model.events;

import simulation.Rescuable;

public interface SOSListener {

	public void receiveSOSCall(Rescuable r);
	//Add ther rescuable to appropriate list of visivble rescues
	
}
