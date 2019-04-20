package simulation;
import model.disasters.*;
public interface Rescuable {

	public void struckBy(Disaster d);
	public Address getLocation();
	public Disaster getDisaster();
}
