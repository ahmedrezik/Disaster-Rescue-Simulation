package model.events;

import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import simulation.Rescuable;

public interface SOSListener {
public void receiveSOSCall(Rescuable r);
}