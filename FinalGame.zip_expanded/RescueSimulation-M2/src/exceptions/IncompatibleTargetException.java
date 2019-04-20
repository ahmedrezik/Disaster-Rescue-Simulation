package exceptions;

import model.units.Unit;
import simulation.Rescuable;

public class IncompatibleTargetException extends UnitException {
public IncompatibleTargetException(Unit u,Rescuable r) {
	super(u,r);
}
public IncompatibleTargetException(Unit u,Rescuable r,String message) {
	super(u,r,message);
}
}
