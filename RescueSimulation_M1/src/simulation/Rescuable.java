package simulation;
import model.disasters.Disaster;
public interface Rescuable {
	//willContainTheMethodsAvailableForAllRescuableObjects
	
	
	
		public void struckBy(Disaster d);
		public Address getLocation();
		public Disaster getDisaster();
}
