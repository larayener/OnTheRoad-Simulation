
public class Passenger {
	private int destination;
	private int currentstation;
	private boolean status;
	private int id;
	private static int lastid = 1;
	
	public Passenger(int currentstation, int destination) {
		this.destination = destination;
		this.currentstation = currentstation;
		status = false;
		id = lastid;
		lastid++;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public int getCurrentStation() {
		return currentstation;
	}
	
	public void updateCurrentStation(int station) {
		currentstation = station;
	}
	
	public int getID() {
		return id;
	}
	
	public String toString() {
		String s = "\n[Passenger " + id + "]\nCurrent station the passenger is at: " + currentstation + "/ Destination: " + destination + "/ Status: " + status;
		return s;
	}
	
}
