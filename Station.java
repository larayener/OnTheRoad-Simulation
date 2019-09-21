import java.util.ArrayList;

public class Station {
	private ArrayList<Car> cars;
	private ArrayList<Passenger> passengers;
	private int id;
	
	public Station(int id) {
		this.id = id;
		cars = new ArrayList<Car>();
		passengers = new ArrayList<Passenger>();
	}
	
	public int getID() {
		return id;
	}
	
	public void addCar(Car c) {
		cars.add(c);
	}
	
	public void removeCar(Car c) {
		cars.remove(c);
	}
	
	public void addPassenger(Passenger p) {
		passengers.add(p);
	}
	
	public void removePassenger(Passenger p) {
		passengers.remove(p);
	}
	
	public ArrayList<Car> getcars() {
		return cars;
	}
	
	public ArrayList<Passenger> getpassengers() {
		return passengers;
	}
	
	public String toString() {
		String s = "Station number: " + getID() + "\n";
		if (cars.isEmpty()) {
			s+= "There are no cars. ";
		}
		else {
			s+= "List of cars:\n";
			for (Car c : cars) {
				s+= c.toString();
			}
		}
		if (passengers.isEmpty()) {
			s+= "\nThere are no passengers in the station. ";
		}
		else {
			s+= "List of passengers in the station:";
			for (Passenger p : passengers) {
				s+= p.toString();
			}
		}
		return s;
	}
	
}
