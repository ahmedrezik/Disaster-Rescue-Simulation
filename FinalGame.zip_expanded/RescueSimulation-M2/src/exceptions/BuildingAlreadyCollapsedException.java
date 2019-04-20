package exceptions;

import model.disasters.Disaster;

public class BuildingAlreadyCollapsedException extends DisasterException {

	public BuildingAlreadyCollapsedException(Disaster d) {
		super(d);
	}
	public BuildingAlreadyCollapsedException(Disaster d,String message) {
		super(d,message);
	}
}
