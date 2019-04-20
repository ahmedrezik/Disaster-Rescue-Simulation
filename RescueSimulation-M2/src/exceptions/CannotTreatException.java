package exceptions;

import model.units.Unit;
import simulation.Rescuable;

public class CannotTreatException extends UnitException {
public CannotTreatException(Unit u,Rescuable r) {
	super(u,r);
}
public CannotTreatException(Unit u,Rescuable r,String message) {
	super(u,r,message);
}
}
