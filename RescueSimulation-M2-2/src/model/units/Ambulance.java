package model.units;

import exceptions.CitizenAlreadyDeadException;
import exceptions.IncompatibleTargetException;
import exceptions.UnitException;
import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;

public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
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

	public void respond(Rescuable r) throws UnitException {
		if(!(r instanceof Citizen)) {
			throw new IncompatibleTargetException(this,this.getTarget(),"Incompatible tYPES");
		}
		else {
			if(getTarget() != null && ((Citizen) getTarget()).getBloodLoss() > 0
		
				&& getState() == UnitState.TREATING && ((Citizen) getTarget()).getState() != CitizenState.DECEASED){
			reactivateDisaster();
			}
			
			
		}
		 
			
		
		
		finishRespond(r);
	}

}
