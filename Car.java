import java.util.ArrayList;

public class Car {
	private int destination;
	private ArrayList<Passenger> passengers;
	private int currentstation;
	private boolean status;
	private int id;
	private static int lastid = 1;
	
	public Car(int currentstation, int destination) {
		this.destination = destination;
		this.currentstation = currentstation;
		this.passengers = new ArrayList<Passenger>();
		status = false;
		id = lastid;
		lastid++;
	}
	
	public boolean isYolUstunde(Passenger p) {
		if (currentstation!=p.getCurrentStation()) {
			return false;
		}
		if (p.getDestination() > currentstation && p.getDestination() <= destination) {
			return true;
		}
		else if (p.getDestination() < currentstation && p.getDestination() >= destination) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getYolcuSayisi() {
		return passengers.size();
	}
	
	public void pickUp(Passenger p) {
		if (!status && passengers.size() < 3 && isYolUstunde(p)) {
			passengers.add(p);
		}
	}
	
	public void dropOff (Passenger p) {
			passengers.remove(p);
	}

	
	public int getID() {
		return id;
	}
	
	public ArrayList<Passenger> getyolcus() {
		return passengers;
	}
	
	public int getcurrentstation() {
		return currentstation;
	}
	
	public int nextStation() {
		int nextstation = -1;
		if (destination > currentstation) {
			nextstation = currentstation + 1;
		}
		else if (destination < currentstation) {
			nextstation = currentstation - 1;
		}
		else {
			nextstation = -1;
		}
		return nextstation;
	}
	
	public void setcurrentstation(int x) {
		currentstation = x;
	}
	
	public String toString() {
		String s = "[Car " + id + "]\nCurrent station the car is at: " + currentstation + "/ Destination: " + destination + "/ Status: " + status;
		if (passengers.isEmpty()) {
			s+= "\nThe car is empty.\n";
		}
		else {
			s+= "\nList of passengers:\n";
		for (Passenger b : passengers) {
			s+= b.getID() + ", " + b.toString();
		}
		}
		return s;
	}
	
}
