package exceptions;

import model.disasters.Disaster;

public class CitizenAlreadyDeadException extends DisasterException {

	public CitizenAlreadyDeadException(Disaster d) {
		super(d);
	}
	public CitizenAlreadyDeadException(Disaster d,String message) {
		super(d,message);
	}
}
