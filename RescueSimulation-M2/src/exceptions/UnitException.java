package exceptions;

import model.units.Unit;
import simulation.Rescuable;

public abstract class UnitException extends SimulationException {
	private Unit unit;
	private Rescuable target;
	
	public UnitException(Unit u,Rescuable r) {
		super();
		this.unit=u;
		this.target=r;
	}
	public UnitException(Unit u,Rescuable r,String message) {
		super(message);
		this.unit=u;
		this.target=r;
	}
	public Unit getUnit() {
		return unit;
	}
	public Rescuable getTarget() {
		return target;
	}
}
