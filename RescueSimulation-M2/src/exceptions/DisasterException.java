package exceptions;

import model.disasters.Disaster;

public abstract class DisasterException extends SimulationException{
private Disaster disaster;
public DisasterException(Disaster d) {
	super();
	this.disaster=d;
}
public DisasterException(Disaster d,String message) {
	super(message);
	this.disaster=d;
}
public Disaster getDisaster() {
	return disaster;
}
	
}
