package model.units;

import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;
import exceptions.UnitException;
public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
	}
	public String toString() {
		 return "Unit type: Ambulance"+"\n" + super.toString()  ;
		
	}


	@Override
	public void treat() {
		getTarget().getDisaster().setActive(false);

		Citizen target = (Citizen) getTarget();
		if (target.getHp() == 0) {
			jobsDone();
			return;
		} else if (target.getBloodLoss() > 0) {
			target.setBloodLoss(target.getBloodLoss() - getTreatmentAmount());
			if (target.getBloodLoss() == 0)
				target.setState(CitizenState.RESCUED);
		}

		else if (target.getBloodLoss() == 0)

			heal();

	}

	public void respond(Rescuable r) throws UnitException{
		if (getTarget() != null && ((Citizen) getTarget()).getBloodLoss() > 0 && getState() == UnitState.TREATING)
			reactivateDisaster();
		finishRespond(r);
	}

}
